package com.cocoa.spi.dubbo;

public class TestDubooSpiServiceBImpl implements  TestDubooSpiService{
    @Override
    public void say() {
        System.out.println("say hello --> TestDubooSpiServiceBImpl");
    }
}
