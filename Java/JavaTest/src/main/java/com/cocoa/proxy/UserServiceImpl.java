package com.cocoa.proxy;

import com.cocoa.proxy.jdk.User;

public class UserServiceImpl implements IUserService {

    @Override
    public User findUserById(Integer id) {
        return new User("name =" + id, id);
    }
}

