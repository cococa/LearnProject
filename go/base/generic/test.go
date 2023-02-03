package main

import (
	"fmt"
	"reflect"
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

// 使用泛型实现 map 函数
func Map[T1, T2 any](s []T1, f func(T1) T2) []T2 {
	result := make([]T2, len(s))
	for i, v := range s {
		result[i] = f(v)
	}
	return result
}

func main() {

	// var aaa AAA

	var intStack Stack[int]
	intStack.Push(10)
	intStack.Push(20)
	fmt.Println(intStack.Contains(10))
	// intStack.Push("123")
	fmt.Println(intStack)
	fmt.Println("--------------")
	s := []int{1, 2, 3}
	fmt.Println(reflect.TypeOf(s))
	res := Map(s, func(s int) int {
		return s * s
	})
	fmt.Println(res)
}
