package com.mislab.demo.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @Author HanSiyue
 * @Date 2020/2/6 下午3:33
 */
@Data
public class Prediction {
    private String predictTime;
    private Integer userId;
    private Integer predictionId;
    private Float diseaseProb;
    private Integer adviceId;
    private Integer sex;
    private Integer age;
    private Float height;
    private Float weight;
    private Float alb;
    private Float ca;
    private Float p;
    private Float alp;
    private Float hb;
    private Float lym;
    private Float bmd;

}
