package com.mislab.demo.dao;

import com.mislab.demo.domain.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


/**
 * @Author HanSiyue
 * @Date 2019/12/3 下午8:37
 */
@Repository
public interface UserDao {

    /**
     * 登陆
     * @param userName 用户名
     * @param password 密码
     * @return user
     */
    User login(@Param("userName") String userName,@Param("password") String password);

    /**
     * 注册
     * @param identifier 身份码
     * @param userName 用户名
     * @param password 密码
     * @param sex 性别
     * @param age 年龄
     * @param mail 邮箱
     * @param predictNum 预测次数
     * @return boolean
     */
    Boolean register(@Param("identifier") Integer identifier,@Param("userName") String userName,@Param("password") String password,@Param("sex") Integer sex,@Param("age") Integer age,@Param("mail") String mail,@Param("predictNum") Integer predictNum);

    /**
     * 根据用户Id查询用户
     * @param userId 用户Id
     * @return user
     */
    User selectUserByUserId(@Param("userId") Integer userId);

    /**
     * 修改密码
     * @param userId 学号
     * @param password 密码
     * @return boolean
     */
    Boolean updatePasswordByUserId(@Param("userId") Integer userId,@Param("password") String password);

    /**
     * 修改个人资料
     * @param userId 用户Id
     * @param headUrl 头像地址
     * @param sex 性别
     * @param age 年龄
     * @return boolean
     */
    Boolean updateUserInfo(@Param("userId") Integer userId, @Param("headUrl") String headUrl, @Param("sex") Integer sex,@Param("age") Integer age);

    /**
     * 根据用户名查询用户
     * @param userName 用户名
     * @return user
     */
    User selectUserByUserName(@Param("userName") String userName);

    /**
     * 计算总用户量
     * @return 用户量
     */
    Integer countUserNum();


}
