#include <iostream>

using namespace std;

// p88 & p89  内容

// 通过引用交换数据
void swap(int &b, int &a)
{
    int temp = b;
    b = a;
    a = temp;
}

int main()
{

    int *p = new int(10);

    cout << *p << endl;

    delete p;

    int *p1 = new int[10];

    for (int i = 0; i < 10; i++)
    {
        *(p1 + i) = i;
    }

    cout << "p1 index 1= " << *(p1 + 1) << endl;

    // 指针数组的释放要加中括号
    delete[] p1;

    int a = 10;

    // c++ Prime Plus 中叫引用
    // 引用必须立即初始化（不允许分两步），一旦初始化后不可更改
    int &b = a;

    cout << b << endl;

    int x = 10;
    int y = 20;
    swap(x, y);
    cout << x << endl;
    cout << y << endl;
}
