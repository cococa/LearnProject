#include <iostream>
#include <string>

using namespace std;


int main(){


    char s1[20];
    char s2[20] = "Hello";
    strcpy(s1, s2);
    cout << s1 << endl;

    
    // 对于C 风格的字符串，可以使用 strlen 计算字符串长度
    char s3[20] = "Hello";
    cout<< "s3 len is " << strlen(s3) << endl;

    // 对于C++ string 类型，可以使用字符串的 size() 函数计算字符串长度
    string s4 = "123";
    cout<< "s4 len is " << s4.size() << endl;


    return 0;
}
