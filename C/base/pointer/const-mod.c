#include <stdio.h>

// 对 形参使用 const 修饰，防止修改指针的值
// 第一个const 限制了指针的值不能修改
// 第二个const 限制了指针指向的内存空间的值不能修改
void test4(const int *const p)
{
    int a = 10;
    // *p = 10;  //报错，因为指针指向的内存空间的值不能修改
    // p = &a;   //报错，因为指针的值不能修改
}

// const 修饰指针
int main()
{

    // test1();
    // test2();
    // test3();

    int xxx = 100;
    test4(&xxx);

    // const 修饰数组，数组的值不能修改
    // const int arr[1] = {1};
    // arr[1]  = 111;

    double rates[5] = {88.99, 100.12, 59.45, 183.11, 340.5};
    const double*  pd = rates;
    // *pd = 29.89;        // 不允许
    // pd[2] = 222.22;     //不允许
    // rates[0] = 99.99;   // 允许，因为rates未被const限定

    return 0;
}

// void test1(){
//     int a  = 10;
//     int b = 20;
//     // const 修饰指针类型，可以修改指针变量的值，不可以修改指针指向内存空间的值
//     const int* p = &a;
//     p = &b;   //ok
//     *p = 1000;   //error
// }

// void test2(){
//     int a = 10;
//     int b = 20;
//     // const 修饰指针变量，则不能改变指针变量的值，可以修改指针指向内存空间的值
//     int* const p = &a;
//     p = &b ;  // error
//     *p = 2;   // ok
// }

// void test3(){
//     int a = 10;
//     int b = 20;
//     // const 修改指针类型 和变量 ，则都不能修改
//     const int* const p = &a;
//     p = &b ;  // error
//     *p = 2;   // error
// }
