//g++ const.cpp -o const -std=c++11
//./const

#include <iostream>
#include <vector>

using namespace std;

struct A {
    A() {
        cout << "Cons..." << endl;
    }

    A(const A & a1) {
    cout << "Copy Cons..." << endl;
    }

    A(A && a1) noexcept {
    cout << "Move Cons..." << endl;
    }

    ~A() {
        cout << "Dest..." << endl;
    }
};

int main() {
    {
        vector<A> v1;
        v1.push_back(A());  //calls Move
    }
    {
        vector<A> v1;
        A a2;
        v1.push_back(a2);   //calls Copy
    }
    {
        vector<A> v1;
        A a3;
        v1.push_back(move(a3));   //calls Move
    }
    
    return 0;
    
}
