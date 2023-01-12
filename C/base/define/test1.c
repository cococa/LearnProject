#include <stdio.h>

#define MY_MACRO
#define MY_MACRO1 100
#define MY_MACRO2 a + 100
#define MY_MACRO3        \
    static int Foo(void) \
    {                    \
        return 1;        \
    }

#define MY_SWAP(x, y) \
    {                 \
        int tmp = x;  \
        x = y;        \
        y = tmp;      \
    }

void swap(int a, int b)
{
    int tmp = a;
    a = b;
    b = tmp;
}

int main()
{

    int a = MY_MACRO MY_MACRO1;
    printf("the a = %d \n", a);

    int b = MY_MACRO2 * 3; // a + 100 * 3
    printf("the b = %d \n", b);

    int c = Foo(); // 暂时无法测试，编译报错
    printf("the c = %d \n", c);

    MY_SWAP(a, b);
    // 此时预处理器在扩展时就会将MY_SWAP(x, y)替换为以下代码：
    // { int tmp = a; a = b; b = tmp; }
    // 所以这里和 swap 方法还是很有大的区别
    printf("the a =%d, b = %d \n", a, b);

    printf("The current date is: %s\n", __DATE__);
    printf("The apple is: %d\n", __APPLE__);
    printf("The arm64 is: %d\n", __arm64__);
    

    return 1;
}