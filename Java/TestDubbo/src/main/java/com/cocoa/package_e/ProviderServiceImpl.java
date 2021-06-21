package com.cocoa.package_e;


public class ProviderServiceImpl implements ProviderService{

    @Override
    public String sayHello(String msg) {
        System.out.println(msg);
        return msg;
    }
}