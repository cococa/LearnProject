#include <iostream>

using namespace std;


class Circle{
    public:
        int m_r;
        double clac(){
            return 2 * 3.14 * m_r;
        }        
};

int main(){
    Circle c1;
    c1.m_r =  10;
    cout << c1.clac() << endl;    
    return 0;
}
