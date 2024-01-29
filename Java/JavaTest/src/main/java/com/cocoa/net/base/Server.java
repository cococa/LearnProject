package com.cocoa.net.base;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {


    @Test
    public void test1() throws IOException {
        System.out.println("loop");
        ServerSocket serverSocket = new ServerSocket(8888);

        Socket socket =  serverSocket.accept();

        while (true){
            System.out.println("loop");
            socket.getInputStream();


        }


    }




}
