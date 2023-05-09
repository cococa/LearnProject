package com.cocoa.corutines

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


fun main() {
    test3()
}


fun test1() {
    // runBlocking 是一个Coroutine Builder ，它会创建一个协程并且会阻塞当前线程直到协程执行完毕
    runBlocking {
        // 如果去掉了 runBlocking，launch 会报错，因为 launch 只在 CoroutinesCope 中才能调用
        val j = launch {
            // delay 是一个挂起函数，它将协程的执行暂停了指定的时间。这并不会造成线程的阻塞
            delay(3000)
            println("World")
        }
        println("Hello")
    }
}

fun test2() {
    runBlocking {
        launch {
            delay1()
        }
        println("Hello")
    }
}


suspend fun delay1() {
    delay(3000)
    println("World")
}


fun test3() {
    runBlocking {
        launch {
            delay2()
        }
        println("end")
    }
}


suspend fun delay2() = coroutineScope {
    launch {
        delay(1000)
        println("World1")
    }
    launch {
        delay(1000)
        println("World2")
    }
    println("World3")
}



