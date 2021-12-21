package com.example.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * 程序入口
 *
 * @author liugang
 * @create 2021/12/21
 */
@SpringBootApplication(scanBasePackages = "com.example")
@MapperScan(basePackages = "com.example.web.dao")
public class WebApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }
}
