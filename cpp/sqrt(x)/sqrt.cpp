#include <iostream>

using namespace std;

int sqrt(int x) {
    if (x == 0 || x == 1)
        return x;

    int start = 1, end = x / 2, result;
    while (start <= end) {
        int mid = (start + end) / 2;
        int square = mid * mid;
        
        if (square == x)
            return mid;

        if (square <= x) {
            start = mid + 1;
            result = mid;
        } else {
            end = mid - 1;
        }
    }
    return result;
}

int main() {
    int x;
    cout<<"Enter an Integer:";
    cin>>x;
    if(x<0){
        cout<<"Please enter a positive interger";
        return 0;
    }
    cout << "Floor square root of " << x << " is: " << sqrt(x) << endl;
    return 0;
}
