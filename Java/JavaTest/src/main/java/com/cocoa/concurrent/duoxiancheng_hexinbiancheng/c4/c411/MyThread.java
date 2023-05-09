package com.cocoa.concurrent.duoxiancheng_hexinbiancheng.c4.c411;

public class MyThread extends Thread {

    private final MyService myService;

    public MyThread(MyService myService) {
        this.myService = myService;
    }

    @Override
    public void run() {
        this.myService.testMethod();
    }
}
