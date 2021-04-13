package com.coco.test.classes

import java.util.function.BinaryOperator
import java.util.function.IntBinaryOperator

enum class AAA{
    A1, A2
}

enum class BBB(var code : Int){

    B1(1),
    B2(2) ;
}

enum class IntArithmetics  : BinaryOperator<Int>, IntBinaryOperator {

    PLUS {
        override fun apply(t: Int, u: Int): Int = t + u
    },
    TIMES {
        override fun apply(t: Int, u: Int): Int = t * u
    };

//    override fun applyAsInt(t: Int, u: Int) = apply(t, u)

    override fun applyAsInt(left: Int, right: Int)  : Int = apply(left, right)


}




fun main(){

    println("${AAA.A1}--------")
    println("${BBB.B1.code}--------${BBB.B1}")

    for(i in BBB.values()){
        println("---foreach---${i}")
    }

    val b1 = BBB.valueOf("B1");
    println("-----${b1}");


    for (enumItem  in IntArithmetics.values()){
        println("-${enumItem}-${enumItem.apply(6,2)}--")
    }



}