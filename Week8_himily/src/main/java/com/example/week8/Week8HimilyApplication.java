package com.example.week8;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.week8.dao")
@EnableEurekaClient
public class Week8HimilyApplication {

    public static void main(String[] args) {
        SpringApplication.run(Week8HimilyApplication.class, args);
    }

}
