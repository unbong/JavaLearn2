package com.example.rpcfx.consumer;

import com.unbong.api.User;
import com.unbong.api.UserService;
import com.unbong.core.annotation.RpcAop;
import com.unbong.core.client.RpcfxAOP;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
//@ComponentScan("")
public class RpcFxConsumerApplication {


    public static void main(String[] args) {

//        AnnotationConfigApplicationContext ctx =
//                new AnnotationConfigApplicationContext(RpcfxAOP.class);
        SpringApplication.run(RpcFxConsumerApplication.class, args);
//        RpcfxAOP rpcfxAOP = (RpcfxAOP)ctx.getBean(RpcfxAOP.class);

        @RpcAop( value = "aop",serviceClass = UserService.class, url = "http://localhost:8080/")
        RpcfxAOP rpcfxAOP = new RpcfxAOP();
        UserService userService = rpcfxAOP.create(UserService.class);
        User user = userService.findById(1);

        //log.info("user: {}",user.toString());

    }

}
