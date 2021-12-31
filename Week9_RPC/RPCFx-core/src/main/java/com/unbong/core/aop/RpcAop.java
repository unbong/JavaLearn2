package com.unbong.core.aop;

import com.unbong.core.api.Filter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE, ElementType.FIELD, ElementType.LOCAL_VARIABLE})
public @interface RpcAop {
    Class<?> serviceClass();
    String url();

}
