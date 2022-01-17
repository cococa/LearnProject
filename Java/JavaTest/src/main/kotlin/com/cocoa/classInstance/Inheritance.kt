package com.cocoa.classInstance

/**
 * 1. 所有的类都有一个超类，Any
 * 2. 所有的类都有三个方法，equals toString hashCode
 * 3. class 默认都是final 的，无法被继承，如果要使用继承，则要在父类的class 的加上 open
 *
 *
 *
 */

open  class Parent{

}
class Children: Parent(){

}





fun main(){
    println("123")
}