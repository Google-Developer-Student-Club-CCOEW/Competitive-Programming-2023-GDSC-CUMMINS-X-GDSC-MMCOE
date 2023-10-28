//Planet
//Problem Code:INOI2301

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    int n, k;
    cin >> n >> k;

    vector<long long> a(n);
    vector<long long> w(n);

    for (int i = 0; i < n; i++) {
        cin >> a[i];
    }

    for (int i = 0; i < n; i++) {
        cin >> w[i];
    }

    vector<vector<long long>> dp(n + 1, vector<long long>(k + 1, 0));

    for (int i = 1; i <= n; i++) {
        for (int j = 0; j <= k; j++) {
            dp[i][j] = dp[i - 1][j] + a[i - 1];

            for (int x = 1; x <= i; x++) {
                if (j >= x - 1) {
                    dp[i][j] = min(dp[i][j], dp[i - x][j - x + 1] + w[i - 1]);
                }
            }
        }
    }

    cout << dp[n][k] << endl;

    return 0;
}
