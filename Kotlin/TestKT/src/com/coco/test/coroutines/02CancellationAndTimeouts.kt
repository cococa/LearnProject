package com.coco.test.coroutines

import kotlinx.coroutines.*


fun main() = runBlocking{
    test01();
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