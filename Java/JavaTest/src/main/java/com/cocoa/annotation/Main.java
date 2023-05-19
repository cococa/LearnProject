package com.cocoa.annotation;


import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) {

        Class<UseAnnotationTest> clz = UseAnnotationTest.class;
        Author annotation = clz.getAnnotation(Author.class);

        //@com.cocoa.annotation.Author(show=true, name="cocoa", group="qq")
        System.out.println(annotation.toString());


        Author author = annotation;
        //@com.cocoa.annotation.Author(show=true, name="cocoa", group="qq")
        System.out.println(author);

        System.out.println("----获取方法上的注解---");
        Method[] declaredMethods = clz.getDeclaredMethods();
        for(Method  m : declaredMethods){
            Author methodAnnotation = m.getAnnotation(Author.class);
            System.out.println(methodAnnotation);
        }

    }
}
