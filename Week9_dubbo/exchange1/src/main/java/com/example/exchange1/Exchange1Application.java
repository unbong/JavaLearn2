package com.example.exchange1;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.exchange1.dao")
@EnableDubbo
public class Exchange1Application {

	public static void main(String[] args) {
		SpringApplication.run(Exchange1Application.class, args);
	}

}
