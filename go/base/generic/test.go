package main

import (
	"fmt"
)

// 参考文章
//https://blog.csdn.net/tearon/article/details/124960440

// 实现 comparable
type Stack[T comparable] struct {
	vals []T
}

func (s *Stack[T]) Push(val T) {
	s.vals = append(s.vals, val)
}

func (s Stack[T]) Contains(val T) bool {
	for _, v := range s.vals {
		if v == val {
			return true
		}
	}
	return false
}

type AAA struct {
}

func main() {

	// var aaa AAA

	var intStack Stack[int]
	intStack.Push(10)
	intStack.Push(20)
	fmt.Println(intStack.Contains(10))
	// intStack.Push("123")
	fmt.Println(intStack)
}
