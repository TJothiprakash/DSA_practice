package Curious_Freaks.dynamic_programming.subsequence;

public class CountSubsetsSum {
    public static int countSubsetsWithSum(int[] arr, int n, int sum) {
        int mod = 1000000007;
        int[][] dp = new int[n + 1][sum + 1];

        // Initialize dp array
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1; // There's always one way to make sum 0 (with empty subset)
        }

        // Fill dp array
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= arr[i - 1]) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - arr[i - 1]]) % mod;
                }
            }
        }

        return dp[n][sum];
    }

    public int perfectSum(int[] arr, int n, int sum) {
        // Your code goes here
        return countSubsetsWithSum(arr, n, sum);
    }
}
