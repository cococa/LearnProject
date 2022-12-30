#include <iostream>
#include <string>

using namespace std;

class Person{
    public:
        int age;
        string name;

    void show(){
        cout<< "name is " << name << age << endl; 
    }
    void setName(string nName){
        name = nName;
    }

};



int main(){


    Person zhangsan ;
    zhangsan.setName("zhangsan");
    zhangsan.age = 12;
    zhangsan.show();
    return 0;
}


