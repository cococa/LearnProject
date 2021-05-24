package com.coco.test.classes


sealed class Exp{}


class Ops (val ps : String): Exp(){

}


fun main(){
    //注意：密封类是不能被实例化的
//    var exp = Exp();

    //枚举类的中的每一个枚举常量都只能存在一个实例。而密封类的子类可以存在多个实例。
    var opsPlus = Ops("+")
    var opsSub = Ops("-")






}