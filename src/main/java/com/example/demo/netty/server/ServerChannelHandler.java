package com.example.demo.netty.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author xueyu
 * @date 2020/8/19 11:54
 */
public class ServerChannelHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        System.out.println("channel active:" + ctx.name());
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        System.out.println("message:" + String.valueOf(msg));
        ctx.writeAndFlush("server response hello world.");
    }


}
