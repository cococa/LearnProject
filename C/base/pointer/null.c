#include <stdio.h>

// 野指针，空指针
int main()
{
        // 下面是一个野指针, 记得一定要初始化指针变量
        //在C语言中，当你声明一个指针但没有为其分配内存空间，
        //这个指针会指向一个未知的、不确定的内存地址。在这种情况下，解引用这个指针（使用 *p）是非法的，并且会导致未定义行为。
        int *p;
        *p = 10000;
        printf("%d\n", *p); 
        
        


        // 指针变量指向未知的空间，10000的地址未知（啥类型？是否可以访问?）
        // initialization makes pointer from integer without a cast
        // 不建议将一个变量的值直接赋值给指针
        // int *p = 200;

        int *p1 = NULL;
        printf("%p\n", p1); // nil
        if (p1 == NULL)
        {
                printf("P1 = null！\n");
        }
        //空指针的读写都会报错。
        // 尝试读取空指针，报错
        printf("%d\n",*p1);
        return 0;
}
