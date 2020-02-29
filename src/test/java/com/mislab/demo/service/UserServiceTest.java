package com.mislab.demo.service;

import com.mislab.demo.domain.dto.UserDto;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author HanSiyue
 * @Date 2020/2/11 下午4:38
 */

@RunWith(SpringRunner.class)
@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    void loginTest() {
        UserDto userDto = new UserDto();
        userDto.setUserName("hsy");
        userDto.setPassword("123456");
        Assert.assertNotNull(userService.login(userDto.getUserName(),userDto.getPassword()));

    }
}


/*
@RunWith(SpringRunner.class)
@SpringBootTest

public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void loginTest() {
        UserDto userDto = new UserDto();
        userDto.setUserName("hsy");
        userDto.setPassword("123456");
        UserPo userPo = userService.login(userDto);

        Assert.assertNotNull(userPo);
    }

 */