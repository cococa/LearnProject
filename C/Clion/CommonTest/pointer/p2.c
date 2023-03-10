//
// Created by Administrator on 2021/4/20.
//
#include "p2.h"



void test_p2() {
    printf("------test_p2------\n");
    int array[]= {1,2,3,4,5,6};

    int *ptr1;
    int *ptr2;
    int *ptr3;

    ptr1 = array;
    ptr2 = &array[1];


    printf("---ptr1 value %d-----\n", *ptr1); // 解引用： *运算符给出指针指向地址上储存的值
    printf("---ptr1 self address %p-----\n", &ptr1);   //&ptr1是指向ptr1的指针， 而ptr1是指向array[0]的指针。
    printf("---ptr1 address %p-----\n",ptr1);
    printf("---ptr2 address %p-----\n",ptr2);
//    ---ptr1 value 1-----
//    ---ptr1 self address 0xffffcbe8-----
//    ---ptr1 address 0xffffcbf0-----
//    ---ptr2 address 0xffffcbf4-----

    // 指针加法
    printf("the ptr1 == ptr2 is %d \n",ptr1 == ptr2);
    printf("the (ptr1+1) == ptr2 is %d \n",ptr1+1 == ptr2);
//    the ptr1 == ptr2 is 0
//    the (ptr1+1) == ptr2 is 1


    //一个指针减去另一个指针
    printf("the ptr1 - ptr2 is %d \n", ptr1 - ptr2);


    //千万不要解引用未初始化的指针。 // 貌似不会报错,估计现在编译器做了优化,谨慎！！
    //如， 考虑下面的例子：
    printf("---ptr3 value %d-----\n", *ptr3);
    //---ptr3 value 0-----

    //如果希望在被调函数中改变主调函数的变量， 必须使用指针

//    const int aaa[] = {1,2,3};
//
////    aaa[0] = 110;
//
//    int *ppp = &aaa;
//    *ppp = 10;
//
//    printf("--%d-",aaa[0]);




}