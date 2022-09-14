package main

import (
	"fmt"
	"reflect"
	"strconv"
)

func main() {

	value, err := strconv.Atoi("123")
	if err != nil {
		fmt.Println(err)
	}
	fmt.Println(reflect.TypeOf(value))
}
