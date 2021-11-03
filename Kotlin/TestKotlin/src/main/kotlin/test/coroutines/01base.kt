package com.coco.test.coroutines

import kotlinx.coroutines.*


/**
 * 参考文档
 * 1. 协程  https://mp.weixin.qq.com/s?__biz=MzUyMzk0NTk4OQ==&mid=2247484884&idx=1&sn=17e0033eee4e481ec0d3e4c9bd7d56ee&scene=21
 * 2. 官方文档 https://www.kotlincn.net/docs/reference/coroutines/basics.html
 * 3.         https://kotlinlang.org/docs/coroutines-overview.html
 *
 */

//suspend fun test000() : String{
//    withContext(Dispatchers.IO){
//            delay(1000)
//    }
//    return "123"
//}
//
//
//fun main(){
//     val a  = test000()
//
//}
suspend fun doWorld() = coroutineScope {
    launch {
        delay(2000L)
        println("World 2")
    }
    launch {
        delay(1000L)
        println("World 1")
    }
    println("Hello")
}


suspend fun suspendFunction(){
    delay(100L)
}


fun main() {

//    runBlocking {
//        doWorld()
//        println("Done")
//    }

    test5()

}


fun test1() {
    GlobalScope.launch {    // 启动一个性能的协成
        delay(1000L)
        println("123")
    }
    println("????")
//    Thread.sleep(2000L)
    runBlocking {  // 等待协程结束
        delay(2000)
    }

}

// 但是等待一个协程结束并不是一个好的方案
// 是用join 来等待协成的结束
suspend fun test2() {
    val job = GlobalScope.launch {
        delay(1000)
        println("this is GlobalScope")
    }
    println("main thread")
    job.join()
    println("Ended!!")

}

// 结构化的协程
fun test3() = runBlocking{
        launch {
            delay(1000)
            println("world!")
        }
        println("Hello")

}


//作用域构建器

fun test4() {
    runBlocking {

    }
}


// 挂起函数
//runBlocking 与 coroutineScope 可能看起来很类似，因为它们都会等待其协程体以及所有子协程结束。
//主要区别在于，runBlocking 方法会阻塞当前线程来等待， 而 coroutineScope 只是挂起，会释放底层线程用于其他用途
fun test5() {
    runBlocking {
        launch {
            delayFunction()
        }
        coroutineScope {

            launch {
                delay(3000)
                println("323")
            }

            delay(2000);
            println("223")
        }
        println("hello")
    }
}


// 挂起函数
// 当函数中有挂起的函数时，必须要将函数设置为 suspend
suspend fun delayFunction() {
    delay(1000)
    println("123")
}


fun test6() {
    repeat(100_000) {
        runBlocking {
            launch {
//                delay(1000)
                println("${it}");
            }
        }
    }


}







