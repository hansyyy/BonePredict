package com.mislab.demo.domain.entity;

import lombok.Data;

/**
 * @Author HanSiyue
 * @Date 2019/12/16 下午7:50
 */
@Data
public class Result<T> {
    private Integer status;
    private String msg;
    private T data;
}
