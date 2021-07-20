package base

import (
	"fmt"
	"strings"
)

func TestString() {

	// go 语言中双引号（""）包起来的是字符串
	//         单引号（''）包起来的是字符
	var str string = "Im string hahahah bye!"
	fmt.Println(str)

	// go 截取字符串输出
	fmt.Println("use string spilt !!")
	fmt.Println(string(str[0]))   // 输出字符段0位置的字符,用string()强转char
	fmt.Println(string(str[2:]))  //输出位置2以后的所有字符
	fmt.Println(string(str[2:5])) //2-5
	fmt.Println(string(str[:2]))  //0-2

	s2 := `Dear all:
			Thanks.
			bye!`
	// 多行输出
	fmt.Println(s2)
	fmt.Printf("the len of s2 = %d \n", len(s2))

	// 遍历字符串
	for i := 0; i < len(s2); i++ {
		fmt.Println(string(s2[i])) // string()转成字符串
	}

	fmt.Println("使用string 包")
	s3 := "Hello@WORLD!"
	strArray := strings.Split(s3, "@")
	fmt.Println(strArray)
	fmt.Printf("the len of strArray = %d \n", len(strArray))//2


	//s4 := '123'  //error!
	//fmt.Println(s4)


}
