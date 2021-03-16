package com.coco.test.coroutines

import kotlinx.coroutines.*


fun main() = runBlocking{
    test02()
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