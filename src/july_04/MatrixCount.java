package july_04;

import org.jetbrains.annotations.NotNull;

public class MatrixCount {
    public int countNegatives(int[] @NotNull [] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int row = 0;
        int col = grid[0].length - 1;
        int count = 0;
        while (row < rows && col >= 0) {
            if (grid[row][col] >= 0) {
                row++;
            } else {
                count += rows - row;
                col--;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        MatrixCount matrixCount= new MatrixCount();
        int [][]arr= {{4,3,2,-1},{3,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}};
        int ans=matrixCount.countNegatives(arr);
        System.out.println(ans);
    }
}
