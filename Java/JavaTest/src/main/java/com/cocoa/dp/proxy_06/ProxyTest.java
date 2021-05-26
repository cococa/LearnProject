package com.cocoa.dp.proxy_06;


public class ProxyTest {

    public static void main(String[] args) {

        FileLoaderExecutor fileLoaderExecutor = new FileLoaderExecutor();
        FileLoaderProxy fileLoaderProxy = new FileLoaderProxy(fileLoaderExecutor);
        fileLoaderProxy.load("./Test.java");

    }

}
