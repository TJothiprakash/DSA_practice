package Curious_Freaks.dynamic_programming;


import java.util.Arrays;

class Solution06 {
    public static void main(String[] args) {

    }

    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;

        // Initialize dp array with -1 for memoization
        int[][] dp = new int[row][column];
        for (int[] rows : dp) {
            Arrays.fill(rows, -1);
        }

        return function(row - 1, column - 1, grid, dp);
    }

    private int function(int row, int column, int[][] arr, int[][] dp) {
        // Boundary check
        if (row < 0 || column < 0) return Integer.MAX_VALUE;

        // Base case
        if (row == 0 && column == 0) return arr[0][0];

        // Return cached result if already computed
        if (dp[row][column] != -1) return dp[row][column];

        // Recursive computation
        int left = function(row, column - 1, arr, dp);
        int up = function(row - 1, column, arr, dp);

        // Memoize the result
        dp[row][column] = arr[row][column] + Math.min(up, left);
        return dp[row][column];
    }


