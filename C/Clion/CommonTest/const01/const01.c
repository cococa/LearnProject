//
// Created by jun shen on 2020/4/19.
//
#include <stdio.h>

void const_main(){
//    int aaa = 1111;
//    int bbb = 1111;
//    const int*  const ppp = &aaa;
//    ppp = &bbb;
//    *ppp = 10;

    const int a = 100;
    int b  = 200;
//    a = 200;    //这里因为 a 是 const 修饰的，所以指针无法修改a的值

    //C语言允许通过指针修改const修饰的变量值。但是C++不允许这样做。

    int* p = &a;
    *p = 200;
    //这里很诡异，a 和 p 指向一个地址，但是打印出来的 a=100 *p=200
    // 用clion 进行调试，发现其实a 已经被赋值成了200，猜测可能是编译器层做了缓存，因为const 是不允许修改值的，所以就缓存了老的值
    //“C语言标准明确指出，通过指针解引用（dereference）的方式去修改一个常量对象，其行为是未定义的”
    printf("const_main %d \n" ,a);
    printf("const_main %d \n" ,*p);


    // example
    char str1[] ="Hello";
    char str2[] = "world";

    // 指向常量的指针
    const char* p1 = str1;

//    *p1 = 'h';     // 这里会报错，const 修改，无法修改值
    printf("the p1 = %s \n", p1);
    p1 = str2;
    printf("the p1 = %s \n", p1);

    // 常量指针
    char* const p2  = str1;

//    p2 = str2;    //报错  const
    printf("the p2 = %s \n", p2);


    printf("\n\r===========================const 修饰指针============================\n\r");
    // C语言编程魔法书，用的下面两种定义法，比较容易理解
    // const 修饰 pt1 说明 pt1不能赋值，但是*pt1 可以，看下面两行
    int * const pt1 = &a;
//    pt1 = &b;   // 编译报错
    *pt1 = 222;


    // const 修饰 * pt2 说明 *pt2不能赋值，但是pt2 可以，看下面两行
    int const * pt2 = &a;
    pt2 = &b;
//    *pt2 = 333;  // 编译报错





}
