package com.coco.test.coroutines

import kotlinx.coroutines.*
import java.text.SimpleDateFormat
import java.util.*

val dateFormat = SimpleDateFormat("HH:mm:ss:SSS")

val now = {
        dateFormat.format(Date(System.currentTimeMillis()))
}




suspend fun test301(): Int {
    println("test 301 start ")
    delay(3000)
    return 1
}

suspend fun test302(): Int {
    println("test 302 start ")
    delay(1000)
    return 2
}


suspend  fun test333(){
    val a  = test301()
    val b  = test302()
    println("---${a+ b}--")

}

// 并发
suspend fun test334(){
    val a =  GlobalScope.async{
        test301()
    }
    val b = GlobalScope.async {
        test302()
    }
    println("---------")
    println("---${a.await()+ b.await()}-")
}



//惰性启动的 async
//(start = CoroutineStart.LAZY) 只有调用start 或者  await 方法后才会执行 coroutines
suspend fun test335(){
    val a =  GlobalScope.async(start = CoroutineStart.LAZY){
        test301()
    }
    val b = GlobalScope.async (start = CoroutineStart.LAZY){
        test302()
    }
    println("-------------")
    println("---${a.await()+ b.await()}-")
}

fun main() = runBlocking {
    test335()
    println("-${now()}---")
}
