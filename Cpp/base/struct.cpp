#include <iostream>
#include <string>

using namespace std;

// 定义结构体
struct Person
{
    int age;
    string name;
};

int main()
{
    Person person = { };
    person.name = "cocoa";

    // 创建结构体指针
    Person *p = &person; 
    Person *p1 = new Person;
    Person *p2 = NULL;


    //给结构体指针设置属性
    p1-> name = "cocoa";


    cout << "------" << person.name << endl;

    // 结构体指针访问属性
    cout << "------" << (*p).name << endl;
    cout << "------" << (*p1).name << endl;

    //释放指针，需要判断空
    delete p;
    delete p1;
    // delete p2;  //  这里会报错，p2 = NULL;

    return 0;
}