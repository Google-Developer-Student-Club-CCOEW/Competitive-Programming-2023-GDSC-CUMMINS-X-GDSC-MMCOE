/*
Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

Time complexity: O(log(n))

Example 1:

Input: nums = [1,3,5,6], target = 5
Output: 2
*/


#include <bits/stdc++.h>

using namespace std;

// Required function
int searchInsert(vector<int>& elems, int target) {
        int i=0,j=elems.size()-1,mid;

        // Binary search:To find the target index
        while(i<=j){
            mid=(i+j)/2;
            if(elems[mid]>target)
            j=mid-1;
            else if(elems[mid]<target)
            i=mid+1;
            else return mid;
        }

        if(target<elems[0])
        return 0;

        else if(target<elems[mid])
        return mid;

        return mid+1;
}

int main(){
    cout<<"Enter the number of Elements."<<endl;
    int numberOfElements;
    cin>>numberOfElements;

    vector<int> elems;
    cout<<"Enter the elements."<<endl;
    for(int i=0;i<numberOfElements;++i){
        int val;
        cin>>val;
        elems.push_back(val);
    }
    cout<<"Enter the target value."<<endl;
    int target;
    cin>>target;
    cout<<"Index of the target value:"<<searchInsert(elems,target)<<endl;
    return 0;
}