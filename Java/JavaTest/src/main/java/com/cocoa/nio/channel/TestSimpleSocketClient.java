package com.cocoa.nio.channel;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class TestSimpleSocketClient {


    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("127.0.0.1", 8888);

//        socket.getInputStream()

        OutputStream outputStream = socket.getOutputStream();

        PrintWriter p = new PrintWriter(outputStream);

        p.write("Hello12312");

        p.flush();

        p.close();

        outputStream.close();

        socket.close();

    }
}
