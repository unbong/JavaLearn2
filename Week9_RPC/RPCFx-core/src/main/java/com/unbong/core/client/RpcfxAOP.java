package com.unbong.core.client;

import com.unbong.core.api.Filter;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Getter
@Slf4j
public class RpcfxAOP implements ApplicationContextAware{

    private ApplicationContext applicationContext;
    private Class<?> serviceCLass;
    private String url ;
    private Filter[] filters;

    public RpcfxAOP ()
    {
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext();
        ctx.register(RpcfxAOP.class);
    }

    public  <T> T create(final Class<T> serviceClass,  Filter... filters)
    {
        log.info("create Rpcfx AOP");

        return (T)applicationContext.getBean(serviceClass.getName());
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
