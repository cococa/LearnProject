package com.coco.test.classes

interface Base {
    fun print();
}


class BaseImpl : Base {

    override fun print() {
        println("this print for BaseImpl");
    }
}


class Parent(b: Base) : Base by b


fun main() {

    var baseImpl = BaseImpl();
    Parent(baseImpl).print()

}