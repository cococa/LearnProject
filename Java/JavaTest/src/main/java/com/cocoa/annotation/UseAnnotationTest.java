package com.cocoa.annotation;


@Author(name = "cocoa", group = "class", show = true)
public class UseAnnotationTest {


    @Author(name = "ccc", group = "method", show = false)
    public String test() {
        return super.toString();
    }
}
