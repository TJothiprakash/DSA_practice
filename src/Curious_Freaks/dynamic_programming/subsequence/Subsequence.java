package Curious_Freaks.dynamic_programming.subsequence;


//User function Template for Java

class Solution {


    static Boolean isSubsetSum(int N, int[] arr, int sum) {
        // code here
        int[][] dp = new int[N][sum + 1];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < sum + 1; j++) {
                dp[i][j] = -1;
            }
        }
        return isPresent(N - 1, sum, arr, dp);
    }

    static boolean isPresent(int index, int target, int[] arr, int[][] dp) {
        if (target == 0) return true;
        if (index == 0) return (arr[index] == target);
        if (dp[index][target] != -1) {
            return dp[index][target] == 1;
        }
        boolean pick = false;
        if (arr[index] <= target) {
            pick = isPresent(index - 1, target - arr[index], arr, dp);
        }
        boolean notPick = isPresent(index - 1, target, arr, dp);

        boolean flag = pick || notPick;
        if (flag) dp[index][target] = 1;
        else dp[index][target] = 0;
        return flag;
    }
}