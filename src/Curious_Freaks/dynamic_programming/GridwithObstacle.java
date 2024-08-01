package Curious_Freaks.dynamic_programming;

import java.util.Arrays;

public class GridwithObstacle {
    private int countpath(int row, int column, int[][] obstacleGrid, int[][] dp) {
        if (row >= 0 && column >= 0 && obstacleGrid[row][column] == 1) return 0;
        if (row == 0 && column == 0) return 1;
        if (row < 0 || column < 0) return 0;
        if (dp[row][column] != -1) return dp[row][column];
        int left = countpath(row - 1, column, obstacleGrid, dp);
        int right = countpath(row, column - 1, obstacleGrid, dp);
        dp[row][column] = left + right;
        return dp[row][column];
    }

    class Solution {


        public int uniquePathsWithObstacles(int[][] obstacleGrid) {

            int row = obstacleGrid.length;
            int column = obstacleGrid[0].length;
            int[][] dp = new int[row][column];
            for (int[] ar : dp
            ) {
                Arrays.fill(ar, -1);
            }
            return countpath(row, column, obstacleGrid, dp);


        }
    }
}
