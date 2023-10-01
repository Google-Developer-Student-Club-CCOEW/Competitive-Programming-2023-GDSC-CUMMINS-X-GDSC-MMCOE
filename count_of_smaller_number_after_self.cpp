#include <bits/stdc++.h>
using namespace std;

 vector<int> countSmallerNumber(vector<int>& arr) {
    vector<int> ans, temp;
    int n = arr.size();
    for (int i = n - 1; i >= 0; i--) {
        int c = lower_bound(temp.begin(), temp.end(), arr[i]) - temp.begin();
        ans.push_back(c);
        temp.insert(temp.begin() + c, arr[i]);
    }
    reverse(ans.begin(), ans.end());
    return ans;
}

int main() {
     vector<int> arr = {5,2,6,1};
     vector<int> ans = countSmallerNumber(arr);
     for (int i : ans)
        cout << i << " ";
    return 0;
}
