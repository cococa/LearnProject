package main

import (
	"fmt"
	"io"
	"os"
)

/**
一个类型如果拥有一个接口需要的所有方法，那么这个类型就实现了这个接口
然后可以用接口定义类型



*/
func main() {
	var w io.Writer
	w = os.Stdout

	fmt.Println("w:", w)

	// 但是如果没有实现 io.Writer 接口, 则会报错，比如下面的代码
	// time.Duration does not implement io.Writer (missing method Write)
	// w = time.Second

}
