package com.unbong.core.client;

import com.unbong.core.annotation.RequestAop;
import com.unbong.core.api.Filter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


@Slf4j
@Component
public class RpcfxAOP implements ApplicationContextAware{

    private  ApplicationContext applicationContext;
    private Class<?> serviceCLass;
    private String url ;
    private Filter[] filters;

    @Autowired
    MyInvocationHandler myInvocationHandler;
    public   <T> T create(final Class<T> serviceClass,  Filter... filters)
    {
        log.info("create Rpcfx AOP");
//        MyInvocationHandler myInvocationHandler = applicationContext.getBean(MyInvocationHandler.class);
        return (T)Proxy.newProxyInstance(RpcfxAOP.class.getClassLoader(), new Class[]{serviceClass},
                myInvocationHandler );
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }


}
