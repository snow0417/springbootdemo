package com.example.demo.netty.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author xueyu
 * @date 2020/8/19 11:37
 */
public class NettyServer {
    //10M
    private static final int TCP_BAG_LENGTH = 10_485_760;

    public static void main(String[] args) {
        start();
    }

    private static void start() {
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        EventLoopGroup worker = new NioEventLoopGroup();

        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(eventLoopGroup, worker).channel(NioServerSocketChannel.class).childHandler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel socketChannel) {

                //server 端从上往下一次执行decoder
                socketChannel.pipeline().addLast(new ServerDecoder());

                //字符串解码器
                socketChannel.pipeline().addLast(new ServerChannelHandler());
            }
        });
        try {
            ChannelFuture channelFuture = serverBootstrap.bind(8081).sync();

            System.out.println("server start...");
        } catch (Exception e) {

        }
    }
}
