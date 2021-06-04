package com.coco.test.classes

import java.util.function.BinaryOperator
import java.util.function.IntBinaryOperator

enum class AAA {
    A1, A2
}

enum class BBB(var code: Int) {

    B1(1),
    B2(2);
}

enum class IntArithmetics : BinaryOperator<Int>, IntBinaryOperator {

    PLUS {
        override fun apply(t: Int, u: Int): Int = t + u
    },
    TIMES {
        override fun apply(t: Int, u: Int): Int = t * u
    };

//    override fun applyAsInt(t: Int, u: Int) = apply(t, u)

    override fun applyAsInt(left: Int, right: Int): Int = apply(left, right)


}


fun main() {

    println("${AAA.A1}--------")
    println("${BBB.B1.code}--------${BBB.B1}")

    for (i in BBB.values()) {
        println("---foreach---${i}")
    }

    val b1 = BBB.valueOf("B1");
    println("-----${b1}");

    // 如果指定的名称与类中定义的任何枚举常量均不匹配    IllegalArgumentException: No enum constant com.coco.test.classes.BBB.xxxx
//    val xxxx = BBB.valueOf("xxxx");


    for (enumItem in IntArithmetics.values()) {
        println("-${enumItem}-${enumItem.apply(6, 2)}--")
    }


    var result = IntArithmetics.PLUS.apply(1, 2);
    println("the result = ${result}")


}

//每个枚举常量都具有在枚举类声明中获取其名称与位置的属性：
//val name: String
//val ordinal: Int
// 所以构造器的参数名不能是 name  ordinal
enum class Colors(val value :String){

    RED(value = "#ff0000"),
    GREEN(value = "#00ff00")

}