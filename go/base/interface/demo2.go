package main

import "fmt"

type IntSet struct {
}

func (a *IntSet) String() string {
	return "IntSet"
}

func main() {
	// 报错
	//cannot call pointer method String on IntSetcompilerInvalidMethodExpr
	// result := IntSet{}.String()

	// 这样是可以的，
	// 可以在指针类型上调用方法
	result1 := (&IntSet{}).String()
	fmt.Println("result1:", result1)

	// 这样也是可以的
	// 可以在一个IntSet值上调用这个方法
	var i IntSet
	i.String()

	// 这个问题还是没理解
	// 报错
	// IntSet does not implement fmt.Stringer (method String has pointer receiver)
	// var _ fmt.Stringer = i

	// ok
	//  因为IntSet 的接受者是指针？  func (a *IntSet) String() string
	var _ fmt.Stringer = &i

}
