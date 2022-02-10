package com.cocoa.controlFlow


fun main() {
    val a: Int = 10
    var b: Int = 20


    val min = if (a < b) a else b

    val max = if (a > b) {
        println("max is a")
        a
    } else {
        println("max is b ")
        b

    }

    println("max = ${max}, min = ${min}")



    when (max) {
        a -> println("aaaaa")
        b -> println("bbbbbb")

        else -> {
            println("else")
        }
    }


    // for loop
    val list  = mutableListOf<Int>(1,2,3)

    for (item in  list) println("simple=>${item}")
    for (item : Int in  list){
        println("${item}")
    }

    for((item,index) in list.withIndex()){
        println("${item}--${index}")
    }





}