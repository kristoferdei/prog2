#include <iostream>
#include <boost/filesystem.hpp>

using namespace std;
using namespace boost::filesystem; 

void jdk(string path);

void jdk(string path) {
    for(recursive_directory_iterator end, dir(path); dir != end; dir++) {
        if(extension(*dir) == ".java") {
            cout<<*dir<<endl;
        }
;
    }
}

int main(int argc, char* argv[]) {
    string path = "/home/kristof/Asztal/JDK/src";
    jdk(path);
}
