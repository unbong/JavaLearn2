package com.unbong.core.client;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;
import com.unbong.core.api.*;
import lombok.extern.slf4j.Slf4j;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public final class RpcfxDynamic {
    static{
        ParserConfig.getGlobalInstance().addAccept("com.unbong");
    }

    public static <T, filters> T createFromRegistry(final Class<T> serviceClass, final String zkUrl, Router router,
                                                    LoadBalance loadBalance, Filter filter)
    {
        // 加Filter 之一
        //
        List<String> invoker = new ArrayList<>();

        List<String> urls = router.route(invoker);
        String url = loadBalance.select(urls);

        return (T)create(serviceClass, url, filter);
    }

    public static<T> T create(final Class<T> serviceClass, final String url, Filter ... filters)
    {

        // 使用动态代理的方式执行访问过程
        return (T)Proxy.newProxyInstance(RpcfxDynamic.class.getClassLoader(), new Class[]{serviceClass},
                new RpcfxInvovationHandler(serviceClass, url, filters));

        //return (T) Proxy.newProxyInstance(serviceClass.getClassLoader(), serviceClass.getInterfaces(), new RpcfxInvovationHandler(serviceClass, url, filters));
    }


    public static class RpcfxInvovationHandler implements InvocationHandler {

        public static  final MediaType JSONTYPE =MediaType.get("application/json; charset=utf-8");

        private final Class<?> serviceClass;
        private  final String url;
        private  final Filter[] filters;

        public <T> RpcfxInvovationHandler(Class<T> serviceClass, String url, Filter... filters) {

            this.serviceClass = serviceClass;
            this.url = url;
            this.filters = filters;
        }


        /**
         *
         * @param proxy
         * @param method
         * @param args
         * @return
         * @throws Throwable
         */
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

            RpcfxRequest request = new RpcfxRequest();
            request.setServiceClass(this.serviceClass.getName());
            request.setMethodName(method.getName());
            request.setArgs(args);

            if (null != this.filters) {
                for (Filter filter : filters) {
                    if (!filter.filter(request)) {
                        return null;
                    }
                }
            }

            RpcfxResponse response = post(request, url);

            Object obj =JSON.parse(response.getResult().toString());

            return obj;

        }

        

        /**
         * OKHttp 发送请求
         * @param request
         * @param url
         * @return
         * @throws IOException
         */
        private RpcfxResponse post(RpcfxRequest request, String url) throws IOException {

            String Json = JSON.toJSONString(request);
            log.info("request json: {}", Json);

            // 1 可以服用client
            // 2 尝试使用http client 或 netty client

            OkHttpClient httpClient = new OkHttpClient();
            //final Request req = new Request.Builder()
            final  Request req =  new  Request.Builder()
                     .url(url)
                    .post(RequestBody.create(JSONTYPE,Json))
                    .build();

            String resJson = httpClient.newCall(req).execute().body().string();

            log.info("ResJson：{}", resJson);
            return JSON.parseObject(resJson, RpcfxResponse.class);
        }



    }
}
