package com.cocoa.lambda;

import com.cocoa.lambda.bean.Item;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Join {

    public static void main(String[] args) {

//        Stream.generate(() -> Math.random()).limit(10)
//                .flatMap(item -> item.)
//                .forEach(System.out::println);

//        List<String> list = Arrays.asList("tom", "jame", "jerry", "hello");
//        Stream<String> stream = list.stream();
//        Stream<String[]> streamString = stream.map(s->s.split(""));
//
//        streamString.forEach(x->{
//            System.out.println(x);
//        });
//
//
//
//
//        Stream<String> map = streamString.flatMap(Arrays::stream);
//
//        map.forEach(x->{
//            System.out.println(x);
//        });




        List<Item> list = new ArrayList<>();
        list.add(new Item("name1", 1));
        list.add(new Item("name2", 2));
        list.add(new Item("name3", 3));
        list.add(new Item("name4", 4));

        list.stream().forEach(item -> {
            int[] re = Stream.generate(() -> Math.random() * 100)
                    .limit(4)
                    .mapToInt((it) -> it.intValue())
                    .toArray();
            item.setIds(re);
        });



         list.stream()
                  .flatMapToInt((item) -> Arrays.stream(item.getIds()))
                 .count();
                 //.forEach(System.out::println);




//
//        String s1 = list.stream()
//                .map(Item::getName)
//                .collect(Collectors.joining("||"));
//        System.out.println(s1);
//
//        Optional<Integer> listSum = list.stream()
//                .map(Item::getAge)
//                .reduce(Integer::sum);
//        System.out.println(listSum);


    }


}
