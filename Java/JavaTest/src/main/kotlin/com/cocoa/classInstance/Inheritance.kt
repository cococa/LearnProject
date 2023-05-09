package com.cocoa.classInstance

/**
 * 1. 所有的类都有一个超类，Any
 * 2. 所有的类都有默认的三个方法，equals toString hashCode
 * 3. class 默认都是final 的，无法被继承，如果要使用继承，则要在父类的class 的加上 open
 * 4. 子类覆盖父类的方法，需要把方法open ，子类的方法需要加上 override
 *
 *
 */

open  class Parent(val name : String){

    init {
        println("parent init ${name}")
    }

    open val vertexCount : Int = 0

    open fun draw(){  println("Drawing a rectangle") }
    fun fill(){}
}
open class Children(name : String, val lastName : String): Parent(
    name.also { println("Argument for Base: $it") }
){

    init {
        println("chilren init ${name}")
    }

    //Overriding properties
    // 可以用var 属性去覆盖 val 属性 ,但是不能用 val 去覆盖 var
    override var vertexCount: Int = 10

    //'draw' hides member of supertype 'Parent' and needs 'override' modifier
    // 注意，重写的方法默认是open 的，所以Chidren 的子类也可以重写draw , 如果不想这么做，可以在draw 前加上 final
    override fun draw() {
        super.draw()
        println("Chilren draw")
    }
}
//
//class CC : Children(){
//    override fun draw() {
//        super.draw()
//    }
//}


open  class Parent0x12{
    open fun draw(){
    }
}

interface Polygon{
    fun draw(){}
}

class TestClass0x12 : Parent0x12(), Polygon{

    override fun draw(){
        super<Polygon>.draw()
        super<Parent0x12>.draw()
    }

}

open class Parent0x13 {
    var name : String
    constructor(name : String){
        this.name = name
    }
}

class  Child0x001 : Parent0x13{
    // 次构造函数
    constructor(name: String): super(name)
}

class  Child0x002(name : String) : Parent0x13(name)


fun main(){
    val c : Children  = Children(name = "cocoa", lastName = "cc")
//    c.vertexCount = 123
    println(c.vertexCount)
    c.draw()

}