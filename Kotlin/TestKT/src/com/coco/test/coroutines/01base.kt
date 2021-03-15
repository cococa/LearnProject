package com.coco.test.coroutines

import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext


/**
 * 参考文档
 * 1. 协程  https://mp.weixin.qq.com/s?__biz=MzUyMzk0NTk4OQ==&mid=2247484884&idx=1&sn=17e0033eee4e481ec0d3e4c9bd7d56ee&scene=21
 * 2. 官方文档 https://www.kotlincn.net/docs/reference/coroutines/basics.html
 *
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


 fun main(){
//    delay()
}


fun test1(){
    GlobalScope.launch {
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
suspend fun test2(){

    val job = GlobalScope.launch {
        delay(1000)
        println("this is GlobalScope")
    }
    println("main thread")
    job.join()

}

// 结构化的协程
fun test3(){
    runBlocking {
        launch {
            delay(1000)
            println("world!")
        }
        println("Hello")
    }
}


//作用域构建器
fun test4(){
    runBlocking {

    }
}


// 挂起函数
fun test5(){
    runBlocking {
        launch {
            delay()
        }
        println("hello")
    }
}

suspend fun delay(){
    delay(1000)
    println("123")
}


fun test6(){
    repeat(100_000){
        runBlocking {
            launch {
//                delay(1000)
                println("${it}");
            }
        }
    }


}







