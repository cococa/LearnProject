package com.coco.test.test

import com.coco.test.classes.Person


class Person0x999(){
    var name  = "123"
}

fun getPserson() : Person0x999?{
    return null
}



fun main(){

    val nullPerson = getPserson()


    var  p1 = Person0x999().apply {
        this.name  = "p1"
    }
    var p2 = Person0x999().also {
        it.name = "p2"
    }
    println("--p1.name--${p1.name}-----");
    println("--p2.name--${p2.name}-----");


    Person0x999().let {
        it.name = "123"
    }

    println("----takeIf---")
    var p3  = Person0x999().takeIf {
        it.name.equals("p3")
    }
    println("--p3-${p3}--")

    nullPerson?.run{
        this.name = "123"
    }
//    with(){
//        this?.name = "123"
//    }



    // 可空判断
    nullPerson?.apply {
        println("this is null person for apply")
        this.name = "1111"
    }









}

