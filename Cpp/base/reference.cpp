#include <iostream>

using namespace std;


/**
 * 何时使用引用
 * 1.“程序员能够修改调用函数中的数据对象。
 * 2. “通过传递引用而不是整个数据对象，可以提高程序的运行速度。
 * 
 * 对于第2点，就是在传递结构体和类对象，那么此时，用指针还是引用? 可以参考下面的几条
 * 1.如果是数组，则用指针，因为是唯一选择
 * 2.如果是大的结构体，指针和引用都可以
 * 3.如果是类，则用引用，“类设计的语义常常要求使用引用，这是C++新增这项特性的主要原因。因此，传递类对象参数的标准方式是按引用传递。”
 * 
 * 
 * 
 * 
 */



// 通过引用交换数据
void swap(int &b, int &a)
{
    int temp = b;
    b = a;
    a = temp;
}
/**
 * 使用引用做参数时，要注意，很有可能修改到外部变量
 * 所以，如果不允许修改，则可以加上const，方便编译器给出正确提示
 */
double refcube(double &b)
{
    // b = b * b;
    return b;
}

struct Something
{
    float price;
};
/**
 * 使用结构体引用，引用本来就是为了给结构体或者类使用的，因为参数传递时会发生值拷贝
 *
 */
void printPrice(Something &s)
{
    cout << s.price << endl;
}

int main()
{

    int a = 10;

    // c++ Prime Plus 中叫引用
    // 引用必须立即初始化（不允许分两步），一旦初始化后不可更改
    int &b = a;

    cout << b << endl;

    int x = 10;
    int y = 20;
    swap(x, y);
    cout << "x is " << x << endl;
    cout << "y is " << y << endl;

    Something sth;
    sth.price = 12;
    Something& sth1 = sth;
    printPrice(sth1);

    return 0;
}
