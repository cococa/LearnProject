package com.coco.test.Standardlibrary.scopefunctions

import kotlin.random.Random


fun test(msg : String) : Unit{

}


fun main() {

    var str = "Hello";


    val newStr = str.apply {

    }


    str.run {
        println("--${length}--");  // this.length
    }

    val a: Unit = str.let {
        println("--${it.length}--")
    }
    println("--${a}--")


    str.let(::test)



}

//The scope functions differ by the result they return:
//apply and also return the context object.
//let, run, and with return the lambda result.

// 使用 also 和 apply 可以直接return
fun getRandomInt(): Int {
    return Random.nextInt(100).also {
        println("getRandomInt() generated value $it")
    }
}