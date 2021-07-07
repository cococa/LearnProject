package test.coroutines

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*


fun main() {
    test6007()
}

fun simple(): Sequence<Int> = sequence { // sequence builder
    for (i in 1..3) {
        Thread.sleep(1000) // pretend we are computing it
        yield(i) // yield next value
    }
}

fun test6001() {
    simple().forEach { value -> println(value) }
    println("ended!!")
}


suspend fun simple1(): List<Int> {
    delay(2000)
    return listOf(1, 2, 3);
}

fun test6002() {
    runBlocking {
        simple1().forEach { value -> println(value) }
    }
    println("ended!!")
}

fun simple3(): Flow<Int> {
    return flow<Int> {
        repeat(5) {
            delay(100)
            emit(it)
        }
    }
}

fun test6003() {
    runBlocking {
        GlobalScope.launch {
            for (k in 1..3) {
                println("I'm not blocked $k")
                delay(100)
            }
        }
        simple3().collect {
            println("${it}");
        }


    }
}


fun simple4(): Flow<Int> {
    return flow<Int> {
        repeat(100000) {
            println("----${it}")
            delay(300L)
            emit(it)
        }
    }
}


fun test6004() {
    runBlocking {
        withTimeoutOrNull(1000) {
            simple4().collect { println(it) }
        }
        println("Done")
    }
}

//Flow builders
fun test6005() = runBlocking {
    listOf<Int>(1, 2, 3, 4).asFlow().collect {
        println("${it}")
    }
}

//Intermediate flow operators


fun test6006() = runBlocking {

    listOf(1, 2, 3).asFlow().map {
        delay(1000)
        "request ${it}"
    }.collect { println("${it}") }

}


fun test6007() = runBlocking {

    var reduce = listOf(1, 2, 3).asFlow().map {
        "request ${it}"
    }.reduce { a, b -> a + b }
    println("result = ${reduce}");

}





