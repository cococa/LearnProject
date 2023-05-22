#include <iostream>

using namespace std;

int main()
{

    cout << "Helleo---->"
         << "Array" << endl;

    // 可以不初始化数组，但是元素可能是随机的
    int a2[4];
    for (int i = 0; i < 4; i++)
    {
        cout << a2[i] << endl;
    }

    // 初始化数组            
    int a1[3] = {0};

    // 使用sizeOf 计算数组的大小
    cout <<"sizeof int "<< sizeof(int) << endl;
    cout << sizeof(a1) << endl;

    // 使用数组下标访问数组
    for (int i = 0; i < 3; i++)
    {
        a1[i] = i;
        cout << a1[i] << endl;
    }

    int *a = &a1[0];
    // 可以使用指针的形式访问数组
    for (int i = 0; i < 3; i++)
    {
        cout << *(a + i) << endl;
    }


    // c++11 新特性, 需要制定 -std=c++11
    int a3[3] {1,2,3};


    return 0;
}