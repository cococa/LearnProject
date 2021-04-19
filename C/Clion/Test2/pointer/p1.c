//
// Created by Administrator on 2021/4/19.
//
#include "p1.h"

void test_p1(){
    printf("-test_p1---\n");


    int a  = 111;
    int *p1 = &a;
    printf("--the size of poniter value = %ld ---\n", sizeof(*p1));
    //--the size of poniter = 8 ---   (64位操作系统)
    printf("--the size of poniter = %d ---\n", sizeof(p1));
    printf("--the value of poniter = %ld ---\n", *p1);
    printf("--the value of poniter address = %p ---\n", p1);


    printf("--the size of int  = %ld --- \n", sizeof(int));

    int array[] = {1,2,3,4,5};
    int *p2 = array;

    printf("the size of array = %d  use Pointer \n", sizeof(*p2));
    printf("the size of array = %d  use Array \n", sizeof(array));

    for (int i = 0; i < 5; ++i) {
        printf("%d = %d  and the address of p2 = %p \n",i , *(p2 + i),(p2 + i));
    }

    printf("------------------------------- \n");

    // 双指针遍历数组
    int *pStart = &array;
    int *pEnd = pStart +  5;

    while (pStart < pEnd){
        printf("%d = %d  and the address of p2 = %p \n", 5 - (pEnd-pStart) , *pStart,pStart);
//        printf("----%d---\n",);
        pStart++;
    }






}