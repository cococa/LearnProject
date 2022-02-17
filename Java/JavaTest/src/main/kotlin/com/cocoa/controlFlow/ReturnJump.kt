package com.cocoa.controlFlow

import java.lang.NullPointerException


fun testMethods1(name: String?) {
    val len = name?.length ?: return
    println("the going on")
}


fun testMethods2() {
    outloop@ for (i in 1..10) {
        innrtloop@ for (j in 1..10) {
            if (j == 2) {
                break@outloop
            }
            println("${i}-${j}")
        }
    }
}

fun testMethods3() {
    listOf(1, 2, 3, 4, 5).forEach {
        if (it == 3) return // non-local return directly to the caller of foo()
        println(it)
    }
    println("this point is unreachable")
}


fun testMethods4() {
    listOf(1, 2, 3, 4, 5).forEach list@{
        if (it == 3) return@list // non-local return directly to the caller of foo()
        print(it)
    }
    println("this point is unreachable")
}


fun testMethods5() {
    listOf(1, 2, 3, 4, 5).forEach(fun(it: Int) {
        if (it == 3) return // non-local return directly to the caller of foo()
        print(it)
    })
    println("this point is unreachable")
}


fun main() {

//    testMethods1(null)
//
//    // 方法2，3，4 使用了 return 的粒度控制
//    // testMethods2 将 return的范围从最内层的循环直接跳出最外层的循环
//    // testMethods3.4 则把 return 粒度缩小到了 forEach 的范围内
//    testMethods2()
//    testMethods3()
//    testMethods4()
//
//
//    // testMethods5 使用内部匿名方法
//    testMethods5()



//    testMethods2()

    var name   = null ?: throw NullPointerException("123");
    println("${name}");



}