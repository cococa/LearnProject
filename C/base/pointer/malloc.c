#include <stdio.h>
#include <stdlib.h>


// malloc和calloc都是C语言中用于动态内存分配的函数，但它们之间有一些关键的区别：

// malloc
// void *malloc(size_t size);
// 功能：malloc用于分配指定字节大小的内存块。
// 参数：只接受一个参数，即要分配的字节大小。
// 返回值：返回一个指向分配内存起始位置的指针。如果分配失败，返回NULL。
// 初始化：分配的内存块中的内容是未初始化的，可能包含任意值。

// calloc
// 功能：calloc用于分配指定数量和大小的内存块，并初始化为0。
// 参数：接受两个参数，第一个是要分配的元素数量，第二个是每个元素的大小。
// 返回值：返回一个指向分配内存起始位置的指针。如果分配失败，返回NULL。
// 初始化：分配的内存块中的内容被初始化为0。

int main(){

    int *p1 = malloc(sizeof(int) * 4);

    int *p2 = calloc(4, sizeof(int));


    free(p1);
    free(p2);

    return 0;
}