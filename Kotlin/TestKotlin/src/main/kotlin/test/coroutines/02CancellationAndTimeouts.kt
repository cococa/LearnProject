package com.coco.test.coroutines

import kotlinx.coroutines.*


fun main() = runBlocking{
    val job = launch {
        try {
            repeat(1000) { i ->
                println("job: I'm sleeping $i ...")
                delay(500L)
            }
        } finally {
            withContext(NonCancellable) {
                println("job: I'm running finally")
                delay(1000L)
                println("job: And I've just delayed for 1 sec because I'm non-cancellable")
            }
        }
    }
}

suspend fun test02(){
    var job = GlobalScope.launch {
        repeat(1000){
            println("--${it}----${isActive}")
            delay(500)
        }
    }
    delay(1500)
    job.cancelAndJoin()   // 个人理解： cancelAndJoin 并不能保证协程被取消，如果不能被及时取消，可以在协程中使用 isActive
    print("test02 was canceled")
}


suspend fun test01(){
    var job = GlobalScope.launch{
        repeat(100000){ i ->
            println("job: I'm sleeping $i ...${isActive}")
            delay(500L)
        }
    }
    delay(1500L)
    job.cancel()   //如果没有cancel，会一直repeat 下去直到，直到100000
    job.join()
    println("canceled")

}




