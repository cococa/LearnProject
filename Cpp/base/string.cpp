#include <iostream>
#include <string>

using namespace std;


void println(char* p){
       cout << p  << " the len is " << strlen(p)   << "the sizeof " << sizeof(p) << endl; 
}



int main(){
    /*
    *C 语言风格字符串
    **/
    char str1[3] = {'c','c','\0'};
    // 未使用部分 用 \0 占位 // 注意，写死长度的要把 \0 也计算在内， char str2[5] = "Hello" 会报错
    char str2[10] = "Hello";   
    // 让编译器自动计算长度
    char str3[] = "Hello world";   
    cout << str1 <<endl;
    cout << str2  << " the len is " << strlen(str2) <<endl;
    cout << str3  << " the len is " << strlen(str3) <<endl;

    cout  << "the sizeof str3 " << sizeof(str3) << endl;

    /*
    * C++ 98 string 库 
    **/
    string ss1 = "Hello";
    cout << ss1 <<endl;
    string ss2;
        




}


