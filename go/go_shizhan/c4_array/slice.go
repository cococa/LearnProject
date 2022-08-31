package main

import "fmt"

/**
1. slice 由三部分组成，一个指向数组的指针，长度和容量
2. slice 类型一般写成 []T ，没有固定的长度
3. 长度对应 slice 中元素的数目，长度不能超过容量，容量一般是从slice的开始位置到底层数据的结尾位置
4. cap  和 len 用来获取 slice 的容量和长度
5. slice 为引用类型 （如果多个slice 指向相同底层数组，改变值会影响别的slice）
6. go 语言实战中指出，数组作为方法参数传递时会产生拷贝，影响内存，而指针则可以解决这个问题，但是修改指针同时会改变原数组，slice 则可以解决这两个问题
7. 每次扩容时，容量是原来的2倍

*/

func main() {

	// 创建slice

	// 1. make 函数创建
	//其长度为 3 个元素，容量为 5 个元素，类型为 int  ,不允许容量小于长度
	slice1 := make([]string, 3, 5)
	fmt.Println(slice1)

	// 2. 切片字面量
	slice2 := []string{"blue", "green", "red"}
	fmt.Println(slice2)

	// 创建 nil 切片, len cap 都是 0， 指针为 nil
	var slice3 []int
	fmt.Println(slice3 == nil) // true
	fmt.Println(len(slice3))   // 0
	fmt.Println(cap(slice3))   // 0

	// 创建空切片
	slice4 := []int{}
	fmt.Println(slice4)
	fmt.Println(slice4 == nil) // false

}
