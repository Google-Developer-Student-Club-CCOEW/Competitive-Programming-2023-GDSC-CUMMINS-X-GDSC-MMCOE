#include<bits/stdc++.h>
#include<iostream>
using namespace std;
int minsum(vector<int>n)
{
    int N=n.size();
    int sum=0;
    for(int i=0;i<N;i++)
    {
        int min = n[i];
        for(int j=i;j<N;j++)
        {
            if(min>n[j])
            {
                min=n[j];
            }
            sum=sum+min;
        }
    }
    return sum;
}
int main()
{
    int N;
    cout<<"Enter length of array : ";
    cin>>N;
    vector<int>n(N);
    for(int i=0;i<N;i++)
    {
        cin>>n[i];
    }
    int l=minsum(n);
    cout<<l;
    return 0;
}