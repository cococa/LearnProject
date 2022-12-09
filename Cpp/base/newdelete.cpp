#include <iostream>

using namespace std;

// p88 & p89  内容

int main(){

    int* p = new int(10);

    cout<<  *p <<endl; 

    delete p;

    int*  p1 = new int[10];

    // 指针数组的释放要加中括号
    delete[]  p1;


    int a  = 10;

    // c++ Prime Plus 中叫引用
    // 引用必须立即初始化（不允许分两步），一旦初始化后不可更改
    int& b = a;

    cout<< b << endl;    





}