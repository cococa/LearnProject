package com

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main(){

    var a : Int = 10

    runBlocking{
        println("blocking")
        delay(3000)
    }
    print("end")


}