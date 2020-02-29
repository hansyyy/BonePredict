package com.mislab.demo.domain.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author HanSiyue
 * @Date 2020/2/12 下午5:12
 */
@Data
@ApiModel
public class AdvicePo {
    @ApiModelProperty(name = "advice", value = "建议", dataType = "string")
    private String advice;
    @ApiModelProperty(name = "level", value = "级别", dataType = "integer")
    private Integer level;
}
