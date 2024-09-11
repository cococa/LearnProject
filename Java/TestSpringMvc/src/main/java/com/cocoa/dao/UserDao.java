package com.cocoa.dao;

import com.cocoa.User;

public class UserDao {

    public Boolean addUser(User user) {
        System.out.println("User was added! "+ user);
        return Boolean.TRUE;
    }

}
