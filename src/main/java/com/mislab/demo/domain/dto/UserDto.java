package com.mislab.demo.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

/**
 * @Author HanSiyue
 * @Date 2019/12/16 下午7:50
 */
@ApiModel
@Data
@ToString
public class UserDto {
    @ApiModelProperty(name = "userName", value = "用户名", dataType = "string")
    private String userName;
    @ApiModelProperty(name = "password", value = "密码", dataType = "string")
    private String password;
}

