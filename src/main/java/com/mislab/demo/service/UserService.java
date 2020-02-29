package com.mislab.demo.service;

import com.mislab.demo.domain.entity.User;
import com.mislab.demo.domain.po.UserPo;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author HanSiyue
 * @Date 2019/12/2 下午7:49
 */
@Service
public interface UserService {
    /**
     * 登陆
     * @param userName 用户名
     * @param password 密码
     * @return user
     */
    User login(@Param("userName") String userName, @Param("password") String password);

    /**
     * 注册
     * @param request request
     * @param userName 用户名
     * @param password 密码
     * @param sex 性别
     * @param age 年龄
     * @param mail 邮箱
     * @param verifyCode 验证码
     * @return boolean
     */
    Boolean register(HttpServletRequest request,@Param("userName") String userName,@Param("password") String password,@Param("sex") Integer sex,@Param("age")Integer age,@Param("mail") String mail, @Param("verifyCode") String verifyCode);

    /**
     * 根据用户Id查询用户
     * @param request request
     * @return user
     */
    User selectUserByUserId(HttpServletRequest request);

    /**
     * 修改密码
     * @param request request
     * @param password 密码
     * @param mailVerifyCode 邮件验证码
     * @return boolean
     */
    Boolean updatePasswordByUserId(HttpServletRequest request, @Param("password") String password, @Param("mailVerifyCode") String mailVerifyCode);

    /**
     * 修改个人信息
     * @param request request
     * @param headUrl 头像地址
     * @param sex 性别
     * @param age 年龄
     * @return boolean
     */
    Boolean updateUserInfo(HttpServletRequest request,@Param("headUrl") String headUrl,@Param("sex") Integer sex,@Param("age") Integer age);

    /**
     * 发送邮件
     * @param request request
     * @return boolean
     */
    Boolean sendMail(HttpServletRequest request);

    /**
     * 生成验证码
     * @param request request
     * @param response response
     */
    void verifyCode(HttpServletRequest request, HttpServletResponse response);

    /**
     * 根据用户名查询用户
     * @param userName 用户名
     * @return user
     */
    User selectUserByUserName(@Param("userName") String userName);

    /**
     * 展示用户信息
     * @param request request
     * @return userPo
     */
    UserPo displayUserInforByUserId(HttpServletRequest request);

    /**
     * 计算总用户量
     * @return 用户量
     */
    Integer countUserNum();
}
