package Curious_Freaks.dynamic_programming;

import java.util.Arrays;

public class DpBasic {


    public static void main(String[] args) {
        int a = 697;
        int[] dp = new int[a + 1];
        Arrays.fill(dp, -1);
        int ans = Fibanacci.findfibanacci(a, dp);
        DpBasic obj = new DpBasic();
        System.out.println(ans);
        // System.out.println(Fibanacci.bottomup(a));
        System.out.println(Fibanacci.findfibanacci0(a));
    }
}

class Fibanacci {
    static int findfibanacci(int n, int[] dp) {

        if (n == 0) return 0;
        if (n == 1) return 1;
        if (dp[n] != -1) return dp[n];
        dp[n] = findfibanacci(n - 1, dp) + findfibanacci(n - 2, dp);
        return dp[n];
    }

    static int findfibanacci0(int n) {

        if (n == 0) return 0;
        if (n == 1) return 1;
        return findfibanacci0(n - 1) + findfibanacci0(n - 2);
    }

    static int bottomup(int n) {

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }


}
/*

// User function Template for Java

class Solution {
    static long dp[];
    static int mod = 1000000007;
    public Solution(){
        dp = new long[10001];
        Arrays.fill(dp,-1);
        dp[0] = 0;
        dp[1] = 1;
    }
    static long topDown(int n) {
        // code here
        //to solve the problem, we call for subproblems using recursion and solve them store the results, then comeback ..
        //recursion + storing intermediate results to avoid duplicate calls -> memoization
        if(n<=1){
            return n;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        dp[n] = (topDown(n-1)+topDown(n-2))%mod;
        return dp[n]%mod;
    }

    static long bottomUp(int n) {
        // code here
        //iterative based approach.
        //we iteratively solve from start to what we need and also store the intermediate results, which are needed to calculate the current prblm
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            dp[i] = (dp[i-1]+dp[i-2])%mod;
        }
        return dp[n]%mod;
    }
}*/