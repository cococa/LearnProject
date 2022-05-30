package com.cocoa.spi.dubbo;


import org.apache.dubbo.common.extension.SPI;

@SPI(value="serviceA")
public interface TestDubooSpiService {
    void say();
}
