package main

import (
	"fmt"
	"reflect"
)

func fn1(a [4]int) {
	// 数组在函数间进行传递的时候，是值传递，不是引用传递
	// 所以，如果是大容量的数组，建议使用引用或者切片
}

func fn2(a []int) {
}

/**
go 数组
1. 数组的申明， var identifier [len]type    for example  var placeArray [5]string
2. 在go 语言中,数组长度是数组类型的一部分，也就是说，[3]int 和 [2]int 是两种类型
3. 数组的字面值初始化中，可以用[...] 表示用具体的字面值的个数来初始化数组长度
4. 数组类型的值（以下简称数组）的长度是固定的，而切片类型的值（以下简称切片）是可变长的。
*/

func main() {
	var a [4]int
	// a[1] = 10

	array := [4]int{1, 2, 3, 4}
	fmt.Println(a)
	fmt.Println(array)

	// 字面量声明的另一种形式
	array1 := [19]int{1}
	fmt.Println(array1)

	// 容量由初始化值的数量决定
	array2 := [...]int{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
	fmt.Println(array2)
	fmt.Println(reflect.TypeOf(array2))

	// 初始化时指定下标的初始值
	array3 := [11]int{10: 1, 9: 2, 8: 3}
	fmt.Println(array3)

	fn1(array)
	// 数组作为参数，长度必须保持一致
	// fn2(array2)

	list1 := [2]int{2, 2}
	list2 := [2]int{2, 2}
	fmt.Println(list1 == list2) // true  数组比较必须是相同的长度，内容也一致

	// 便利数组
	for index, value := range array2 {
		fmt.Println(index, value)
	}

	for i := 0; i < len(array2); i++ {
		fmt.Println(i, array2[i])
	}

}
