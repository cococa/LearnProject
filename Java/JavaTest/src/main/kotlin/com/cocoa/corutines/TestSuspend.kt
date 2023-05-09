package com.cocoa.corutines

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine


suspend fun a() {
    withContext(Dispatchers.IO) {

    }

}


suspend fun main() {
    println("A")
    suspendCoroutine<Unit> {
        println(Thread.currentThread().name)
        it.resume(Unit)
    }
    println("B")
}

