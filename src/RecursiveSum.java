import java.util.Arrays;

public class RecursiveSum {
/*
    static int fibanacci(int n, int[] dp) {
        if (n <= 1) {
            return 1;
        }
        if (dp[n] != -1) return dp[n];


        return dp[n]=fibanacci(n-1,dp)+fibanacci(n-2,dp);
    }*/

    static int fibanacci(int n) {
        int ans = 0;

        if (n <= 1) return 1;

        if (n >= 0)
            ans = fibanacci(n - 1) + fibanacci(n - 2);
        System.out.print(ans +" ");
        return ans;
    }


    public static void main(String args[]) {

        int n = 4;
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println(fibanacci(n));

    }
}
