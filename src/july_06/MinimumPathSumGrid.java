package july_06;

public class MinimumPathSumGrid {
    public static void main(String[] args) {
        MinimumPathSumGrid minimumPathSumGrid = new MinimumPathSumGrid();
        int[][] test = {{1, 4, 5, 6}, {32, 64, 87, 9}, {12, 3, 5, 6}};
        System.out.println(minimumPathSumGrid.minPathSum(test));
    }

    public int minPathSum(int[][] grid) {


        int row = grid.length;
        int column = grid[0].length;
        // int ans = function(row - 1, column - 1, grid);

        return function(row - 1, column - 1, grid);
    }

    private int function(int row, int column, int[][] arr) {
        if (row < 0 || column < 0) return Integer.MAX_VALUE;
        if (row == 0 && column == 0) return arr[0][0];


        int left = function(row, column - 1, arr);
        int up = function(row - 1, column, arr);

        return arr[row][column] + Math.min(up, left);
    }
}
/*

package july_06;

public class MinimumPathSumGrid {
    public static void main(String[] args) {
        MinimumPathSumGrid minimumPathSumGrid = new MinimumPathSumGrid();
        int[][] test = {{1, 4, 5, 6}, {32, 64, 87, 9}, {12, 3, 5, 6}};
        System.out.println(minimumPathSumGrid.minPathSum(test));
    }

    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        return function(row - 1, column - 1, grid);
    }

    private int function(int row, int column, int[][] arr) {
        if (row < 0 || column < 0) return Integer.MAX_VALUE;
        if (row == 0 && column == 0) return arr[0][0];

        int fromLeft = function(row, column - 1, arr); // Move left
        int fromUp = function(row - 1, column, arr); // Move up

        return arr[row][column] + Math.min(fromLeft, fromUp);
    }
}
*/