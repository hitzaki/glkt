package com.xuanchen.glkt.activity;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@MapperScan("com.xuanchen.glkt.activity.mapper")
@SpringBootApplication
@EnableFeignClients("com.xuanchen.glkt")
@ComponentScan(basePackages = "com.xuanchen.glkt")
public class ActivityApplication {
    public static void main(String[] args) {
        SpringApplication.run(ActivityApplication.class, args);
    }
}
