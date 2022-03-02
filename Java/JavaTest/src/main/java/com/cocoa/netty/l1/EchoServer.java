package com.cocoa.netty.l1;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.jetbrains.annotations.NotNull;

import java.net.InetSocketAddress;

public class EchoServer {


    public static void main(String[] args) throws Exception {

        new EchoServer().start(8888);

    }


    public void start(int port) throws Exception {
        final EchoServerHandler echoServerHandler = new EchoServerHandler();
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();

        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(eventLoopGroup)
                    .channel(NioServerSocketChannel.class)
                    .localAddress(new InetSocketAddress(port))
                    .childHandler(new ChannelInitializer<SocketChannel>() {

                        @Override
                        protected void initChannel(@NotNull SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(echoServerHandler);
                        }
                    });
            ChannelFuture sync = serverBootstrap.bind().sync();
            sync.channel().closeFuture().sync();

        } finally {
            eventLoopGroup.shutdownGracefully().sync();
        }


    }


}
