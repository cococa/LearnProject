package com.cocoa.base


fun main(){
    var array1 = arrayOf(1, 2, 3)
    var array2 = arrayOf(1, 2, 3)

    println(array1.contentEquals(array2))
    println(array1.sum())
    println(array2.joinToString("-"){
        it.toString()
    })


}