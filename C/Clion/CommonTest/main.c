#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "ex16.h"
#include "string1.h"
#include "advanced/string01.h"
#include "const01/const01.h"
#include "memory/memory.h"
#include "variable/test1.h"
#include "pretreatment/pretreatment.h"
#include "jiqiao/jiqiao.h"
#include "pointer/p1.h"
#include "pointer/p2.h"
#include "pointer/p3.h"
#include "pointer/p4.h"
#include "pointer/string.h"
#include "pointer/_const.h"
#include "advanced/align_of.h"
#define VALUE 10

#define MAX(a, b) ((a > b) ? (a) : (b))

//      %d 十进制有符号整数   
//
//      %u 十进制无符号整数    
//
//      %f 浮点数    
//
//      %s 字符串     
//
//      %c 单个字符     
//
//      %p 指针的值     
//
//      %e 指数形式的浮点数     
//
//      %x,%X 无符号以十六进制表示的整数    
//
//      %o 无符号以八进制表示的整数    
//
//      %g 自动选择合适的表示法 

typedef unsigned int uint32_t;

uint32_t isqrt_bist(uint32_t a)
{
    uint32_t low, high, mid;

    if (a <= 1) return a;

    low = 1;
    high = (a >> 5) + 8;
    if (high > 65535) high = 65535; /* adjust upper bound */

    while (high >= low) {
        mid = (low + high) >> 1;
        if (mid * mid > a) {
            high = mid - 1;
        } else {
            low = mid + 1;
        }
    }
    return high;
}


int main(){
//    algnof_main();
//    const_main();
    printf("asdas %d", isqrt_bist(2));
}




extern int  global_b;


int sum(int *start, int *end) {
    int total = 0;
    while (start < end) {
        total += *start;
        start++;
    }
    return total;
}

int getArraySize(int arr[]) {
    printf("the size of arr %d \n", sizeof arr);
}

int calcLen(char *c) {
    char *p = c;
    while (*c != '\0') {  // 注意是单引号，已经犯过错
        c++;
    }
    return c - p;
}


struct Action{
    int id;
    int position;
};


//
//int main() {
////    printf("Hello, World!\n");
////    printf("this is ten %d \n", VALUE);
////
////    int a = MAX(10,20);
////    printf("this is max method %d \n",a);
////
////    int array[7] = {1,2,3,4,5,6,7};
////
////    printf("%p \n", array);
////    int *p = &array;
////    for (int i = 0 ; i < 7 ; i++) {
////        printf("%p \n", p + i);
////        printf("%d \n", *(p+i));
////    }
////
////    printf("the a size of %zd \n", sizeof a);
////    getArraySize(array);
////
////    int total = sum(p, p+7);
////    printf("the sum is %d \n", total );
////
////    printf("the size of  pointer %lu \n", sizeof(char*));
//
////    test();
////    string_main();
//
////    string01_main();
//
//
////    char *c = "Hello,world";
////    int result = calcLen(c);
////    printf("the len is %d \n", result);
////
////
////    test1_main();
////    printf("the global_b used at main.c  global_b = %d \n",global_b);
////
////
////    memory_main();
////
////    pre_main();
//
////    jiqiao_main();
//
//
//    int num = 2;
//    struct Action *actions = (struct Action*) malloc(sizeof(struct Action) * num);
//
//
//    struct Action a1={2,2500};
//    struct Action a2={1,2500};
//
//    actions= &a1;
//    actions++;
//
//    actions=&a2;
//    actions--;
//
//
//
//    for (uint8_t i = 0; i < 2; i++) { //循环填充舵机ID和对应目标位置
//        printf("the p address  = %d \n", actions->id);
//        printf("the p address  = %d \n", actions->position);
//
//        actions++;
//    }
//
//
//
//
//    return EXIT_SUCCESS;
//}
//
//
//
//
//typedef struct Sds SDS;
//
//struct Sds{
//    int len;
//    int free;
//    char str[];
//};
//
//
//SDS* init(char* str, size_t len){
//    SDS* s = (SDS*) malloc(sizeof(int) *2 + sizeof(char)* (len+1));
//    s->len  = len;
//    s->free = 0;
//    memcpy(s->str, str, len+1);
//    return s;
//}
//
//void printSds(SDS *p){
//    if(p==NULL){
//        return;
//    }
//    printf("the len of sds = %d , and the free = %d, the content = %s \n", p->len, p-> free, p->str);
//}
//
//void freeSds(SDS *p){
//    if(p==NULL){
//        return;
//    }
//    free(p);
//    p=NULL;
//}
//
//SDS* append(SDS* p, char* str, size_t len){
//    size_t cutLen = p-> len;
//    if(len <= cutLen){
//        memcpy(p-> str, str,len+1);
//        return p;
//    }else{
//        freeSds(p);
//        return  init(str,len);
//    }
//}



#include <stdio.h>
#include <stdlib.h>

#define SDS_HDR_VAR(T, s) struct sdshdr##T *sh = (struct sdshdr##T *)((s)-(sizeof(struct sdshdr##T))-2);


struct sdshdr8 {
    u_int32_t len;
    u_int32_t alloc;
    char buf[];
};

struct A{
    char a1;
    short a2;
    int a3;
};


struct __attribute__ ((__packed__)) B{
    char a1;
    int a3;
    short a2;
};



//int main() {

//    int initlen = 10;
//    void *mash = malloc(sizeof(struct sdshdr8) + initlen );
//
//    SDS_HDR_VAR(8, mash)
//    sh->len = 2;
//    sh->alloc = 3;
//    sh->buf;

//    printf("%ld \n\r", sizeof(char));
//    printf("%ld \n\r", sizeof(struct A));
//    printf("%ld \n\r", sizeof(struct B));
//
//    struct A* a = malloc(sizeof (struct A));
//    a->a1 = 0xff;
//    a->a2 = 0xdddd;
//    a->a3 = 0xbbeebbee;



//}



//
//int main(int argc, char* argv[]){
////    char *str = "Helloworld!!!";
////
////    printf("%p", str);
////    long d =  sizeof(*str);
////
////    size_t len  = strlen(str);
////    SDS* sds = init(str, len);
////    printSds(sds);
////
////    char *str2 = "User Defaults won't write to disk right away";
////    SDS* s2 = append(sds, str2, strlen(str2));
////    printSds(s2);
////
////    freeSds(sds);
////    freeSds(s2);
//
//    for (int i = 0; i < argc; ++i) {
//        printf("%s\n",argv[i]);
//    }
//
////    test_const();
//    memory_main();
//
//}
