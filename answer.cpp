#include<bits/stdc++.h>
using namespace std;

  int peakIndexInMountainArray(vector<int>& arr) {
       int n = arr.size();
       int lo = 0,hi = n-1,mid;

       while(hi - lo > 1) {
           mid = lo + (hi-lo)/2;
           if(arr[mid] > arr[mid-1]) lo = mid;
           else hi = mid - 1;
       } 

       if(arr[lo] > arr[hi]) return lo;
       return hi;
    }

int main() {
    vector<int>nums;
    int x,size;

    cout << "Enter size:";
    cin >> size;
    cout << "\n";

    cout << "Enter elements of vector:";
    for(int i = 0;i<size;++i) {
      cin >> x;
      nums.push_back(x);
    }
        cout << "\n";

    

    cout << "Output:";
    cout << peakIndexInMountainArray(nums);
}

