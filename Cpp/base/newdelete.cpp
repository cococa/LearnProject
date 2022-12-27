#include <iostream>

using namespace std;

// p88 & p89  内容




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

    
}
