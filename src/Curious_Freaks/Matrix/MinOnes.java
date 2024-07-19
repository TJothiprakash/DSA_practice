package Curious_Freaks.Matrix;

public class MinOnes {
}

class Solution02 {
    // Main function to test the solution
    public static void main(String[] args) {
        Solution02 sol = new Solution02();

        int[][] matrix1 = {
                {1, 1, 1, 1},
                {1, 1, 0, 0},
                {0, 0, 1, 1},
                {1, 1, 1, 1}
        };
        System.out.println(sol.minRow(4, 4, matrix1)); // Output: 2

        int[][] matrix2 = {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        };
        System.out.println(sol.minRow(3, 3, matrix2)); // Output: 1
    }

    public int minRow(int n, int m, int[][] a) {
        int minOnes = Integer.MAX_VALUE;
        int minRowIndex = 1; // 1-based index

        for (int i = 0; i < n; i++) {
            int countOnes = 0;
            for (int j = 0; j < m; j++) {
                if (a[i][j] == 1) {
                    countOnes++;
                }
            }

            if (countOnes < minOnes) {
                minOnes = countOnes;
                minRowIndex = i + 1; // converting to 1-based index
            }
        }

        return minRowIndex;
    }
}

