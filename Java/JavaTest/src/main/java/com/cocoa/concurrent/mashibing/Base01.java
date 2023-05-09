package com.cocoa.concurrent.mashibing;

public class Base01 {

    private final Object o  = new Object();
    private int count = 10;

    public void start(){
        synchronized(o){
            count--;
            System.out.print("exit");
        }
    }

    public static void main(String[] args){
            Base01  base01 = new Base01();
            base01.start();
    }

}
