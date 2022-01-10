package com.unbong.core.aop;

import com.unbong.core.annotation.RpcAop;
import com.unbong.core.api.RpcfxRequest;
import com.unbong.core.client.MyInvocationHandler;
import com.unbong.core.netty.NettyRequestClient;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.checkerframework.checker.units.qual.A;
import org.springframework.stereotype.Component;

import java.lang.annotation.Target;

@Slf4j
@Aspect
@Component
public class RequestAopHandler {

  @Pointcut(value = "execution( * com.unbong.core.*.MyInvocationHandler.*invoke(..))")
    public void point()
    {}

//    @Around("@annotation(com.unbong.core.annotation.RequestAop)")
//    @Around("target(com.unbong.core.client.MyInvocationHandler)")
    @Around(value = "point()")
    public Object aopInvoke(ProceedingJoinPoint joinPoint) throws Throwable {

        joinPoint.proceed();
        log.info("aopInvoke");
        // 虫annotation中获得 对象服务， 请求函数， 以及参数信息。
        //RpcAop rpcAop = (RpcAop)joinPoint.getSignature().getDeclaringType().getAnnotation(RpcAop.class);
        MyInvocationHandler targetObject = (MyInvocationHandler)joinPoint.getTarget();

        String url = targetObject.getUrl();
        String serviceClass = targetObject.getServiceClass().getName();
        log.info("get Target: {}",joinPoint.getTarget().toString());

//        joinPoint.getMe
        // 生成请求信息S
        log.info("method : {}", targetObject.getMethodName());
        log.info("args {}", targetObject.getArgs());
        RpcfxRequest request = new RpcfxRequest( );
        request.setServiceClass(serviceClass);
        request.setArgs(targetObject.getArgs());
        request.setMethodName( targetObject.getMethodName());

        log.info("request info : {}", request.toString());
//        request.setMethodName();
//        request.setArgs(a);*


        // netty client request
        NettyRequestClient nettyRequestClient = new NettyRequestClient();
        nettyRequestClient.initial();
        nettyRequestClient.post(request,url);


        // 返回反序列化之后的数据。

        return null;
    }
}

