package com.example.demo.netty.server;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

/**
 * @author xueyu
 * @date 2020/8/20 18:16
 */
public class ServerDecoder extends LengthFieldBasedFrameDecoder {

    public ServerDecoder() {
        super(1024, 0, 4);
    }


    @Override
    protected Object decode(ChannelHandlerContext ctx, ByteBuf in) throws Exception {

        int len = in.readInt();
        ByteBuf byteBuf = in.readBytes(len);
        int id = byteBuf.readInt();
        int clazz = byteBuf.readInt();
        System.out.println("id" +id);
        return null;
    }
}
