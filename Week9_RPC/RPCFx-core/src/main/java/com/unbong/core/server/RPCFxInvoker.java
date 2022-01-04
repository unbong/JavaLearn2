package com.unbong.core.server;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.unbong.core.api.RpcfxRequest;
import com.unbong.core.api.RpcfxResolver;
import com.unbong.core.api.RpcfxResponse;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class RPCFxInvoker {
    private final RpcfxResolver resolver;

    public RPCFxInvoker(RpcfxResolver resolver)
    {
        this.resolver = resolver;
    }

    public RpcfxResponse invoke(RpcfxRequest request)
    {
        RpcfxResponse response = new RpcfxResponse();

        String serviceClass = request.getServiceClass();

        //

        try {
            //
            Object service = resolver.resolve(serviceClass);
            Method method =resolveMethodFromClass(service.getClass(), request.getMethodName());
            Object result = method.invoke(service, request.getArgs());
            response.setResult(JSON.toJSONString(result, SerializerFeature.WriteClassName));
            response.setStatus(true);
            return response;

        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            response.setException(e);
            response.setStatus(false);
            return response;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            response.setException(e);
            response.setStatus(false);
            return response;
        } catch (InstantiationException e) {
            e.printStackTrace();
            response.setException(e);
            response.setStatus(false);
            return response;
        } catch (IOException e) {
            e.printStackTrace();
            response.setException(e);
            response.setStatus(false);
            return response;
        }


    }

    private Method resolveMethodFromClass(Class<?> aClass, String methodName) {
        return Arrays.stream(aClass.getMethods()).filter((m)->methodName.equals(m.getName())).findFirst().get();
    }
}
