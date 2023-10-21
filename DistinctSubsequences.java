import java.util.Scanner;

public class DistinctSubsequences {
    public static int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter string s: ");
        String s = scanner.next();

        System.out.print("Enter string t: ");
        String t = scanner.next();

        int result = numDistinct(s, t);
        System.out.println("Number of distinct subsequences of s that equal t: " + result);
    }
}
