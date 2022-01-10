package com.unbong.core.client;

import com.unbong.core.annotation.RequestAop;
import com.unbong.core.api.Filter;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

@Slf4j
@Component
@Data
public class MyInvocationHandler implements InvocationHandler {


    private  Class<?> serviceClass;
    private   String url;
    private   Filter[] filters;

    private  String methodName;
    private  Object[] args ;

    @Override
    @RequestAop
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log.info("invoke MyInvocationHandler.");
        this.methodName = method.getName();
        this.args = args;

        return "";
    }
}