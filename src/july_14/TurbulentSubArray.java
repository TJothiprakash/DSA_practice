package july_14;

import java.util.Arrays;

public class TurbulentSubArray {


}


class TurbulentSubarray {
    private int[][] memo;
    private int[] arr;

    public static void main(String[] args) {
        TurbulentSubarray sol = new TurbulentSubarray();

        int[] arr1 = {9, 4, 2, 10, 7, 8, 8, 1, 9};
        System.out.println(sol.maxTurbulenceSize(arr1)); // Output: 5

        int[] arr2 = {4, 8, 12, 16};
        System.out.println(sol.maxTurbulenceSize(arr2)); // Output: 2

        int[] arr3 = {100};
        System.out.println(sol.maxTurbulenceSize(arr3)); // Output: 1
    }

    public int maxTurbulenceSize(int[] arr) {
        this.arr = arr;
        int n = arr.length;
        if (n == 1) return 1;

        // Initialize memo table with -1 (indicating uncomputed states)
        memo = new int[n][2];
        for (int[] row : memo) Arrays.fill(row, -1);

        int maxLen = 1;
        for (int i = 1; i < n; i++) {
            maxLen = Math.max(maxLen, Math.max(dp(i, 0), dp(i, 1)));
        }

        return maxLen;
    }

    private int dp(int i, int flag) {
        if (i == 0) return 1;

        if (memo[i][flag] != -1) return memo[i][flag];

        int len = 1;
        if (flag == 0) {
            if (arr[i] > arr[i - 1]) {
                len = dp(i - 1, 1) + 1;
            }
        } else {
            if (arr[i] < arr[i - 1]) {
                len = dp(i - 1, 0) + 1;
            }
        }

        memo[i][flag] = len;
        return len;
    }
}
