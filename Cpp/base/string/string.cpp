#include <iostream>
#include <string>

using namespace std;

void println(char *p)
{
    cout << p << " the len is " << strlen(p) << "the sizeof " << sizeof(p) << endl;
}

int main()
{

    // C++ 处理字符串有两种方式:

    /*
     *  1. C 语言风格字符串 (以 \0 结尾，ACII 码为 0 ，用来标记结尾)
     **/
    char str1[3] = {'c', 'c', '\0'};

    // dog 不是字符串，只是一个字符数组, c++ 的大部分处理字符函数会在处理字符串时，打印完doog 后，会继续打印，直到遇到 \0 ，会产生一些不必要的麻烦
    // cat 是字符串，因为有 \0 结尾
    char dog[4] = {'d', 'o', 'o', 'g'};
    char cat[4] = {'c', 'a', 't', '\0'};

    // 未使用部分 用 \0 占位 // 注意，写死长度的要把 \0 也计算在内， 比如 char str2[5] = "Hello" 会报错
    char str2[10] = "Hello";
    // 让编译器自动计算长度
    char str3[] = "Hello world";
    cout << str1 << endl;
    cout << str2 << " the len is " << strlen(str2) << endl;
    cout << str3 << " the len is " << strlen(str3) << endl;

    cout << "the sizeof str3 " << sizeof(str3) << endl;

    // str4 在内存中的存储结构 H e l l o \0 \0 \0 \0 \0
    char str4[10] = "Hello";

    /*
     * C++ 98 string 库
     **/
    string ss1 = "Hello";
    // 创建了一个空字符串
    string ss2;

    // 判断空字符串
    cout<< (ss2 == "") << endl;
    cout<< (ss2.empty()) << endl;
    cout<< ss2 << endl;
    cout << ss1 << endl;
}
