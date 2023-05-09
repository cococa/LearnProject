package com.cocoa

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

fun makeFlow(): Flow<Int> {
    return flow {
        listOf<Int>(1, 2, 3).forEach {
            delay((it * 1000).toLong())
            emit(it)
        }
    }
}

fun main() {
    runBlocking {
        makeFlow()
            .collect {
                println(it)
            }
    }
}