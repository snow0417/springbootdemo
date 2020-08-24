package com.example.demo.netty.client;

import com.example.demo.netty.Message;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @author xueyu
 * @date 2020/8/20 18:12
 */
public class ClientEncoder extends MessageToByteEncoder<Message> {


    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Message message, ByteBuf byteBuf) throws Exception {
        byteBuf.writeInt(message.getId());
        byteBuf.writeInt(message.getClazz());
    }
}
