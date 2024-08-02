package Curious_Freaks.dynamic_programming;

import java.util.Arrays;

public class PathswithKcoins {
    public static void main(String[] args) {
        int[][] test = {
                {1, 4, 5, 6},
                {32, 64, 87, 9},
                {12, 3, 5, 6}
        };
        int k = 59; // Example target sum
        System.out.println(nofopaths(test, k)); // Output the number of paths with sum k
    }

    private static int nofopaths(int[][] grid, int k) {
        int row = grid.length;
        int column = grid[0].length;
        // Initialize dp array for memoization
        int[][][] dp = new int[row][column][k + 1];
        for (int[][] ar1 : dp) {
            for (int[] ar2 : ar1) {
                Arrays.fill(ar2, -1);
            }
        }
        return countpath(0, 0, grid, dp, 0, k);
    }

    private static int countpath(int row, int column, int[][] grid, int[][][] dp, int currentSum, int targetSum) {
        int rowCount = grid.length;
        int colCount = grid[0].length;

        // Boundary check
        if (row >= rowCount || column >= colCount) {
            return 0;
        }

        // Update the current sum with the value at the current cell
        currentSum += grid[row][column];

        // If the current sum exceeds the target sum, return 0
        if (currentSum > targetSum) {
            return 0;
        }

        // Base case: if we reached the bottom-right corner
        if (row == rowCount - 1 && column == colCount - 1) {
            return (currentSum == targetSum) ? 1 : 0;
        }

        // Check memoization array
        if (dp[row][column][currentSum] != -1) {
            return dp[row][column][currentSum];
        }

        // Recursive calls to explore the two possible paths: right and down
        int rightPath = countpath(row, column + 1, grid, dp, currentSum, targetSum);
        int downPath = countpath(row + 1, column, grid, dp, currentSum, targetSum);

        // Memoize and return the result
        dp[row][column][currentSum] = rightPath + downPath;
        return dp[row][column][currentSum];
    }
}
