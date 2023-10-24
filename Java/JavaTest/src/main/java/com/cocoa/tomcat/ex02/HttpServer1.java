package com.cocoa.tomcat.ex02;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;


/**
 * 需要对webroot 目录下执行  javac -cp .:servlet.jar PrimitiveServlet.java
 *
 *
 * ex02 实现了简单的服务器，可以处理静态资源和servlet \r\n
 * 访问静态资源 http://localhost:8080/index.html
 * 访问servlet  http://localhost:8080/servlet/PrimitiveServlet
 *
 * 存在的问题
 * 1. 静态资源的图片问题
 * 2.
 *
 */
public class HttpServer1 {

    public static void main(String[] args) {
        System.out.println(Constants.WEB_ROOT);

        HttpServer1 httpServer1 = new HttpServer1();
        httpServer1.await();
    }

    public void await() {
        ServerSocket serverSocket = null;
        int port = 8080;
        try {
            serverSocket = new ServerSocket(port, 1, InetAddress.getByName("127.0.0.1"));
        } catch (Exception e) {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            e.printStackTrace();
        }


        while (true) {


            try {
                Socket socket = serverSocket.accept();
                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();

                Request request = new Request(inputStream);
                request.parse();

                Response response = new Response(outputStream);
                response.setRequest(request);

                // check if this is a request for a servlet or a static resource
                // a request for a servlet begins with "/servlet/"
                if (!StringUtils.isEmpty(request.getUri())) {
                    if (request.getUri().startsWith("/servlet/")) {
                        ServletProcessor1 processor = new ServletProcessor1();
                        processor.process(request, response);
                    } else {
                        StaticResourceProcessor processor = new StaticResourceProcessor();
                        processor.process(request, response);
                    }
                }

                socket.close();


            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }


}
