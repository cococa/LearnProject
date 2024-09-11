package com.cocoa.service;

import com.cocoa.User;
import com.cocoa.dao.UserDao;
import lombok.Getter;
import lombok.Setter;

public class UserService {


    @Setter
    @Getter
    private UserDao userDao;


    public Boolean addUser(User user) {
        return userDao.addUser(user);
    }

}
