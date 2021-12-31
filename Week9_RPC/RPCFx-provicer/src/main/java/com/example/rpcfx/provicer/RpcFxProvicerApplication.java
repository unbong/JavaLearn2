package com.example.rpcfx.provicer;

import com.example.rpcfx.provicer.service.OrderServiceImpl;
import com.example.rpcfx.provicer.service.UserServiceImpl;
import com.unbong.api.OrderService;
import com.unbong.api.UserService;
import com.unbong.core.api.RpcfxRequest;
import com.unbong.core.api.RpcfxResolver;
import com.unbong.core.api.RpcfxResponse;
import com.unbong.core.server.RPCFxInvoker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class RpcFxProvicerApplication {

    @Autowired
    RPCFxInvoker invoker;
    public static void main(String[] args) {
        SpringApplication.run(RpcFxProvicerApplication.class, args);
    }


    //    private static void registerService(CuratorFramework client, String service) throws Exception {
//        ServiceProviderDesc userServiceSesc = ServiceProviderDesc.builder()
//                .host(InetAddress.getLocalHost().getHostAddress())
//                .port(8080).serviceClass(service).build();
//        // String userServiceSescJson = JSON.toJSONString(userServiceSesc);
//
//        try {
//            if ( null == client.checkExists().forPath("/" + service)) {
//                client.create().withMode(CreateMode.PERSISTENT).forPath("/" + service, "service".getBytes());
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//
//        client.create().withMode(CreateMode.EPHEMERAL).
//                forPath( "/" + service + "/" + userServiceSesc.getHost() + "_" + userServiceSesc.getPort(), "provider".getBytes());
//    }

    @PostMapping("/")
    public RpcfxResponse invoke(@RequestBody RpcfxRequest request)
    {
        return invoker.invoke(request);
    }

    @Bean(name = "com.unbong.api.OrderService")
    public OrderService createOrderService()
    {
        return new OrderServiceImpl();
    }

    @Bean(name = "com.unbong.api.UserService")
    public UserService createUserService()
    {
        return new UserServiceImpl();
    }

    @Bean
    public RPCFxInvoker createInvoker(@Autowired RpcfxResolver resolver)
    {
        return new RPCFxInvoker(resolver);
    }

    /**
     * 利用ApplicationContext的查找接口的实现类
     * @return
     */
//    @Bean
//    public RpcfxResolver createResolver()
//    {
//        return new DemoResolver();
//    }

    /**
     * 利用反射的查找接口实现类
     *
     * @return
     */
    @Bean
    public RpcfxResolver createResolver()
    {
        return new ReflectionResolver();
    }
}




