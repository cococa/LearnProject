package com.cocoa.proxy;

public class UserServiceImpl implements IUserService {

    @Override
    public User findUserById(Integer id) {
        return new User("name =" + id, id);
    }
}

