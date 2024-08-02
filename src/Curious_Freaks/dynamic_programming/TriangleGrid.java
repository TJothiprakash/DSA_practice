package Curious_Freaks.dynamic_programming;

import java.util.List;

public class TriangleGrid {
    public static void main(String[] args) {
        // Example usage
        TriangleGrid tg = new TriangleGrid();
        List<List<Integer>> triangle = List.of(
                List.of(2),
                List.of(3, 4),
                List.of(6, 5, 7),
                List.of(4, 1, 8, 3)
        );
        System.out.println(tg.minimumTotal(triangle)); // Output should be the minimum path sum
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        Integer[][] memo = new Integer[n][n];
        return minimumTotalHelper(triangle, 0, 0, memo);
    }

    private int minimumTotalHelper(List<List<Integer>> triangle, int row, int col, Integer[][] memo) {
        // Base case: if we reach the bottom row
        if (row == triangle.size() - 1) {
            return triangle.get(row).get(col);
        }

        // Check if we have already computed the result for this subproblem
        if (memo[row][col] != null) {
            return memo[row][col];
        }

        // Recursive case: calculate the minimum path sum of the two possible paths
        int leftPathSum = minimumTotalHelper(triangle, row + 1, col, memo);
        int rightPathSum = minimumTotalHelper(triangle, row + 1, col + 1, memo);

        // Memoize the result
        memo[row][col] = triangle.get(row).get(col) + Math.min(leftPathSum, rightPathSum);

        return memo[row][col];
    }
}
