package com.coco.test.test

fun main() {


    val age = 10;

    when (age) {
        1 -> {
            println("the age is one!")
        }
        else -> {
            println("age is large than one!")
        }
    }


    var ageStr: String = when (age) {
        1 -> {
            println("the age is one!")
            "1"
        }
        else -> {
            println("age is large than one!");
            "$age"
        }
    }

    println("---the ageStr is ---${ageStr}----");


    if (age in 2..101) {
        println("${age}----")
    }


    for (a in 2.rangeTo(10).step(2)) {
        println("---$a--")
    }


    for (a in 10.downTo(2).step(2).step(2)) {
        println("$a")
    }

    var list: MutableList<Int> = MutableList(10) { it -> it * it }
    for(item in list.indices){
        println("--${list.get(item)}--");
    }

    for((item, index) in list.withIndex()){
        println("-------${item}=${index}----");
    }


}