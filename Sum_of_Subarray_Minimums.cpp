#include<bits/stdc++.h>
#include<iostream>
using namespace std;
long long minsum(vector<long long>n)
{
    long long N=n.size();
    long long sum=0;
    for(int i=0;i<N;i++)
    {
        long long min = n[i];
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
    long long N;
    cout<<"Enter length of array : ";
    cin>>N;
    vector<long long>n(N);
    for(int i=0;i<N;i++)
    {
        cin>>n[i];
    }
    long long l=minsum(n);
    cout<<l;
    return 0;
}