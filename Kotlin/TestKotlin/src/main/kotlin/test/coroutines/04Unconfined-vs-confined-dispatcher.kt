package com.coco.test.coroutines

import kotlinx.coroutines.*

fun main() = runBlocking {
    test4001()
}

suspend fun test4001(){
    val job = GlobalScope.launch(Dispatchers.Unconfined){
            println("Unconfined before @${Thread.currentThread().name}")
            delay(500)
            println("Unconfined after @${Thread.currentThread().name}")
    }
    job.join()
}