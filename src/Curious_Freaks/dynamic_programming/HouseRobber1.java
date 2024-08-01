package Curious_Freaks.dynamic_programming;

import java.util.Arrays;

public class HouseRobber1 {
    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1};
        int n = nums.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        int ans = new HouseRobber1().houserobber(nums, n - 1, dp);
        System.out.println(ans);
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
