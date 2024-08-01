package Curious_Freaks.dynamic_programming;

import java.util.Arrays;


public class FrogJumpwithK {
    public static void main(String[] args) {

        int[] arr = {30, 10, 60, 10, 60, 50};
        int k = 2;
        int ans = new FrogJumpwithK().solve(arr, k);
        System.out.println(ans);
    }

    int solve(int[] arr, int k) {
        int n = arr.length - 1;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        int ans = frogjump(n, arr, k, dp);
        return ans;

    }

    private int frogjump(int n, int[] arr, int k, int[] dp) {

        if (n == 0) return 0;
        if (dp[n] != -1) return dp[n];

        int minjump = Integer.MAX_VALUE;
        for (int i = 1; i < k; i++) {
            if (n - i >= 0) {
                int jump = frogjump(n - i, arr, k, dp) + Math.abs(arr[n] - arr[n - i]);
                minjump = Math.min(minjump, jump);
            }
        }
        return dp[n] = minjump;
    }

}
