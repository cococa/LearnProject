package com.coco.test.classes

//类型别名为现有类型提供替代名称。 如果类型名称太长，你可以另外引入较短的名称，并使用新的名称替代原类型名。


typealias KVMap<T> = MutableMap<T, T>

typealias Predicate<T> = (T) -> Boolean

fun test12_01(p: Predicate<Int>) = p(12)


fun main() {
    // 真的神奇
    var result = test12_01 {
        it > 10
    }
    println("----${result}-")

    var f: Predicate<Int> = { it > 22 }
    println("----${test12_01(f)}-")

    var map: KVMap<String> = mutableMapOf("1" to "one")
    println("");

    var list  = listOf<Int>(1,2,11,33,44)
    var filtedList = list.filter(f)
    println("--the filtedList is -${filtedList}--")



}