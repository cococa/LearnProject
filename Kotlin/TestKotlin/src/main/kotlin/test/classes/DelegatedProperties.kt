package com.coco.test.classes

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty


class Delegate : ReadWriteProperty<Any?, String> {

    override operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        //property ==  var com.coco.test.classes.DelegatedProperties.p
        return "$thisRef, thank you for delegating '${property}' to me!"
    }

    override operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("<<<<<< $value >>>>has been assigned to '${property}' in $thisRef.")
    }


}

class DelegatedProperties{
    var p: String by Delegate()
}


fun main(){
    val e = DelegatedProperties()
    println("DelegatedProperties instance ===>$e")
    println(e.p)
    e.p = "NEW"

    //延迟属性 Lazy
    val lazyString : String by lazy {  // 必须是 val
        println("lazy method!")  // 这里只会调用一次
        "123"
    }
    //第一次调用 get() 会执行已传递给 lazy() 的 lambda 表达式并记录结果， 后续调用 get() 只是返回记录的结果。
    println(lazyString);   //
    println(lazyString);



}