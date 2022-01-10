package com.unbong.core.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.DefaultHttpResponse;
import io.netty.handler.codec.http.DefaultLastHttpContent;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NettyClientResHandler extends ChannelInboundHandlerAdapter {

//    @Override
//    public void channelActive(ChannelHandlerContext ctx) throws Exception {
//        super.channelActive(ctx);
//
//        ctx
//    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        System.out.println(msg.toString());

        DefaultLastHttpContent response = (DefaultLastHttpContent) msg ;
        log.info("get response: {}", response.toString());
//        DefaultFullHttpResponse fullResponse = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK,
//                Unpooled.wrappedBuffer(value.getBytes(StandardCharsets.UTF_8)));
//        response.headers().set("Content-Type", "application/json");
//        response.headers().setInt("Content-Length", response.content().readableBytes());

        ctx.write(response);
    }
}
