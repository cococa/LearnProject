package com.cocoa.net.base;

import org.junit.Test;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Client {

    @Test
    public void test1() throws IOException {

        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 8888);

        OutputStream outputStream = socket.getOutputStream();

        BufferedWriter bufferedWriter = new BufferedWriter(new PrintWriter(outputStream));

        bufferedWriter.write("hello world");

        bufferedWriter.flush();

        bufferedWriter.close();


    }


}
