package Curious_Freaks.Matrix;

public class SetZeros {
    public static void main(String[] args) {
        int[][] matrix = {{0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5},
                {1, 3, 1, 5}};
        SetZeros obj = new SetZeros();
        obj.setZeroes(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void setZeroes(int[][] matrix) {
        boolean[] zeroRows = new boolean[matrix.length];
        boolean[] zeroCols = new boolean[matrix[0].length];

        // Mark rows and columns to be zeroed out
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    zeroRows[i] = true;
                    zeroCols[j] = true;
                }
            }
        }

        // Zero out marked rows
        for (int i = 0; i < matrix.length; i++) {
            if (zeroRows[i]) {
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Zero out marked columns
        for (int j = 0; j < matrix[0].length; j++) {
            if (zeroCols[j]) {
                for (int i = 0; i < matrix.length; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

}
