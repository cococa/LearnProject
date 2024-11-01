package com.cocoa;


import com.cocoa.dto.User;
import com.cocoa.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class UserTest
{

    @Autowired
    private UserService userService;

    @Autowired
    private User user;

    @Test
    public void testAddUser(){
        userService.addUser(user);
    }



}
