//
// Created by sj on 2023/3/30.
//
#include "stdio.h"

#define SDS_HDR_VAR(T,s) struct sdshdr##T *sh = (void*)((s)-(sizeof(struct sdshdr##T)));
struct __attribute__ ((__packed__)) sdshdr16 {
    unsigned short len;  // 两个字节
    unsigned short alloc; // 两个字节
    unsigned char flags;  // 一个字节
    char buf[];
};

// 调用SDS_HDR(16,s) . 得到就是sdshdr16 的首地址
//




struct A{
    char c;
    short s;
    int i;
};

/**
 * 结构体指针位移
 * 仿造 sds 的位移, 因为sds 返回的是buf[] 的地址，所以要获取 len alloc flags ,需要左移指针
 *
 */
int main(){

    printf("the sizeof sdshdr16 = %ld \n\r", sizeof (struct sdshdr16));

    struct A a ;

    a.c = 1;
    a.s = 22;
    a.i = 3;

    printf("%d \n\r",a.i);

    struct A * a1 = &a;

    // 这里pi 就是a.i的地址
    void* pi = &(a1->i);
    printf("%p \n\r", pi);
    printf("%p \n\r", &(a1->i));


    // 获取a.s 地址
    short* ps = (short*) (pi - sizeof (short));
    printf("%p \n\r", ps);
    // 获取a.s 的值
    printf("a.s =  %hd \n\r", *ps);


}