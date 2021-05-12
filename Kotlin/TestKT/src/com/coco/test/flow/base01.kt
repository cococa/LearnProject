package com.coco.test.flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class base01 {


}

fun test1_01(){
    var list = listOf<Int>(1,2,3)

    list.forEach{
        println("${it}")
    }
}


fun test1_02(){
    var list : Sequence<Int> = sequence {
        for (i in 1..3){
            Thread.sleep(1000)
            yield(i)
        }
    }

    list.forEach{
        println("${it}")
    }
}

fun testflow() : Flow<Int> = flow {
    for (item in 1..3){
        Thread.sleep(100)
        emit(item)
    }
}



 suspend fun test1_03(){
    testflow().collect {
        println("---${it}")
    }
}




fun main() = runBlocking{

    launch {
        for (k in 1..3) {
            println("I'm not blocked $k")
            delay(100)
        }
    }
    test1_03()

}
