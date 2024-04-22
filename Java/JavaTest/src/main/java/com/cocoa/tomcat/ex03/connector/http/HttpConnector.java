package com.cocoa.tomcat.ex03.connector.http;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpConnector implements Runnable {
    @Override
    public void run() {

        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8080, 1, InetAddress.getByName("127.0.0.1"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Socket socket = null;
        try {
            socket =  serverSocket.accept();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        HttpProcessor httpProcessor = new HttpProcessor();
//        httpProcessor.process(socket);
    }

    public void start() {
        Thread thread = new Thread(this);
        thread.start();
    }
}
