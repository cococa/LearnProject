package com.cocoa.nio.channel;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class TestServerSocketChannel {


    /**
     * ServerSocketChannel + ByteBuffer 实现的简单的服务端程序
     *
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.bind(new InetSocketAddress("127.0.0.1", 8888));

        while (true) {
            Thread.sleep(1000);
            System.out.println("TestServerSocketChannel in Loop");
            SocketChannel socketChannel = serverSocketChannel.accept();
            if (socketChannel != null) {
                ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                while (socketChannel.read(byteBuffer) > -1) {
                    byteBuffer.flip();
                    while (byteBuffer.hasRemaining()) {
                        System.out.print((char) byteBuffer.get());
                    }
                    System.out.print("\n");
                    byteBuffer.flip();
                }
            }
        }


    }

}
