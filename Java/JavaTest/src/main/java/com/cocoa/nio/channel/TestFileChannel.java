package com.cocoa.nio.channel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class TestFileChannel {


    public static void main(String[] args) throws Exception {
        TestFileChannel testChannel = new TestFileChannel();
        testChannel.testFileChannel();

    }


    public void testFileChannel() throws IOException {
        File f = new File("");
        String filename  = f.getAbsolutePath() + File.separator + "build.gradle";
        System.out.println(filename);
        FileInputStream fileInputStream = new FileInputStream(filename);
        FileChannel channel = fileInputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        while(channel.read(byteBuffer)> -1){
            byteBuffer.flip();
            while (byteBuffer.hasRemaining()){
                System.out.print((char)byteBuffer.get());
            }
            byteBuffer.flip();
        }
    }


}
