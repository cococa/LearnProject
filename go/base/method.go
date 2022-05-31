package main

import (
	"fmt"
)

/**
1 方法就是有接收者的函数 u 为接收者  func (u user) changeName()
2 接收者不能定义为接口类型
3 接收者类型只能是 T  或  *T ，（T是类型）,


** 不管你的method的receiver是指针类型还是非指针类型，都是可以通过指针/非指针类型进行调用的，编译器会帮你做类型转换。
** 在声明一个method的receiver该是指针还是非指针类型时，你需要考虑两方面的内部，第一方面是这个对象本身是不是特别大，如果声明为非指针变量时，调用会产生一次拷贝；


*/
func main() {

	u := user{
		Name: "cocoa",
		age:  12,
	}
	u.changeName()
	fmt.Println(u.Name)

	//如果方法需要一个指针作为接收器，但是接收器u 是一个user 类型的变量，可以直接写成下面这样，编译器会隐式地帮我们用&u去调用 changeAge这个方法
	// 这个写法和下面的 &user{"tom", 12}  tom.changeAge() 一样
	u.changeAge()
	fmt.Println(u.age)

	tom := &user{"tom", 12}
	tom.changeAge()
	fmt.Println(tom.age)

	fmt.Println("-------ForEach------")
	list := List{1, 2, 3}
	list.ForEach()

}

type user struct {
	Name string
	age  int
}

// u 叫做方法的接收器(receiver)
func (u user) changeName() { // 值接受者，调用时，会创建u的副本
	u.Name = "name by notify"
	// fmt.Println(u.Name)
}
func (u *user) changeAge() { // 指针接受者，这个方法会共享调用方法时接受者所指向的值
	u.age = 1000000
}

//
type List []int

func (l List) ForEach() {
	for _, v := range l {
		fmt.Println(v)
	}
}
