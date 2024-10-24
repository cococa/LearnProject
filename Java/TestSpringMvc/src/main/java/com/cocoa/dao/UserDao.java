package com.cocoa.dao;

import com.cocoa.dto.User;
import org.springframework.stereotype.Repository;


@Repository
public class UserDao {

    public Boolean addUser(User user) {
        System.out.println("User was added! "+ user);
        return Boolean.TRUE;
    }

}
