package com.coco.test.base


val one = 1
var two: Int = 2


fun example(){
    println("123")
}

class Person0x12(){

    var name : String

    init {
        name = "123"
    }
}

public inline fun <T> T.applyTest(block: (T) -> Unit): T {
    block(this)
    return this
}



fun main() {
//        println("the type of one ${typeOf<one>()}")
    val ex = example()  //123
    println(ex)   //kotlin.Unit

    var p = Person0x12().applyTest{
       it.name  = "222"
    }

    listOf<Int>(1,2).run {

    }



    println("${p.name}--")


}