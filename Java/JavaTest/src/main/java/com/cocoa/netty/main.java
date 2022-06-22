package com.cocoa.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.EmptyByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelInboundHandler;
import io.netty.util.ByteProcessor;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.nio.charset.Charset;


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
