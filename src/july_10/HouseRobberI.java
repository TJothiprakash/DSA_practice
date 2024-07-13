package july_10;

public class HouseRobberI {
    public static void main(String[] args) {
        Solution7 solution7 = new Solution7();
        int[] arr = {6, 9, 1, 4};
        System.out.println(solution7.rob(arr));
    }
}

class Solution7 {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        if (nums.length == 1) {
            return nums[0];

        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[nums.length - 1];

    }
}