package test.book

import kotlin.coroutines.*


var continuation = suspend {
    5
}.createCoroutine(object : Continuation<Int> {
    override val context: CoroutineContext
        get() = EmptyCoroutineContext

    override fun resumeWith(result: Result<Int>) {
        print("resumeWith ${result}")
    }

})


fun main() {
//    continuation.resume()
}