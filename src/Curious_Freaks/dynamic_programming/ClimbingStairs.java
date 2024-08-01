package Curious_Freaks.dynamic_programming;

public class ClimbingStairs {
    public static void main(String[] args) {
        int n = 8;
        int ans = new Solution().climbStairs(n);
        // System.out.println(ans);

    }
}

class Solution {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;


        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            System.out.print(dp[i] + " ");
        }

        return dp[n];
    }
}
//
//
//////////////////////
//\
//
/* class Solution01 {

    public static int climbStairs(int n) {
        if (n == 0) return 1; // if there are 0 stairs, 1 way to stay at the start
        if (n == 1) return 1; // if there is 1 stair, 1 way to climb it
        if (n == 2) return 2; // if there are 2 stairs, 2 ways to climb them
        if (n == 3) return 4; // if there are 3 stairs, 4 ways to climb them

        int[] dp = new int[n + 1];
        dp[0] = 1; // 1 way to stay at the start
        dp[1] = 1; // 1 way to reach the first stair
        dp[2] = 2; // 2 ways to reach the second stair
        dp[3] = 4; // 4 ways to reach the third stair

        for (int i = 4; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3]; // sum of ways to reach (i-1)th, (i-2)th, and (i-3)th stairs
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 697;
        System.out.println("Number of ways to climb " + n + " stairs: " + climbStairs(n));
    }
}
*/
/*class Solution
{
    // Constant for modulo operation
    private static final int MOD = 1000000007;

    // Function to count the number of ways in which frog can reach the top.
    static long countWays(int n)
    {
        // Calculate the number of ways using the climbStairs method
        return climbStairs(n); // No need for extra modulo here
    }

    public static long climbStairs(int n) {
        if (n == 0) return 1L; // if there are 0 stairs, 1 way to stay at the start
        if (n == 1) return 1L; // if there is 1 stair, 1 way to climb it
        if (n == 2) return 2L; // if there are 2 stairs, 2 ways to climb them
        if (n == 3) return 4L; // if there are 3 stairs, 4 ways to climb them

        long[] dp = new long[n + 1];
        dp[0] = 1L; // 1 way to stay at the start
        dp[1] = 1L; // 1 way to reach the first stair
        dp[2] = 2L; // 2 ways to reach the second stair
        dp[3] = 4L; // 4 ways to reach the third stair

        for (int i = 4; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % MOD; // sum of ways to reach (i-1)th, (i-2)th, and (i-3)th stairs
        }

        return dp[n];
    }
}
*/

/*class Solution
{
    // Constant for modulo operation
    private static final int MOD = 1000000007;

    // Function to count number of ways to reach the nth stair.
    int countWays(int n)
    {
        int ans = climbStairs(n);
        return ans;
    }

    public static int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }

        int[] dp = new int[n + 1];
        dp[0] = 1; // Base case: 1 way to stay at the ground (0 stairs)
        dp[1] = 1; // Base case: 1 way to reach the first stair

        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % MOD; // Apply modulo operation
        }

        return dp[n];
    }
}
*/