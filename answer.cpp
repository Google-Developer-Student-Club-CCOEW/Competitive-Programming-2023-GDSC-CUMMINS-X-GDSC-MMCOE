#include<bits/stdc++.h>
using namespace std;

 int findPivotIndex(vector<int>& nums) {
        int lo = 0, hi = nums.size()-1,mid;
        int index = -1;

        while(lo < hi) {
            mid = lo + (hi-lo)/2;
            if(nums[mid] > nums[hi]) lo = mid + 1;
            else {
             
                hi = mid;
            }
        }

        return hi;
    }

    int find(vector<int>& nums,int lo,int hi,int target) {
        
        while(lo <= hi) {
            int mid = lo + (hi-lo)/2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] > target) hi = mid-1;
            else lo = mid + 1;
        }

        return -1;
    }
    int search(vector<int>& nums, int target) {
        int n = nums.size();
        int pivotIndex = findPivotIndex(nums);

        int leftHalf = find(nums,0,pivotIndex,target);
        int rightHalf = find(nums,pivotIndex,n-1,target);

        if(leftHalf!=-1) return leftHalf;
        return rightHalf;
    }

int main() {
    vector<int>nums;
    int x,size,target;

    cout << "Enter size:";
    cin >> size;
    cout << "\n";

    cout << "Enter elements of vector:";
    for(int i = 0;i<size;++i) {
      cin >> x;
      nums.push_back(x);
    }
        cout << "\n";

    cout << "Enter target value:";
    cin >> target;

    cout << "Output:";
    cout << search(nums,target);
}

