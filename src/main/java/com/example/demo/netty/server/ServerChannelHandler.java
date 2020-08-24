package com.example.demo.netty.server;

import com.example.demo.netty.Message;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author xueyu
 * @date 2020/8/19 11:54
 */
@Slf4j
public class ServerChannelHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        Message message = (Message) msg;
        log.info("message:{}, thread:{}", message, Thread.currentThread().getName());
    }


}
