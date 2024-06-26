package com.cocoa.nio;

import org.junit.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class Base {


    public static void main(String[] args) throws IOException {
        File file = new File("./t.iba");
        file.createNewFile();

//        FileWriter fileWriter = new FileWriter(file, true);
//        fileWriter.write("a");
//        fileWriter.write("b");
//        fileWriter.write("我");
//        fileWriter.close();


        FileOutputStream fileOutputStream = new FileOutputStream(file);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
//        ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream;
        DataOutputStream  dataOutputStream = new DataOutputStream(bufferedOutputStream);

        byte[] bytes = "a我b1".getBytes(StandardCharsets.UTF_8);
//        for (int i = 0; i < bytes.length; i++) {
//            System.out.println(bytes[i]);
//        }
//        dataOutputStream.writeByte(97);
//        dataOutputStream.flush();
//        dataOutputStream.close();
//        bufferedOutputStream.close();

        fileOutputStream.write(bytes);
        fileOutputStream.close();




    }


    @Test
    public void test1() {
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);  // create buffer

        print(byteBuffer); //[pos=0 lim=10 cap=10]

        byteBuffer.put((byte) 'H');  // put one element

        print(byteBuffer);   // [pos=1 lim=10 cap=10]  this position was changed

        byteBuffer.flip();   // flip buffer

        print(byteBuffer);  //  [pos=0 lim=1 cap=10]  than  position and limit was exchanged


        // 我我 啊阿萨德
    }

    /**
     * at this dp ,use put and get method
     */
    @Test
    public void testPutGet() {
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);

        //BufferOverflowException    If this buffer's current position is not smaller than its limit
        byteBuffer.put((byte) 's').put((byte) 'h').put((byte) 'e').put((byte) 'n');   //['s','h','e','n']

        print(byteBuffer);  // [pos=4 lim=10 cap=10]

        // change index 0 element and put new element
        byteBuffer.put(0, (byte) 'S').put((byte) 'w');  //['S','h','e','n','w']

        print(byteBuffer);

        // flip == change write mode to read mode
        // limit = position;
        // position = 0;
        // mark = -1;
        byteBuffer.flip();   //[pos=0 lim=5 cap=10]

        print(byteBuffer);

        // dp read buffer ,use get method
        StringBuilder sb = new StringBuilder();

        // use hasRemaining to check position < limit , cuz get method may throws BufferUnderflowException
        while (byteBuffer.hasRemaining()) {
            //BufferUnderflowException
            // If the buffer's current position is not smaller than its limit
            sb.append((char) byteBuffer.get());
        }
        System.out.println(sb); // print Shenw

    }


    private void print(ByteBuffer byteBuffer) {
        System.out.printf("the capcity is %s%n", byteBuffer.capacity());
        System.out.printf("the limit is %s%n", byteBuffer.limit());
        System.out.printf("the position is %s%n", byteBuffer.position());
        System.out.printf("the mark is %s%n", byteBuffer.mark());
        System.out.printf("the buffer is %s%n", byteBuffer);
        System.out.println("---------------------");
        System.out.println("---------------------");
    }


}
