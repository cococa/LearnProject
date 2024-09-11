package com.cocoa;


import lombok.Data;

@Data
public class User {

    private String name;

    private int age;


    public User(){
        System.out.println("User 创建");
    }


    public void init(){
        this.name = "cocoa";
        this.age = 18;
    }


}
