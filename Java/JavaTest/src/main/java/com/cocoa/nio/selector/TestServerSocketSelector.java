package com.cocoa.nio.selector;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class TestServerSocketSelector {


    public static void main(String[] args) throws Exception {

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        serverSocketChannel.configureBlocking(false);

        serverSocketChannel.bind(new InetSocketAddress("127.0.0.1", 8888));

        Selector selector = Selector.open();

        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);


        while (true) {
            int i = selector.select(1000);
            if (i > 0) {
                Set<SelectionKey> keys = selector.keys();
                Iterator<SelectionKey> iterator = keys.iterator();
                while (iterator.hasNext()){

                    SelectionKey key = iterator.next();
                    System.out.println(key.readyOps());

                    if(key.isAcceptable()){

                        System.out.println("isAcceptable");
                        ServerSocketChannel keyServerSocketChannel = (ServerSocketChannel) key.channel();
                        SocketChannel socketChannel = keyServerSocketChannel.accept();
                        while (socketChannel == null){
                            socketChannel = keyServerSocketChannel.accept();
                        }
                        socketChannel.configureBlocking(false);
                        socketChannel.register(selector,SelectionKey.OP_READ);
                    }else if (key.isReadable()){
                        System.out.println("isReadable");
                        SocketChannel socketChannel = (SocketChannel) key.channel();

                        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

                        while (socketChannel.read(byteBuffer)>-1){
                            byteBuffer.flip();
                            while (byteBuffer.hasRemaining()){
                                System.out.print((char)byteBuffer.get());
                            }
                            System.out.println("\n");
                            byteBuffer.flip();
                        }
                        socketChannel.close();

                    }else if (key.isWritable()){
                        System.out.println("isWritable");
//                        SocketChannel socketChannel = (SocketChannel) key.channel();

                    }

//                    iterator.remove();

                }
            }
        }
    }


}
