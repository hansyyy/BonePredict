package com.mislab.demo.controller;

import com.mislab.demo.domain.dto.UserDto;
import com.mislab.demo.domain.entity.Result;
import com.mislab.demo.domain.entity.User;
import com.mislab.demo.service.UserService;
import com.mislab.demo.util.QiniuCloudUtil;
import com.mislab.demo.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * @Author HanSiyue
 * @Date 2019/12/2 下午7:49
 */
@RestController
@RequestMapping("userSystem")
@Api("用户系统")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("login")
    @ApiOperation("用户登陆")
    public Result login(HttpServletRequest request, @RequestBody UserDto userDto) {
        try {
            User user = userService.login(userDto.getUserName(),userDto.getPassword());
            if (user!=null){
                request.getSession().setAttribute("userId",user.getUserId());
                return ResultUtil.success(user.getIdentifier());
            }else {
                return ResultUtil.isNull();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error();
        }
    }

    @PostMapping("register")
    @ApiOperation("用户注册")
    public Result register(HttpServletRequest request, String userName, String password, Integer sex,Integer age, String mail, String verifyCode) {
        try {
            if (userService.selectUserByUserName(userName) != null) {
                return ResultUtil.isExist();
            } else {
                if (userService.register(request, userName, password, sex, age, mail, verifyCode)) {
                    return ResultUtil.success();
                } else {
                    return ResultUtil.error();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error();
        }
    }

    @GetMapping("sendMail")
    @ApiOperation("发送邮件")
    public Result sendMail(HttpServletRequest request){
        try {
            if (userService.sendMail(request)){
                return ResultUtil.success(request.getSession().getAttribute("mailVerifyCode"));
            }else{
                return ResultUtil.error();
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error();
        }
    }

    @GetMapping("createVerifyCode")
    @ApiOperation("生成验证码")
    public void verifycode(HttpServletRequest request, HttpServletResponse response){
        try {
            userService.verifyCode(request,response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @PostMapping("updateInfor")
    @ApiOperation("修改个人资料")
    public Result updateUserInfo(HttpServletRequest request, @RequestParam(value = "file") MultipartFile imageFile, Integer sex, Integer age){
        try {
            byte[] bytes = imageFile.getBytes();
            String headUrl = new QiniuCloudUtil().put64image(bytes, UUID.randomUUID().toString());
            Boolean result = userService.updateUserInfo(request,headUrl,sex,age);
            if (result){
                return ResultUtil.success();
            }else {
                return ResultUtil.error();
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error();
        }
    }

    @GetMapping("displayInfo")
    @ApiOperation("展示个人资料")
    public Result displayInfo(HttpServletRequest request){
        try{
            if (request.getSession().getAttribute("userId")==null){
                return ResultUtil.isNull();
            }else {
                return ResultUtil.success(userService.displayUserInforByUserId(request));
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error();
        }
    }

    @PostMapping("updatePassword")
    @ApiOperation("修改密码")
    public Result updatePassword(HttpServletRequest request,@RequestParam(value = "password")String password,@RequestParam(value = "mailVerifyCode")String mailVerifyCode){
        try {
            if (userService.updatePasswordByUserId(request, password, mailVerifyCode)) {
                return ResultUtil.success();
            } else {
                return ResultUtil.error();
            }
        }catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error();
        }
    }

    @GetMapping("countUserNum")
    @ApiOperation("计算用户总数")
    public Result countUserNum() {
        try {
            return ResultUtil.success(userService.countUserNum());
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error();
        }
    }

}
