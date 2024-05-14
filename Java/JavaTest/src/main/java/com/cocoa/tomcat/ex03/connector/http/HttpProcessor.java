package com.cocoa.tomcat.ex03.connector.http;

import com.cocoa.tomcat.ex03.ServletProcessor;
import com.cocoa.tomcat.ex03.StaticResourceProcessor;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class HttpProcessor {

    public void process(Socket socket){

        try{

            InputStream inputStream = socket.getInputStream();



            if (request.getRequestURI().startsWith("/servlet/")) {
                ServletProcessor processor = new ServletProcessor();
//                processor.process(request, response);
            } else {
                StaticResourceProcessor processor = new StaticResourceProcessor();
                processor.process(request, response);
            }

            // Close the socket
            socket.close();




//            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
//            BufferedReader reader = new BufferedReader(inputStreamReader);
//            String line = reader.readLine();
//            System.out.println(line);
//            while (line != null && !line.equals("")){
//                line = reader.readLine();
//                System.out.println(line);
//            }
        }catch (Exception e){
            e.printStackTrace();
        }




    }


}
