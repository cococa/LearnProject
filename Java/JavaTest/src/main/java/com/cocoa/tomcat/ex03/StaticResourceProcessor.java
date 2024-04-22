package com.cocoa.tomcat.ex03;

import com.cocoa.tomcat.ex02.Processor;
import com.cocoa.tomcat.ex02.Request;
import com.cocoa.tomcat.ex02.Response;

import java.io.IOException;

public class StaticResourceProcessor implements Processor {

    @Override
    public void process(Request request, Response response) {
        try {
            response.sendStaticResource();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
