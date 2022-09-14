package main

import (
	"fmt"
	"reflect"
)

/**
1. slice 由三部分组成，一个指向数组的指针，长度和容量
2. slice 类型一般写成 []T ，没有固定的长度
3. 长度对应 slice 中元素的数目，长度不能超过容量，容量一般是从slice的开始位置到底层数据的结尾位置
4. cap  和 len 用来获取 slice 的容量和长度
5. slice 为引用类型 （如果多个slice 指向相同底层数组，改变值会影响别的slice）
6. go 语言实战中指出，数组作为方法参数传递时会产生拷贝，影响内存，而指针则可以解决这个问题，但是修改指针同时会改变原数组，slice 则可以解决这两个问题
7. 每次扩容时，容量是原来的2倍

*/

func toString(str []string) {
	fmt.Println("the slice = ", str, len(str), cap(str))
}

func main() {
	var arr [4]int
	// 创建slice

	// 1. make 函数创建
	//其长度为 3 个元素，容量为 5 个元素，类型为 int  ,不允许容量小于长度
	slice1 := make([]string, 3, 5)
	toString(slice1)

	//记住，如果在[] 中指定了值，那么创建的就是数组，而不是切片。
	fmt.Println(reflect.TypeOf(slice1)) // 判断切片和数组的类型
	fmt.Println(reflect.TypeOf(arr))

	// 2. 切片字面量
	slice2 := []string{"blue", "green", "red"}
	toString(slice2)

	// 创建 nil 切片, len cap 都是 0， 指针为 nil
	var slice3 []string
	fmt.Println(slice3 == nil) // true
	toString(slice3)           // 0

	// 创建空切片
	slice4 := []string{}
	toString(slice4)
	fmt.Println(slice4 == nil) // false

	// 不允许创建容量小于长度的切片
	// slice5 := make([]int, 3, 1) //会报错，len larger than cap in make([]int)
	// fmt.Println(slice5)

	newSlice := slice2[1:3] //[green red] 2 2
	toString(newSlice)

	newSlice = append(newSlice, "123")
	toString(newSlice)

	for index, value := range newSlice {
		fmt.Println(index, value)
	}

	// 在函数之间传递切片, 一个切片占用24个字节，指针，容量，长度，各占8个字节
	// 与切片关联的数据只存在与数组里，不包含在切片里，所以在函数间传递，复制也只会复制切片本身，不会涉及到底层数组的复制
	// 在函数间传递切片非常高效，方便，所以不需要使用别的传递方式了，比如指针等
	// 传递好切片后，按照需求修改数据，然后返回一个新的切片副本就好
	resultSlice := foo(newSlice)
	toString(newSlice)
	toString(resultSlice)

}

func foo(slice []string) []string {
	slice[0] = "changedColor"
	return slice
}
