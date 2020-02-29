package com.mislab.demo.domain.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mislab.demo.domain.entity.Advice;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Author HanSiyue
 * @Date 2020/2/6 下午3:40
 */
@Data
@ApiModel
public class PredictionPo {
    @ApiModelProperty(name = "predictTime", value = "预测时间", dataType = "String")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String predictTime;
    @ApiModelProperty(name = "sex", value = "性别", dataType = "Integer")
    private Integer sex;
    @ApiModelProperty(name = "age", value = "年龄", dataType = "Integer")
    private Integer age;
    @ApiModelProperty(name = "height", value = "身高", dataType = "Float")
    private Float height;
    @ApiModelProperty(name = "weight", value = "体重", dataType = "Float")
    private Float weight;
    @ApiModelProperty(name = "diseaseProb", value = "预测结果", dataType = "Float")
    private Float diseaseProb;
    @ApiModelProperty(name = "advicePo", value = "建议", dataType = "java.util.List")
    private List<AdvicePo> advice;
}
