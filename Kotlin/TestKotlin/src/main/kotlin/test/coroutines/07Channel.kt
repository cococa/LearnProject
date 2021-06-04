package com.coco.test.coroutines

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.produce

suspend fun main(){
    test7004()
}

suspend fun test7001(){

    val channel = Channel<Int>()
    val job = GlobalScope.launch {
        for (i in 1..5){
            delay(1000)
            channel.also {
                it.send(i * i)
            }
        }
    }

    repeat(5) { println(channel.receive()) }
}


//Closing and iteration over channels
suspend fun test7002(){
    val channel = Channel<Int>()
    val job = GlobalScope.launch {
        for (i in 1..5){
            delay(1000)
            channel.also {
                it.send(i * i)
            }
        }
        channel.close()
    }
    for (c in channel){
        println(c)
    }
}

fun CoroutineScope.produceSquares(): ReceiveChannel<Int> = produce {
    for (x in 1..10){
        delay(1000)
        send(x * x)
    }
}

fun test7003(){
    runBlocking {
        val squares = produceSquares()
        squares.consumeEach { println(it) }
        println("Done!")
    }
}

fun CoroutineScope.produceNumbers() = produce<Int>{
    var i = 0;
    while(true){
        send(++i)
    }
}



fun test7004(){
    runBlocking {
        val produceNumbers = produceNumbers()
        val produceSquares = produceSquares()
        repeat(10){
            val num  = produceSquares.receive()
            println("${num}")
        }
        println("test7004 done!")
        coroutineContext.cancelChildren()
    }
}




