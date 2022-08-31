package com.cocoa.validation;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Person extends  BaseClass{

    @NotBlank(message = "name is null!")
    private String name;

    @NotNull(message = "age cannot be null")
    private Integer age;

    @NotNull(message = "address cannot be null")
    private String address;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
