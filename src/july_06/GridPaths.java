package july_06;

import java.util.Arrays;

public class GridPaths {

    public static void main(String[] args) {
        int l = 3, m = 7;
        int ans = countWays(l, m);
        System.out.println(ans);

    }

    static int dp(int i, int j, int[][] dp1) {

        if (i == 0 && j == 0) return 1;

        if (i < 0 || j < 0) return 0;

        if (dp1[i][j] != -1) {
            return dp1[i][j];
        }

        int up = dp(i - 1, j, dp1);
        int left = dp(i, j - 1, dp1);
        return dp1[i][j] = up + left;
    }

    static int countWays(int m, int n) {
        // Create a 2D DP array to store the results
        int[][] dp1 = new int[m][n];

        // Initialize the DP array with -1 to indicate uncomputed values
        for (int[] row : dp1)
            Arrays.fill(row, -1);

        // Start the recursive calculation from the bottom-right cell (m-1, n-1)
        return dp(m - 1, n - 1, dp1);
    }


}
// wiht dead cells

class GridPaths1 {

    public static void main(String[] args) {

        int[][] arr = {{0, 0, 0}, {0, -1, 0}, {0, 0, 0}};
        int l = arr.length, m = arr[0].length;
        int ans = countWays(l, m, arr);
        System.out.println(ans);

    }

    static int dp(int i, int j, int[][] dp1, int[][] a) {

        if (i >= 0 && j >= 0 && a[i][j] == -1) return 0;

        if (i == 0 && j == 0) return 1;

        if (i < 0 || j < 0) return 0;

        if (dp1[i][j] != -1) {
            return dp1[i][j];
        }

        int up = dp(i - 1, j, dp1, a);
        int left = dp(i, j - 1, dp1, a);
        return dp1[i][j] = up + left;
    }

    static int countWays(int m, int n, int[][] a) {
        // Create a 2D DP array to store the results
        int[][] dp1 = new int[m][n];

        // Initialize the DP array with -1 to indicate uncomputed values
        for (int[] row : dp1)
            Arrays.fill(row, -1);

        // Start the recursive calculation from the bottom-right cell (m-1, n-1)
        return dp(m - 1, n - 1, dp1, a);
    }
}

