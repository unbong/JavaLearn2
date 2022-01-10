package com.unbong.core.netty;

import com.alibaba.fastjson.JSON;
import com.unbong.core.api.RpcfxRequest;
import com.unbong.core.api.RpcfxResponse;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.*;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.concurrent.Promise;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.nio.charset.StandardCharsets;

@Data
@Slf4j
public class NettyRequestClient {

    private String url;
    private RpcfxRequest request;

    private Bootstrap bootstrap;
    private EventLoopGroup workGroup = new NioEventLoopGroup() ;
    private NettyClientChannelInitializer nettyClientInitializer = new NettyClientChannelInitializer();
    
    public void initial()
    {
        bootstrap = new Bootstrap();
        bootstrap.group(workGroup);
        bootstrap.channel(NioSocketChannel.class);
        bootstrap.option(ChannelOption.SO_KEEPALIVE, true);
        bootstrap.handler(nettyClientInitializer);
    }


    public String post(RpcfxRequest request, String url) throws InterruptedException {

        String result ;
        try
        {


            String json = JSON.toJSONString(request);
            DefaultFullHttpRequest  httpRequest = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.POST, url);


            //httpRequest.headers().set(HttpHeaders.Names.HOST, host);
            httpRequest.headers().set(HttpHeaders.Names.CONNECTION, HttpHeaders.Values.KEEP_ALIVE);
            httpRequest.headers().set(HttpHeaderNames.ACCEPT_ENCODING, HttpHeaderValues.GZIP);
            httpRequest.content().writeBytes(json.getBytes(StandardCharsets.UTF_8));
//        httpRequest.headers().set(HttpHeaders.Names.CONTENT_LENGTH, httpRequest.);
//        httpRequest;
//        httpRequest.setCon
//          Future<RpcfxResponse> res = nettyClientHandler.sendMessage(request);

//          res.addListener(new GenericFutureListener<Future<? super RpcfxResponse>>() {
//              @Override
//              public void operationComplete(Future<? super RpcfxResponse> future) throws Exception {
////                  (RpcfxResponse)future.get();
//
//              }
//          });
            url = url.replaceAll("http://", "");
            url = url.replaceAll(":8080/", "");
            ChannelFuture future = bootstrap.connect(url, 8080).sync();
            future = future.channel().writeAndFlush(httpRequest);
//            channelFuture.

//            channelFuture.addListener(future -> {
//                log.info("res: {}", future.get().toString());
//            });
            future.channel().closeFuture().sync();

        }catch (Exception e){
            e.printStackTrace();
        }

        finally {
            workGroup.shutdownGracefully();
        }



        return "";
    }

}
