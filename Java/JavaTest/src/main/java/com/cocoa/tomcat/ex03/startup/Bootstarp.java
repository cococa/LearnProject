package com.cocoa.tomcat.ex03.startup;

import com.cocoa.tomcat.ex03.connector.http.HttpConnector;

public class Bootstarp {


    public static void main(String[] args) {

        HttpConnector httpConnector = new HttpConnector();
        httpConnector.start();

    }

}
