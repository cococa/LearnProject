#include <iostream>

using namespace std;

class Person{
public:
    int age ;

    Person(){
        cout<< "person constructor" << endl;
    }

    Person(int a ){
        age = a ;
    }

    ~Person(){
        cout<< "person deconstructor" << endl;
    }

};


int main(){
    Person  p;
    Person p1 = Person(2);

    cout<< p1.age << endl;
}