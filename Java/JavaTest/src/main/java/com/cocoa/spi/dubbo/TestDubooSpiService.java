package com.cocoa.spi.dubbo;


import org.apache.dubbo.common.extension.SPI;

@SPI(value="serviceB")
public interface TestDubooSpiService {
    void say();
}
