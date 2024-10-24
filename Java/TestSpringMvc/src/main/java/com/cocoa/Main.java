package com.cocoa;

import com.cocoa.service.UserService;
import lombok.val;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {







        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");


        Object user = classPathXmlApplicationContext.getBean("user");


        System.out.println(user);
//
//
//        User user1 = classPathXmlApplicationContext.getBean("user", User.class);
//
//        System.out.println( user1);
//
//
//        System.out.println(user == user1);
//
//
//        UserService userService = classPathXmlApplicationContext.getBean("userService", UserService.class);
//        userService.addUser(user1);


    }
}