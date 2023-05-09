package com.cocoa.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;


//  https://netty.io/4.1/api/index.html


public class main {

    public static void main(String[] args) {

        int a = 5;
        int b = 4;
        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toBinaryString(b));
        System.out.println(Integer.toBinaryString(a | b));
        System.out.println(Integer.toBinaryString(a ^ b));

        byte maxValue = Byte.MAX_VALUE;
        byte minValue = Byte.MIN_VALUE;
        System.out.println(maxValue+"  "+minValue);
        System.out.println(Integer.toBinaryString(128));


        System.out.println(Integer.parseInt(Integer.toBinaryString(110)));



        ByteBuf heapBuf = Unpooled.buffer();
        heapBuf.writeByte(123);
        heapBuf.writeByte(123);
        heapBuf.writeByte(123);
        heapBuf.writeByte(123);
        heapBuf.writeByte(123);
        heapBuf.writeByte(123);
        heapBuf.writeByte(123);

        System.out.println(heapBuf);




    }

}
