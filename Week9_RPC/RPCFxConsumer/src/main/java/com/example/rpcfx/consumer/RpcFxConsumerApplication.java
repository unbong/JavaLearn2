package com.example.rpcfx.consumer;

import com.unbong.api.User;
import com.unbong.api.UserService;
import com.unbong.core.annotation.RpcAop;
import com.unbong.core.client.RpcfxAOP;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@Slf4j
@SpringBootApplication
@ComponentScan("com.unbong.core")
public class RpcFxConsumerApplication {


    public static void main(String[] args) {


        ApplicationContext ctx = SpringApplication.run(RpcFxConsumerApplication.class, args);

//        AnnotationConfigApplicationContext ctx =
//                new AnnotationConfigApplicationContext(RpcfxAOP.class);

        RpcfxAOP rpcfxAOP = ctx.getBean(RpcfxAOP.class);

        UserService userService = rpcfxAOP.create(UserService.class,"http://localhost:8080/");

        User user = userService.findById(1);

        log.info("user: {}",user.toString());

    }

}
