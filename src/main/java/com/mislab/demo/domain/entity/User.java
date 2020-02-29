package com.mislab.demo.domain.entity;

import lombok.Data;

/**
 * @Author HanSiyue
 * @Date 2019/12/3 下午8:32
 */
@Data
public class User {
    private Integer userId;
    private Integer identifier;
    private String userName;
    private String password;
    private Integer sex;
    private Integer age;
    private String mail;
    private Integer predictNum;
    private String headUrl;
}
