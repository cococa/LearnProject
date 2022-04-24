package com.cocoa.nio.selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.*;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

public class TestServerSocketSelector {

    public static void main(String[] args) throws Exception {


        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        serverSocketChannel.configureBlocking(false);

        serverSocketChannel.bind(new InetSocketAddress("127.0.0.1", 8888));

        Selector selector = Selector.open();


        serverSocketChannel.validOps();
        //  SelectionKey.OP_ACCEPT;
        //  一个channel 并不一定要SelectionKey下的所有操作，channel 支持什么操作，可以用validOps()方法进行查看，  比如 ServerSocketChannel 就只支持 SelectionKey.OP_ACCEPT
        //  而读写连接的操作则需要在  SocketChannel 进行   (SelectionKey.OP_READ | SelectionKey.OP_WRITE | SelectionKey.OP_CONNECT)


//        if (!isOpen())
//            throw new ClosedChannelException();
//        if ((ops & ~validOps()) != 0)
//            throw new IllegalArgumentException();
//        if (isBlocking())
//            throw new IllegalBlockingModeException();
        /**
         *   register 注册时，需要判断 channel 是否打开，注册的操作是否支持，channel 是否是非阻塞的
         *
         */
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);


        while (true) {
            int i = selector.select(1000);
            System.out.println("selector.select i ===>" + i);
            if (i > 0) {
                Set<SelectionKey> keys = selector.selectedKeys();
                System.out.println("key size ===>" + keys.size());
                Iterator<SelectionKey> iterator = keys.iterator();
                while (iterator.hasNext()) {

                    SelectionKey key = iterator.next();
                    System.out.println(key.readyOps());

                    if (key.isAcceptable()) {
                        System.out.println("isAcceptable");
                        ServerSocketChannel accServerSocketChannel = (ServerSocketChannel) key.channel();
                        SocketChannel socketChannel = accServerSocketChannel.accept();
                        System.out.println(socketChannel);
                        socketChannel.configureBlocking(false);

//                        key.interestOps(SelectionKey.OP_READ);
                        socketChannel.register(selector, SelectionKey.OP_READ);

                    } else if (key.isConnectable()) {
                        System.out.println("isConnectable");
                        SocketChannel socketChannel = serverSocketChannel.accept();
                        System.out.println(socketChannel);

                    } else if (key.isReadable()) {

                        SocketChannel socketChannel = (SocketChannel) key.channel();
                        boolean isConnected = socketChannel.isConnected();
                        boolean isBlocking = socketChannel.isBlocking();
                        boolean isConnectionPending = socketChannel.isConnectionPending();
                        System.out.println("isReadable");
                        System.out.println(keys.size());
                        System.out.println(String.format("isConnected=%s isBlocking=%s isConnectionPending=%s", isConnected, isBlocking, isConnectionPending));


                        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                        try {
                            socketChannel.read(byteBuffer);
                        } catch (IOException e) {

                        }
                        byteBuffer.flip();


                        String receivedMsg = new String(byteBuffer.array(), 0, byteBuffer.limit(), StandardCharsets.UTF_8);
                        System.out.println("received  msg :" + receivedMsg);


                        try {

                            if ("bye".equals(receivedMsg)) {
                                ByteBuffer sendMsg = StandardCharsets.UTF_8.encode("ok byte!" + "\n");
                                System.out.println("sendMsg :" + new String(sendMsg.array(), 0, sendMsg.limit(), StandardCharsets.UTF_8));
                                socketChannel.write(sendMsg);
                                socketChannel.close();

                            } else {
                                ByteBuffer sendMsg = StandardCharsets.UTF_8.encode(new Date().getTime() + "\n");
                                System.out.println("sendMsg :" + new String(sendMsg.array(), 0, sendMsg.limit(), StandardCharsets.UTF_8));
                                socketChannel.write(sendMsg);
                            }

                        } catch (IOException e) {

                        }

//                        socketChannel.register(selector,SelectionKey.OP_WRITE);
                        // interestOps 这个要看下
//                        key.interestOps(SelectionKey.OP_WRITE);

                    } else if (key.isWritable()) {
                        System.out.println("isWritable");
                        SocketChannel socketChannel = (SocketChannel) key.channel();

                    }

                    iterator.remove();

                }
                System.out.println("iterator size ===>" + iterator.hasNext());

            }
        }
    }


}
