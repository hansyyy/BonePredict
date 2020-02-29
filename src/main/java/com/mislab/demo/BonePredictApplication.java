package com.mislab.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.mislab.demo.dao")
@SpringBootApplication
public class BonePredictApplication {

    public static void main(String[] args) {
        SpringApplication.run(BonePredictApplication.class, args);
    }

}
