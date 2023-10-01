#include <bits/stdc++.h>
using namespace std;
#define int long long
#define MOD 1e9 + 7
const long long N=10000005;


main()
{
    vector<int> v;
    int x;
    while(cin>>x){
        v.push_back(x*x);
    }
    sort(v.begin(),v.end());
    for(auto it:v)
    {
        cout<< it <<" ";

    }
    cout<<endl;

}