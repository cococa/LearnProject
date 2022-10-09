package com.cocoa.jvm;

import java.util.ArrayList;
import java.util.List;

public class Test1 {

    public void test1() {


    }


    public static void main(String[] args) {

//        List<Object> list = new ArrayList<Object>();
//        for (int i = 0; i < 100000000000L; i++) {
//            list.add(new Object());
//        }

        long m = 1200;
        long h = 4;
//        long result = 1;
//        for (int i = 1; i < h; i++) {
//            result = result *b;
//        }

        System.out.println((m*m*m*m-1)/(m-1));


    }


}
