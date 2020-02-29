package com.mislab.demo.service.serviceImpl;

import com.mislab.demo.dao.UserDao;
import com.mislab.demo.domain.entity.User;
import com.mislab.demo.domain.po.UserPo;
import com.mislab.demo.service.UserService;
import com.mislab.demo.util.VerifyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.OutputStream;

/**
 * @Author HanSiyue
 * @Date 2019/12/2 下午7:50
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private JavaMailSender javaMailSender;
    @Resource
    private UserDao userDao;
    @Value("${spring.mail.username}")
    private String from;

    @Override
    public User login(String userName, String password) {
        try{
            User user = userDao.login(userName, password);
            if (user!=null){
                return userDao.selectUserByUserId(user.getUserId());
            }else {
                return null;
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Boolean register(HttpServletRequest request, String userName, String password, Integer sex, Integer age, String mail, String verifyCode) {
        try {
            int identifier=2,predictNum=0;
            if (verifyCode.equals(request.getSession().getAttribute("verifyCode"))){
                if (userDao.selectUserByUserName(userName)==null){
                    return userDao.register(identifier,userName,password,sex,age,mail,predictNum);
                }else {
                    System.out.println("已有用户名");
                    return false;
                }
            }else {
                System.out.println("验证码错误");
                return false;
            }
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public User selectUserByUserId(HttpServletRequest request) {
        try {
            Integer userId = (Integer) request.getSession().getAttribute("userId");
            User user = userDao.selectUserByUserId(userId);
            if (user==null){
                return null;
            }else {
                return user;
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Boolean updatePasswordByUserId(HttpServletRequest request, String password, String mailVerifyCode) {
        try {
            if (mailVerifyCode.equals(request.getSession().getAttribute("mailVerifyCode"))){
                User user = userDao.selectUserByUserId((Integer) request.getSession().getAttribute("userId"));
                if (user==null){
                    return false;
                }else {
                    return userDao.updatePasswordByUserId(user.getUserId(),password);
                }
            }else {
                System.out.println("验证码错误");
                return false;
            }
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean updateUserInfo(HttpServletRequest request, String headUrl, Integer sex, Integer age) {
        try {
            User user = userDao.selectUserByUserId((Integer) request.getSession().getAttribute("userId"));
            if (user==null){
                return false;
            }else {
                return userDao.updateUserInfo(user.getUserId(),headUrl,sex,age);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Boolean sendMail(HttpServletRequest request) {
        try{
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
            Integer userId = (Integer)request.getSession().getAttribute("userId");
            User user = userDao.selectUserByUserId(userId);
            Object[] objects = VerifyUtil.createImage();
            request.getSession().setAttribute("mailVerifyCode",objects[0]);
            helper.setFrom(from);
            helper.setTo(user.getMail());
            helper.setSubject("验证码");
            String content = "<html>\n"+
                    "<body>\n" +
                    "<h1 style=\"color: black\">亲爱的"+user.getUserName()+"，您好!</h1><p style=\"color: black\">这是您用于修改密码的验证码：</p><br>"+"<h1 style=\"color: MediumPurple\" align=\"center\">"+objects[0]+"</h1>"+
                    "</body>\n"+
                    "</html>";
            helper.setText(content,true);
            javaMailSender.send(mimeMessage);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public void verifyCode(HttpServletRequest request, HttpServletResponse response) {
        try {
            Object[] objects = VerifyUtil.createImage();
            request.getSession().setAttribute("verifyCode", objects[0]);
            BufferedImage image = (BufferedImage) objects[1];
            response.setContentType("image/png");
            OutputStream os = response.getOutputStream();
            ImageIO.write(image, "png", os);
            os.close();
            System.out.println(objects[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public User selectUserByUserName(String userName) {
        try {
            User user = userDao.selectUserByUserName(userName);
            if (user==null){
                return null;
            }else {
                return user;
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public UserPo displayUserInforByUserId(HttpServletRequest request) {
        try {
            User user = userDao.selectUserByUserId((Integer)request.getSession().getAttribute("userId"));
            UserPo userPo = new UserPo();
            userPo.setUserName(user.getUserName());
            userPo.setHeadUrl(user.getHeadUrl());
            userPo.setMail(user.getMail());
            userPo.setPredictNum(user.getPredictNum());
            userPo.setAge(user.getAge());
            return userPo;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Integer countUserNum() {
        return userDao.countUserNum();
    }
}
