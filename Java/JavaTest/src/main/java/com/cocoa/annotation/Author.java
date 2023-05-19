package com.cocoa.annotation;


import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


// 自定义注解
@Documented
@Target({java.lang.annotation.ElementType.TYPE, java.lang.annotation.ElementType.METHOD}) // 作用于类和方法
@Retention(RetentionPolicy.RUNTIME)  // 保留到运行时
public @interface Author {    // 注意，这里使用的是 @interface 而不是 interface
    String name();
    String group();

    boolean show() default true;
}
