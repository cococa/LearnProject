#include <stdio.h>

int main(){

    int a = 10;
    int* p = &a;

    //%d 用来打印指针的值，如果编译器不支持，可以用 %d 或者 %ld
    printf("%td\n", *p);

    //%p 用来打印指针，如果编译器不支持，可以用 %u 或者 %lu
    printf("%p\n", p);
    
    return 0;
}