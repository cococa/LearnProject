package com.cocoa.spi.dubbo;


import org.apache.dubbo.common.extension.ExtensionLoader;

public class TestMain {

    public static void main(String[] args) {

        // 使用dubbo 扩展的 SPI
        // 优点：
        // 1. service 配置文件的可以定义多个impl,并且可以用key=value形式存储，按需加载

        ExtensionLoader<TestDubooSpiService> extensionLoader = ExtensionLoader.getExtensionLoader(TestDubooSpiService.class);

        // 可以获取默认的 extension ，但是需要在 @spi 指定 value
        TestDubooSpiService testDubooSpiService = extensionLoader.getDefaultExtension();
        // 也可以直接使用getExtension（）
//      TestDubooSpiService testDubooSpiService = extensionLoader.getExtension("serviceA");


       testDubooSpiService.say();


    }

}
