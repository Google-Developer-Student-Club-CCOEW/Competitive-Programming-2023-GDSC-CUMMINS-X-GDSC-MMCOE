public int minCoins(int[] coins, int n, int x) {
    int[] dp = new int[x + 1];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = 0;

    for (int i = 1; i <= x; i++) {
        for (int j = 0; j < n; j++) {
            if (coins[j] <= i) {
                int subproblem = dp[i - coins[j]];
                if (subproblem != Integer.MAX_VALUE && subproblem + 1 < dp[i]) {
                    dp[i] = subproblem + 1;
                }
            }
        }
    }

    return dp[x] == Integer.MAX_VALUE ? -1 : dp[x];
}
