package com.mislab.demo.domain.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author HanSiyue
 * @Date 2020/2/9 下午3:29
 */
@Data
@ApiModel
public class PredictionSimplePo {
    @ApiModelProperty(name = "predictionId", value = "预测结果ID", dataType = "Integer")
    private Integer predictionId;
    @ApiModelProperty(name = "predictTime", value = "预测时间", dataType = "String")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String predictTime;
    @ApiModelProperty(name = "diseaseProb", value = "预测结果", dataType = "Float")
    private Float diseaseProb;
}
