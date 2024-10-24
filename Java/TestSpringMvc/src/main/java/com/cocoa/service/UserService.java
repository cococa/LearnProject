package com.cocoa.service;

import com.cocoa.dto.User;
import com.cocoa.dao.UserDao;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    @Autowired
    private UserDao userDao;


    public Boolean addUser(User user) {
        return userDao.addUser(user);
    }

}
