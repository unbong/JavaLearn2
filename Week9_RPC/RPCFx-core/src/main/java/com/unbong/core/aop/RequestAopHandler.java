package com.unbong.core.aop;

import com.unbong.core.annotation.RpcAop;
import com.unbong.core.api.RpcfxRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.checkerframework.checker.units.qual.A;
import org.springframework.stereotype.Component;

import java.lang.annotation.Target;

@Component
@Aspect
@Slf4j
public class RequestAopHandler {

  @Pointcut(value = "execution( * com.unbong.core.*.MyInvocationHandler.*invoke(..))")
    public void point()
    {}

//    @Around("@annotation(com.unbong.core.annotation.RequestAop)")
//    @Around("target(com.unbong.core.client.MyInvocationHandler)")
    @Around(value = "point()")
    public Object aopInvoke(JoinPoint joinPoint)
    {

        log.info("aopInvoke");
        // 虫annotation中获得 对象服务， 请求函数， 以及参数信息。
        RpcAop rpcAop = (RpcAop)joinPoint.getSignature().getDeclaringType().getAnnotation(RpcAop.class);
        String url = rpcAop.url();
        String serviceClass = rpcAop.serviceClass().getName();
        log.info("get Target: {}",joinPoint.getTarget().toString());

//        joinPoint.getMe
        // 生成请求信息S
        RpcfxRequest request = new RpcfxRequest();
        request.setServiceClass(serviceClass);
//        request.setMethodName();
//        request.setArgs(a);*


        // 返回反序列化之后的数据。

        return null;
    }
}

