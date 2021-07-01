//
// Created by hj on 2021/7/1.
//

#include "_const.h"

void test_const_content() {
//    char ch1[] = "Hello";
//    char ch2[] = "WORLD";
//    const char* p = ch1;  // const放在类型前面，不能修改内容
//    // *p = 'c';  报错 //error: assignment of read-only location '*p'
//    p = ch2;
//    printf("----%s\n", p);
}

void test_const_pointer() {
//    char ch1[] = "Hello";
//    char ch2[] = "WORLD";
//    char* const p = ch1;  // const放在指针前面，不能修改内容
//    *p = 'c';
////    p = ch2;   // assignment of read-only variable 'p'
//    printf("----%s\n", p);
}

/**
 * const 修饰问题
 * 1. 个人觉得，* 还是加在类型后比较好, 不然会出一些奇怪的问题， 比如char* p 优于 char *p
 *
 *
 */
void test_const() {
    test_const_pointer();
}
