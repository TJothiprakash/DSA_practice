package Curious_Freaks.dynamic_programming;

import java.util.Arrays;

public class HouseRobberCyclichouses {
    public static void main(String[] args) {
        int[] nums = {59, 53, 41, 26, 17, 13, 11};
        int n = nums.length;

        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        int ans = new HouseRobberCyclichouses().solveutil(nums, n - 1, dp);
        System.out.println(ans);
    }

    int solveutil(int[] nums, int n, int[] dp) {
        if (n < 0) return 0;
        if (n == 0) return nums[0];

        int[] arr1 = new int[nums.length];
        int[] arr2 = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (i != 0) arr1[i] = nums[i];
            if (i != nums.length - 1) arr2[i] = nums[i];
        }
        int ans1 = houserobber(arr1, n, dp);
        int ans2 = houserobber(arr2, n, dp);
        return Math.max(ans1, ans2);
    }

    int houserobber(int[] nums, int n, int[] dp) {
        if (n < 0) return 0;
        if (n == 0) return nums[0];
        if (dp[n] != -1) return dp[n];
        int pick = nums[n] + houserobber(nums, n - 2, dp);
        int notpick = houserobber(nums, n - 1, dp);
        dp[n] = Math.max(pick, notpick);
        return dp[n];

    }

}
