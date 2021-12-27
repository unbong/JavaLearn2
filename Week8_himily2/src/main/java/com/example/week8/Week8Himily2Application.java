package com.example.week8;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.example.week8.dao")
@ComponentScan({"com.example.week8","org.dromara.hmily"})
public class Week8Himily2Application {

    public static void main(String[] args) {
        SpringApplication.run(Week8Himily2Application.class, args);
    }

}
