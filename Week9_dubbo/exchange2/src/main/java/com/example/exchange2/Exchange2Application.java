package com.example.exchange2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.exchange2.dao")
public class Exchange2Application {

    public static void main(String[] args) {
        SpringApplication.run(Exchange2Application.class, args);
    }

}
