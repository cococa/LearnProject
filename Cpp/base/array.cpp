#include <iostream>

using namespace std;

int main(){

    cout << "Helleo---->" << "Array" <<endl;

    int a1[3] {1,2,3};

    // 使用数组下标访问数组
    for(int i = 0; i < 3;i++){
        cout << a1[i] << endl;
    }

    int *a = &a1[0];
    // 可以使用指针的形式访问数组
    for(int i = 0; i < 3;i++){
        cout << *(a+i) << endl;
    }
    return 0;
}