package com.cocoa.proxy.jdk;

import java.io.Serializable;

public class User implements Serializable {

    private String name;
    private Integer id;

    public User(String name, Integer id) {
        this.name = name;
        this.id = id;
    }

    public User( ) {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
