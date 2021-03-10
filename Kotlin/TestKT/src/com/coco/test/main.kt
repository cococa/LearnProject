package com.coco.test

import kotlin.reflect.typeOf

fun main(){
    println("Hello")
//    println("${sum(1,2)}")

    var name = "cocoa"

    val len = name.length.also {
        println(it)
    }

    println("the length ${len}")


    var map = mutableMapOf<String,Any>(
        "1" to  123
    )
//   var a  = map.containsKey("2")
    var a = map.getOrDefault("2","")
    println("${(a as String).isNullOrEmpty()}")

//    println("${sum()}")

}


fun sum () : String?{
        val value = "9999999999.11"
        if(value.isNullOrEmpty()){
            return "请输入要写入的值"
        }
        var doubleValue = value.toDoubleOrNull() ?: return "请输入正确的值"
        val max =  99_9999_9999.99
        val min =  0.0
        if( doubleValue  < min   ||  doubleValue > max){
            return "输入范围为${min}-${max}}"
        }
        return  null
}



