package Curious_Freaks.dynamic_programming.subsequence;


import java.util.Arrays;

public class SubsetPartition {
    static int equalPartition(int N, int[] arr) {
        return checkEven(arr);
    }

    private static int checkEven(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        // If the sum is odd, it cannot be partitioned into two equal subsets
        if (sum % 2 != 0) {
            return 0;
        } else {
            int k = sum / 2;
            int[][] dp = new int[arr.length][k + 1];
            for (int[] row : dp) {
                Arrays.fill(row, -1);
            }

            return findSubset(arr, k, arr.length - 1, dp);
        }
    }

    private static int findSubset(int[] arr, int k, int index, int[][] dp) {
        // Base cases
        if (k == 0) return 1; // Found a subset with the required sum
        if (index < 0) return 0; // No more elements to consider

        // Memoization check
        if (dp[index][k] != -1) return dp[index][k];

        // Exclude the current element
        int notTaken = findSubset(arr, k, index - 1, dp);

        // Include the current element, if it doesn't exceed the sum
        int taken = 0;
        if (arr[index] <= k) {
            taken = findSubset(arr, k - arr[index], index - 1, dp);
        }

        // Store the result in dp table
        dp[index][k] = (notTaken == 1 || taken == 1) ? 1 : 0;

        return dp[index][k];
    }
}
