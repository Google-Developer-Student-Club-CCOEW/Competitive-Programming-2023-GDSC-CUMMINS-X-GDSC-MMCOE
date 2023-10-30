// Time Complexity: O(n³)

// Space Complexity: O(n²)

// solved using DP

#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    int strangePrinter(string s)
    {
        if (s.length() == 0)
            return 0;
        vector<vector<int>> dp(s.length(), vector<int>(s.length(), s.length()));
        for (int i = 0; i < s.length(); ++i)
            dp[i][i] = 1;
        for (int j = 0; j < s.length(); ++j)
        {
            for (int i = j; i >= 0; --i)
            {
                for (int k = i; k < j; ++k)
                {
                    int tmp = dp[i][k] + dp[k + 1][j];
                    if (s[k] == s[j])
                        --tmp;
                    dp[i][j] = min(dp[i][j], tmp);
                }
            }
        }

        return dp[0][s.length() - 1];
    }
};