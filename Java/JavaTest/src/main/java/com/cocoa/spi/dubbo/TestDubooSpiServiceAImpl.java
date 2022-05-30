package com.cocoa.spi.dubbo;

public class TestDubooSpiServiceAImpl implements  TestDubooSpiService{
    @Override
    public void say() {
        System.out.println("say hello TestDubooSpiServiceAImpl");
    }
}
