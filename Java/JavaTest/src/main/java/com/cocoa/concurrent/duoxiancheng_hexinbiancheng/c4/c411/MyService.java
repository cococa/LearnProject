package com.cocoa.concurrent.duoxiancheng_hexinbiancheng.c4.c411;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyService {

    private final Lock lock = new ReentrantLock();


    public void testMethod() {
        lock.lock();
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName());
        }
        lock.unlock();
    }


}
