//
// Created by Administrator on 2021/4/22.
//


#include "p3.h"

void test_p3() {
    printf("--------test_p3-------\n");
    int temp[] = {1111, 222};
    const int array1[] = {1, 2, 3, 4};

//    array1[0] = 10;  //报错

    const int *p1 = array1;
//    *p1 = 10;   //报错

//    const  修饰数组和指针，在类型前面，则数组的内容无法修改

    p1 = &temp[0];  //允许

    printf("--p1[0].value = %d---\n", *p1);
//    --p1[0].value = 1111---


//    const  修饰数组和指针，在类型后面，则指针无法再次赋值

    int  array2[3] = {1, 2, 3};
    int * const p2 = array2;
    *p2 = 10;

    printf("--p2[0].value = %d---\n", *p2);
//    --p2[0].value = 10---

//    p2 = temp;   //报错

    //该指针既不能更改它所指向的地址， 也不能修改指向地址上的值
    const int * const p3  = array2;




}

void change1(const int* p1){
//    *p1 = 1; // 报错
}



//防止修改指针指向的地址
void change2(int * const p1){

}


