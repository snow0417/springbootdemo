package com.example.demo.netty.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

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
                socketChannel.pipeline().addLast(new StringEncoder());
                socketChannel.pipeline().addLast(new StringDecoder());
                socketChannel.pipeline().addLast(new ClientChannelHandler());
            }
        });

        try {
            ChannelFuture channelFuture = clientBootstrap.connect("localhost", 8081).sync();
            System.out.println("netty client start...");
            channelFuture.channel().writeAndFlush("hello world.");
            channelFuture.channel().closeFuture().sync();
        }catch (Exception e){

        }
    }
}
