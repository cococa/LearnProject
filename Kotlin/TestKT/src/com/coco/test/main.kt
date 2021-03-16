package com.coco.test

fun main(){
//    println("Hello")
//    println("${sum(1,2)}")
//
//    var name = "cocoa"
//
//    val len = name.length.also {
//        println(it)
//    }
//
//    println("the length ${len}")

    val kClass = Class.forName("mypackage.MyClass").kotlin
    val classStr = "com.coco.test.Test"

    var clz = Class.forName(classStr).kotlin

    var o = Test() as Any;



//    var ss : Test = clz.javaObjectType.cast(o)
//
//    print(ss.typeName)



//
//
//    var sourceByteArray: ByteArray = ByteArray(10){
//          it.toByte()
//    }
//
//    sourceByteArray?.forEach {
//        println(it)
//    }
//
//
//    var distByteArray: ByteArray = ByteArray(5){
//        (it).toByte()
//    }
//
//    var resultByteArry = IrDataUtil.subRespByteArray(distByteArray,sourceByteArray)
//
//    if(resultByteArry == null){
//        print(" is null")
//    }
//
//    resultByteArry?.forEach {
//        print(it)
//    }




//    sourceByteArray.forEach {
//        print(it)
//    }

//    print(distByteArray)

//    var dd: ByteArray = ByteArray(10,'a')




}

data class Result (val data1 : String = "",var data2 : String = ""){

}

//fun cast(did: String, map: HashMap<String,Any>) : Result{
//    if("2019".equals(did)){
//      val dto : XXXDTO =   map.get("data") as XXXDTO
//      return Result("表显数据：${dto.msg}","${dto.msg}")
//    }
//}
//
//fun sum (a : Int, b : Int) = a + b



