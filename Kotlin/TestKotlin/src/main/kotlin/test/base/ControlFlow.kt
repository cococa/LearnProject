package com.coco.test.base

fun returnTest1(){
    var name : String? = null
    println("started!!!${name}")
    name ?: return
    println("ended!!!")
}


fun returnTest2(){
    listOf(1,2,3).forEach {
        if(it == 2) return

    }
    println("the end of returnTest2")
}


fun returnTest3(){
    listOf(1,2,3).forEach  loop@{
        if(it == 2) return@loop
    }
    println("the end of returnTest3")
}



fun main(){

    val a  = if( 1 < 10){
        println("1---->>>>")
        1
    }else{
        println("10---<<<<<")
        10
    }

    val b  = if (1 < 10 ) 1 else 10

    println("${a}")
    println("${b}")


    println("start for loop--!")
    for( i in 6 downTo 0 step 2){
        println("${i}")
    }


    println("start for loop until-!")
    for (i in 5 until 10){
        println("${i}")
    }


    println("start for loop -!")
    for (i in 1..3){
        println("--${i}")
    }

    returnTest1()
    returnTest2()
    returnTest3()

    println("start for loop break-!")
    loop@ for (i in 1..3) {
        println("this is i ");
        for (j in 1..100) {
            println("this is j")
            if (j==1) break@loop
        }
    }

}