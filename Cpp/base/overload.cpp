#include <iostream>

using namespace std;

/**
 * 注意一点
 * 指针的重载支持 const, 即 const int* p 和 int* p 就是两个方法
 * 但是普通类型是不支持的const 重载的
 * 
 * 
 *  
 */
void print(int* a){
    cout << "print1" << endl;
}

void print(const int* a){
    cout << "print2" << endl;
}

int main(){
    const int a = 10;
    int b  = 10;
    print(&a);
    print(&b);
    return 1;
}



