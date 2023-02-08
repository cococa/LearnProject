package main

import "fmt"

type Person struct {
	id   int32
	name string
}

func main() {
	p := Person{1, "222"}
	p2 := new(Person)
	fmt.Println(p)
	fmt.Println(p2)
}
