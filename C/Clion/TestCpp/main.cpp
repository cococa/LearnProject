#include <iostream>
using namespace std;

void change(int i );

int main() {
    cout << "Hello, World!" << endl;
    change(10);
    return 0;
}

void change(int n){
    for(int i = 0; i < n ; i++){
        cout << "A" << endl;
    }
}

