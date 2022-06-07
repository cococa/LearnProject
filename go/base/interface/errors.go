package main

import (
	"errors"
	"fmt"
	"os"
	:""
)

func main() {

	if _, err := os.Open("non-existing"); err != nil {
		if errors.Is(err, fs.ErrNotExist) {
			fmt.Println("file does not exist")
		} else {
			fmt.Println(err)
		}
	}

	msg, err := test1()
	if err != nil {
		fmt.Println("err:", err)
	}
	fmt.Println("msg:", msg)
}

// error 实际是一种 interface
// type error interface {
// 	Error() string
// }

func test1() (string, error) {
	//返回错误类型，创建一个error最简单的方法就是调用errors.New函数  （可以查看errors的package）
	return "", errors.New("test1 error")

	// 返回正常数据
	// return "123123", nil
}
