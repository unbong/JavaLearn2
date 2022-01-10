package com.unbong.core.netty;

import com.unbong.core.api.RpcfxRequest;
import com.unbong.core.api.RpcfxResponse;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.DefaultHttpRequest;
import io.netty.handler.codec.http.DefaultHttpResponse;
import io.netty.util.concurrent.EventExecutorGroup;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.Promise;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.BufferOverflowException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

@Slf4j
public class NettyClientHandler extends SimpleChannelInboundHandler<RpcfxResponse> {

    private ChannelHandlerContext ctx;
    private BlockingQueue<Promise<RpcfxResponse>> messageList = new ArrayBlockingQueue<>(16);

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
        this.ctx = ctx;
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        super.channelInactive(ctx);
        synchronized (this) {
            Promise<RpcfxResponse> prom;
            while ((prom = messageList.poll()) != null)
                prom.setFailure(new IOException("Connection lost"));
            messageList = null;
        }
    }

    public Future<RpcfxResponse> sendMessage(RpcfxRequest request)
    {
        return sendMessage(request, ctx.executor().newPromise());
    }

    public Future<RpcfxResponse> sendMessage(RpcfxRequest request, Promise<RpcfxResponse> prom)
    {
        synchronized (this)
        {
            if(messageList == null)
            {
                // 连接关闭
                prom.setFailure(new IllegalStateException());
            }
            else if(messageList.offer(prom))
            {
                // 连接建立
                ctx.writeAndFlush(request);

            }else
            {
                // 连接失败，请求被拒绝
                prom.setFailure(new BufferOverflowException());
            }

            return prom;
        }
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, RpcfxResponse msg) throws Exception {
        synchronized (this)
        {
            if(messageList != null)
            {
                log.info("res {}",msg.getResult().toString());
                messageList.poll().setSuccess(msg);
            }
        }
    }


//    @Override
//    protected void messageReceived(ChannelHandlerContext ctx, RpcfxResponse res) {
//        synchronized(this){
//            if(messageList != null) {
//                messageList.poll().setSuccess(res);
//            }
//        }
//    }

//    @Override
//    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception
//    {
//        log.info(msg.toString());
//
//        DefaultHttpResponse res = (DefaultHttpResponse)msg;
//
//        ctx.write(msg);
//    }



//    @Override
//    protected void channelRead0(ChannelHandlerContext channelHandlerContext, String o) throws Exception {
//
//
//    }
}
