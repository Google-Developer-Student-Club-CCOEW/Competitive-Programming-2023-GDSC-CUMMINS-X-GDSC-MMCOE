import itertools
MOD = 10**9 + 7

def count_arrays(n, m, array):
    dp = [[0] * (m + 2) for _ in range(n + 1)]

    for j in range(1, m + 1):
        dp[1][j] = 1 if array[0] in [0, j] else 0
    for i, j in itertools.product(range(2, n + 1), range(1, m + 1)):
        dp[i][j] = (
            (dp[i - 1][j - 1] + dp[i - 1][j] + dp[i - 1][j + 1]) % MOD
            if array[i - 1] in [0, j]
            else 0
        )
    count = sum(dp[n]) % MOD
    return count

# Input
n, m = map(int, input().split())
array = list(map(int, input().split()))

# Count arrays and print the result
result = count_arrays(n, m, array)
print(result)
