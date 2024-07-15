package july_14;

public class MinPathCost {

    public static void main(String[] args) {
        MinPathCost sol = new MinPathCost();

        int[][] grid1 = {{5, 3}, {4, 0}, {2, 1}};
        int[][] moveCost1 = {{9, 8}, {1, 5}, {10, 12}, {18, 6}, {2, 4}, {14, 3}};
        System.out.println(sol.minPathCost(grid1, moveCost1)); // Output: 17

        int[][] grid2 = {{5, 1, 2}, {4, 0, 3}};
        int[][] moveCost2 = {{12, 10, 15}, {20, 23, 8}, {21, 7, 1}, {8, 1, 13}, {9, 10, 25}, {5, 3, 2}};
        System.out.println(sol.minPathCost(grid2, moveCost2)); // Output: 6
    }

    public int minPathCost(int[][] grid, int[][] moveCost) {
        int m = grid.length;
        int n = grid[0].length;

        // Initialize dp array with the values of the first row of grid
        int[][] dp = new int[m][n];
        System.arraycopy(grid[0], 0, dp[0], 0, n);

        // Fill the dp array
        for (int i = 1; i < m; i++) {
            int[][] newDp = new int[m][n];
            for (int j = 0; j < n; j++) {
                newDp[i][j] = Integer.MAX_VALUE;
                for (int k = 0; k < n; k++) {
                    int currentCost = dp[i - 1][k] + moveCost[grid[i - 1][k]][j] + grid[i][j];
                    newDp[i][j] = Math.min(newDp[i][j], currentCost);
                }
            }
            dp = newDp;
        }

        // Find the minimum cost in the last row of dp
        int minCost = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            minCost = Math.min(minCost, dp[m - 1][j]);
        }
        return minCost;
    }
}

