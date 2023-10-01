#include<bits/stdc++.h>

using namespace std;

int main()
{
    int n;
    cout<<"\nEnter the size of mountain array : ";
    cin>>n;
    int arr[n];
    cout<<"\nEnter the mountain array :\n";
    int peak;
    cin>>arr[0];
    for (int i = 1; i < n; i++)
    {
        cin>>arr[i];
        if (arr[i]<arr[i-1])
        {
            peak = i-1;
            break;
        }
    }
    cout<<"\nThe peak index in the mountain array is : "<<peak<<endl;
    return 0;
}
