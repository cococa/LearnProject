package main

import "fmt"

type ByteCounter int

func (counter *ByteCounter) Write(p []byte) (int, error) {
	*counter += ByteCounter(len(p)) // len(p) 是int 类型，虽然ByteCounter 也是int ，但是他们不是同一种类型，所以需要强转
	return len(p), nil
}

func main() {
	var b ByteCounter
	b.Write([]byte("hello"))
	fmt.Println(b) // 5
}
