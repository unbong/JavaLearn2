package com.unbong.core.client;

import com.unbong.core.annotation.RequestAop;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

@Slf4j
@Component
public  class MyInvocationHandler implements InvocationHandler {


    @Override
    @RequestAop
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log.info("invoke MyInvocationHandler.");
        return "";
    }
}