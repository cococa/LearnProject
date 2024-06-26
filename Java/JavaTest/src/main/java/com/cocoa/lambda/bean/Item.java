package com.cocoa.lambda.bean;

public class Item {

    public String name;
    public int age;

    public int[] ids;


    public int[] getIds() {
        return ids;
    }

    public void setIds(int[] ids) {
        this.ids = ids;
    }

    public Item(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
