package com.mislab.demo.domain.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Author HanSiyue
 * @Date 2019/12/3 下午9:08
 */
@Data
@ApiModel
public class UserPo {
    @ApiModelProperty(name = "userName", value = "用户名", dataType = "string")
    private String userName;
    @ApiModelProperty(name = "mail", value = "邮箱", dataType = "string")
    private String mail;
    @ApiModelProperty(name = "headUrl", value = "头像", dataType = "string")
    private String headUrl;
    @ApiModelProperty(name = "sex", value = "性别", dataType = "integer")
    private Integer sex;
    @ApiModelProperty(name = "age", value = "年龄", dataType = "integer")
    private Integer age;
    @ApiModelProperty(name = "predictNum", value = "预测次数", dataType = "integer")
    private Integer predictNum;

}
