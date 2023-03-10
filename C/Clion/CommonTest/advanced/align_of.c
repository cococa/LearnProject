
#include "align_of.h"

/**
 * “一个char类型的对齐要求为1个字节；一个short类型的对齐要求为2个字节；一个int类型的对齐要求为4个字节，等等。C11标准引入了_Alignof关键字来查看当前指定对象的对齐要求。”
 */
struct A {
    char a;    // 1个字节
    int b;    // 4个字节
    short d;   // 2个字节
};

struct __attribute__ ((packed)) B {
    char a;    // 1个字节
    int b;    // 4个字节
    short d;   // 2个字节
};

void algnof_main() {
    printf("the size of struct %ld \n\r", sizeof(struct A));

    /**
     *
     * 如果引入了 stdalign.h 则可以使用 alignof
     * “_Alignof的操作数只能是类型名（基本类型、枚举类型、结构体、联合体等），而不能是一个表达式（包括对象标识符都不行）”
     * 举例： 比如struct A { char a } Alignof 返回的就是1 , 而本项目中，返回的则是 4 , 就是根据最长的属性的字节数来定义的对齐
     * “结构体对象的大小应该是其对齐字节数的倍数” , 如果结构体的属性加好不是对齐字节数的倍数，要补齐
     */
    printf("the _Alignof  struct A %ld \n\r", alignof(struct A));

    struct A a;
    a.a = 0xaa;
    a.b = 0xbbbb;
    a.d = 0xdd;

    printf("a %p\n\r", &(a.a));
    printf("b %p\n\r", &(a.b));
    printf("d %p\n\r", &(a.d));
// a 在内存中的占用   aa 00 00 00   bb bb 00 00   dd 00 0f 17

    int i1 = 1;
    printf(" alignof i1 = %d \n\r", alignof(i1));

    printf(" -----------------\n\r");

    printf("the _Alignof  struct B %ld \n\r", alignof(struct B));
    printf("the size of struct B %ld \n\r", sizeof(struct B));
    struct B b;
    b.a = 0xaa;
    b.b = 0xbbbb;
    b.d = 0xdd;
    // b 在内存中的占用   aa bb bb   00 00 dd 00

    printf("b.a %p\n\r", &(b.a));
    printf("b.b %p\n\r", &(b.b));
    printf("b.d %p\n\r", &(b.d));


}