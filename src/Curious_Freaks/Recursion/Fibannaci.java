package Curious_Freaks.Recursion;

public class Fibannaci {
    public static void main(String[] args) {
        int n = 1000;
        int[] arr = new int[n + 1];
        System.out.println(fibanacci(n, arr));
    }

    static int fibanacci(int n, int[] arr) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        if (arr[n] != 0) {
            return arr[n];
        }
        arr[n] = fibanacci(n - 1, arr) + fibanacci(n - 2, arr);

        return arr[n];
    }
}

class Solution01 {

    private static final int MOD = 1000000007;

    static int nthFibonacci(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 1;
        }

        int[] memo = new int[n + 1];
        memo[1] = 1;
        memo[2] = 1;

        for (int i = 3; i <= n; i++) {
            memo[i] = (memo[i - 1] + memo[i - 2]) % MOD;
        }

        return memo[n];
    }

    public static void main(String[] args) {
        int n = 5; // Example input
        System.out.println("Fibonacci of " + n + " is " + nthFibonacci(n));

        n = 100000; // Example of large input
        System.out.println("Fibonacci of " + n + " is " + nthFibonacci(n));
    }
}
