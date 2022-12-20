package main

import "fmt"

const (
	c1 = iota
	c2
	c3
)

func main() {
	// 不支持隐式类型转换，即便是窄类型转宽类型
	var b byte = 100
	// var n int = int(b)

	fmt.Println(b)

	var x, y, z int
	fmt.Println(x, y, z)

	var v1 int = 1
	var v2 = 2
	v3 := 3

	fmt.Println(v1, v2, v3)
	// 变量互换，这个操作很方便
	v1, v2 = v2, v1

	fmt.Println(v1, v2)

	// 定义常量
	const bar string = "foo"
	// bar = "123"

	fmt.Println(c1, c2, c3)

}
