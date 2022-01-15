package com.example.week11;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
@MapperScan("com.example.week11.dao")
public class Week11Application {

    public static void main(String[] args) {
        SpringApplication.run(Week11Application.class, args);
    }

}
