package com.example.demo.netty.client;

import com.example.demo.netty.Message;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldPrepender;

/**
 * @author xueyu
 * @date 2020/8/19 11:37
 */
public class NettyClient {

    public static void main(String[] args) {
        start();
    }

    public static void start() {
        Bootstrap clientBootstrap = new Bootstrap();
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();

        clientBootstrap.group(eventLoopGroup).channel(NioSocketChannel.class).handler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel socketChannel) {
                //编码器，类型对应writeAndFlush中类型
                //client端从下往上一次执行decoder
                socketChannel.pipeline().addLast(new LengthFieldPrepender(4));
                socketChannel.pipeline().addLast(new ClientEncoder());
                socketChannel.pipeline().addLast(new ClientChannelHandler());
            }
        });

        try {
            ChannelFuture channelFuture = clientBootstrap.connect("localhost", 8081).sync();
            System.out.println("netty client start...");

            Message message = new Message();
            message.setId(123);
            message.setClazz(234);

            channelFuture.channel().writeAndFlush(message);
            channelFuture.channel().closeFuture().sync();
        } catch (Exception e) {

        }
    }
}
