package com.example.rpcfx.consumer.aop;

import com.unbong.core.annotation.RpcAop;
import com.unbong.core.api.RpcfxRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
//@Aspect
@Slf4j
public class RequestAop {

//    @Pointcut()
    public void point()
    {}

    @Around("@annotation(com.unbong.core.annotation.RequestAop)")
    public Object aopInvoke(JoinPoint joinPoint)
    {

        log.info("aopInvoke");
        // annotation中获得 对象服务， 请求函数， 以及参数信息。
        RpcAop rpcAop = (RpcAop)joinPoint.getSignature().getDeclaringType().getAnnotation(RpcAop.class);
        String url = rpcAop.url();
        String serviceClass = rpcAop.serviceClass().getName();
        log.info("get Target: {}",joinPoint.getTarget().toString());


        // 生成请求信息
        RpcfxRequest request = new RpcfxRequest();
        request.setServiceClass(serviceClass);



        // 返回反序列化之后的数据。

        return null;
    }
}
