package com.unbong.core.netty;

import com.alibaba.fastjson.JSON;
import com.unbong.core.api.RpcfxRequest;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
public class NettyRequestClient {

    private String url;
    private RpcfxRequest request;

    private Bootstrap bootstrap;
    private EventLoopGroup workGroup = new NioEventLoopGroup() ;
    
    
    public void initial()
    {
        bootstrap = new Bootstrap();
        bootstrap.group(workGroup);
        bootstrap.channel(NioSocketChannel.class);
        bootstrap.option(ChannelOption.SO_KEEPALIVE, true);
        bootstrap.handler(new NettyClientHandler());
    }


    public String post(RpcfxRequest request, String url){
        String json = JSON.toJSONString(request);
        HttpRequest httpRequest = new DefaultHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.POST, url);
        //httpRequest.headers().set(HttpHeaders.Names.HOST, host);
        httpRequest.headers().set(HttpHeaders.Names.CONNECTION, HttpHeaders.Values.KEEP_ALIVE);
//        httpRequest.headers().set(HttpHeaders.Names.CONTENT_LENGTH, httpRequest.);
//        httpRequest;
//        httpRequest.setCon

        return "";
    }

}
