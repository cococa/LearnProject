package com.cocoa.nio;

import java.io.*;
import java.net.Socket;

public class CommSocketClientTest {


    public static void main(String[] args) throws Exception {

        Socket socket = new Socket("127.0.0.1", 8888);

//        socket.getInputStream()

        OutputStream outputStream = socket.getOutputStream();
        InputStream inputStream = socket.getInputStream();

        int i = 0;

        while (i < 10e10) {
            System.out.println("loop " + i);

            PrintWriter p = new PrintWriter(outputStream);

            if(i==10) {
                p.write("bye");
            }else{
                p.write("hello");
            }

            p.flush();


            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            System.out.println("will readLine ");

            String s = bufferedReader.readLine();

            System.out.println(s);






//            System.out.println("will readLine ");
//            byte[] b = new byte[1024];
//            int res = inputStream.read(b);
//            System.out.println(new String(b,0,res,"UTF-8"));



//            p.close();


            Thread.sleep(1000);

            i++;

        }


        PrintWriter p = new PrintWriter(outputStream);

        p.write("Hello12312");

        p.flush();


        Thread.sleep(1000);

        p.close();

        outputStream.close();

        socket.close();

    }
}
