package main

import (
	"fmt"
	"reflect"
)

func main() {
	r1 := reflect.TypeOf(1)
	fmt.Println("r1 type :", r1.String())

	v := reflect.ValueOf(3)
	fmt.Println("v type :", v)
	fmt.Printf("v value : %v \n", v)
	fmt.Println("v value :", v.String())

	ss := func() {
		fmt.Println("ss")
	}
	v1 := reflect.TypeOf(ss)
	fmt.Println("v1 type :", v1)

	fmt.Println("------Elem-------")
	i := 3
	v2 := reflect.ValueOf(&i)
	v3 := v2.Elem()
	v3.Set(reflect.ValueOf(4))
	fmt.Println("v3 address :", v3.CanAddr())
	fmt.Println("i == :", i)

}
