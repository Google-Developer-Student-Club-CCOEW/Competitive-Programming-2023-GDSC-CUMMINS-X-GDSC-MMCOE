// BOTTOM UP APPROACH
// Time Complexity -> O(n * m)
// Space Complexity -> O(n * m), where n is the size of string 1 and m is the size of string 2

// Input: s = "rabbbit", t = "rabbit"
// Output: 3
// Explanation:
// As shown below, there are 3 ways you can generate "rabbit" from s.
// rabbbit
// rabbbit
// rabbbit

#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    int solveTab(string &str1, string &str2)
    {
        int n = str1.size();
        int m = str2.size();
        vector<vector<double>> dp(n + 1, vector<double>(m + 1, 0));
        // Base Case
        for (int i = 0; i <= n; i++)
            dp[i][0] = 1;

        for (int i = 1; i <= n; i++)
        {
            for (int j = 1; j <= m; j++)
            {
                if (str1[i - 1] == str2[j - 1])
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[n][m];
    }

    int numDistinct(string s, string t)
    {
        int n = s.size();
        int m = t.size();
        return (int)solveTab(s, t);
    }
};