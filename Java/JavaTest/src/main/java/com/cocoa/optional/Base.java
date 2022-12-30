package com.cocoa.optional;


import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Optional;

public class Base {


    @Test
    public void testXXX() throws ParseException {
        Calendar cNow = Calendar.getInstance();
        cNow.add(Calendar.MINUTE, 60 * 24);

        SimpleDateFormat allSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        System.out.println(allSdf.format(cNow.getTime()));
        System.out.println(allSdf.parse("2022-12-30 14:51").after(cNow.getTime()));

    }


    @Test
    public void test() {
//        code1
//        Optional<String> optioanl = Optional.of(null);
//        optioanl.get();
        //  code1 throws java.lang.NullPointerException  ,cuz  of will throw new NullPointerException();
        //  if you want to init null optional , use ofNullable

//        code2
        Optional<String> optional1 = Optional.ofNullable(null);

        // check optional have value
        if (optional1.isPresent()) {
            System.out.println(optional1.get());
        }

        // ofNullable also can pass non-null  value .like this

        Optional<String> optional2 = Optional.ofNullable("name is cocoa");
        if (optional2.isPresent()) {
            System.out.println(optional2.get());
        }

//       Additional methods that depend on the presence or absence of a contained value are provided,
//       such as orElse() (return a default value if value not present) and ifPresent()
//      (execute a block of code if the value is present).

        Optional<String> optional3 = Optional.ofNullable(null);
        String defalut_value = optional3.filter(String::isEmpty).orElse("defalut value");
        System.out.println(defalut_value);


//       here is the source code of methods isPresent and orElse  ,simple to know the orElse
//        public boolean isPresent() {
//            return value != null;
//        }

//        public T orElse(T other) {
//            return value != null ? value : other;
//        }


        // create empty optional
        Optional<String> optEmpty = Optional.empty();
        optEmpty.ifPresent((item) -> System.out.println(item));
//        if(optEmpty.isPresent()) {
//            System.out.println(optEmpty.get());
//        }

        optEmpty.orElseThrow(NullPointerException::new);

    }

    @Test
    public void test2() {
        // stream api

        // use filter
        String result = Optional.of("123")
                .filter((t) -> t.length() > 20)
                .orElse("default");
        System.out.println(result);

        // elseGet

        String result1 = Optional.of("123")
                .filter((t) -> t.length() > 20)
                .orElseGet(() -> "default");
        System.out.println(result1);

        Optional<String> result2 = Optional.of("123").flatMap((t) -> Optional.of(t));
        System.out.println(result2);

        Optional<String> result3 = Optional.of("123").map((t) -> t);
        System.out.println(result3);


        Optional.ofNullable(null).ifPresent((t) -> System.out.println(t));


    }

//    @RuanzhuTest
//    public void test11(){
//
//        Person p = new Person();
//        System.out.println(getName(p));
//
//        p.setName("cocoa");
//        System.out.println(getName(p));
//
//
//    }
//
//
//
//
//    public String getName(Person person){
//        return  Optional.ofNullable(person)
//                .map((p) -> p.getName())
//                .orElse("default");
//
//    }


}
