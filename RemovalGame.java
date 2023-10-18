// issue #151

import java.util.Scanner;

public class MaximumScore {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // Size of the list
        int[] numbers = new int[n];

        // Read the list of numbers
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }

        sc.close();

        // Create a 2D array to store the maximum possible scores for the first player
        int[][] dp = new int[n][n];

        // Initialize the dp array
        for (int i = 0; i < n; i++) {
            dp[i][i] = numbers[i]; // Base case: when there is only one number
        }

        // Fill in the dp array using dynamic programming
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                dp[i][j] = Math.max(numbers[i] - dp[i + 1][j], numbers[j] - dp[i][j - 1]);
            }
        }

        // The maximum possible score for the first player is stored in dp[0][n-1]
        int maxScore = dp[0][n - 1];

        // Print the result
        System.out.println(maxScore);
    }
}
