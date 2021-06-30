//
// Created by hj on 2021/6/21.
//

#include "string.h"

void trim(char* c){
    char* t1 = c;
    char* t2 =c;
    while(*t1){
        if(*t1 != 32){  // 这里也用' ' 来判断，注意要区分'\0'
            *t2 = *t1;
            t2++;
        }
        t1++;
    }
    *t2 = 0;
}

void test_trim(){
    char str[]  = " H eh  ah sj da ";
    trim(str);
    printf("%s" ,str);
}

void test_str(){
    //
    char ch[]= "HELLO";  // 栈区字符串
    char *p1= "HELLO";    // 数据区常量字符串
    char *p2= "HELLO";    // 数据区常量字符串

    // 修改ch 的字符是可以的
    // 修改p1 的字符会报错

    ch[2] = 'h';
//    p1[2] = 'h';  //error!!!

    printf("%s\n",ch);
    printf("%s\n",p1);

    printf("打印下p1 和 p2 的地址!!\n");
    // 发现打印的地址是一样的
    printf("the p1 address = %p\n",p1);
    printf("the p2 address = %p\n",p2);


}



void test_p5(){
    test_str();
}