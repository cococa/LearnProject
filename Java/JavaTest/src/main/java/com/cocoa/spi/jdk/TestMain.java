package com.cocoa.spi.jdk;

import java.util.Iterator;
import java.util.ServiceLoader;


public class TestMain {

    public static void main(String[] args) {


//        通过上面的解析，可以发现，我们使用SPI机制的缺陷：
//        不能按需加载，需要遍历所有的实现，并实例化，然后在循环中才能找到我们需要的实现。如果不想用某些实现类，或者某些类实例化很耗时，它也被载入并实例化了，这就造成了浪费。
//        获取某个实现类的方式不够灵活，只能通过 Iterator 形式获取，不能根据某个参数来获取对应的实现类。
//        多个并发多线程使用 ServiceLoader 类的实例是不安全的。 ¶

        ServiceLoader<TestSpiService> spiLoader = ServiceLoader.load(TestSpiService.class);
        Iterator<TestSpiService> iteratorSpi = spiLoader.iterator();
        while (iteratorSpi.hasNext()) {
            TestSpiService testSpiService = iteratorSpi.next();
            testSpiService.say();
        }

    }

}
