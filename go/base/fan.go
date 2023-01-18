package main

import "fmt"

func print[T any](arr []T) {
	for _, v := range arr {
		fmt.Println(v)
	}
}

func main() {
	arr := []int{1, 1, 23}
	print(arr)
}
