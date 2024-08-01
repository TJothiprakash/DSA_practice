package Curious_Freaks.dynamic_programming;

import java.util.Arrays;

public class FrogJump {
    public static void main(String[] args) {
/*n = 4
height = {10 20 30 10}
Output:
20*/

        int[] arr = {10, 20, 30, 10};
        int n = arr.length - 1;
        System.out.println(n);
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        int ans = new FrogJump().frogjump(n, arr, dp);
        System.out.println(ans);
    }

    int frogjump(int n, int[] arr, int[] dp) {
        if (n == 0) return 0;

        if (dp[n] != -1) return dp[n];
        
        int onejump = frogjump(n - 1, arr, dp) + Math.abs(arr[n - 1] - arr[n]);
        int twojump = Integer.MAX_VALUE;
        if (n > 1) {
            twojump = frogjump(n - 2, arr, dp) + Math.abs(arr[n - 2] - arr[n]);

        }
        return dp[n] = Math.min(onejump, twojump);

    }

}
