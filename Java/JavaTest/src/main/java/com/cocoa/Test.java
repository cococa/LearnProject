package com.cocoa;

import java.util.*;
import java.util.stream.Collectors;

public class Test {


    public static void main(String[] args) {

        String _fileName = "http:://abadasc.cxcjpcm/aaaa.png";
        String _extensionName = _fileName.substring(_fileName.lastIndexOf(".") + 1);
        System.out.printf("extensionName: %s\n", _extensionName);
//
//        String a = "自卑感";
//        byte[] bytes = a.getBytes();
//        System.out.println(bytes.length);

//        List<String> list = new ArrayList<>();
//        list.add("123");
//        list.add("222");
//
//
//        LinkedList collect = list.stream().collect(Collectors.toCollection(LinkedList::new));
//
//
//        System.out.println(collect.peek());
//        System.out.println(collect.removeFirst());
//        System.out.println(collect.peek());
//        System.out.println(collect.removeFirst());
//        System.out.println(collect.peek());

    }

}
