package july_7;

public class MatrixSum {
    public static void main(String[] args) {

        char[][] grid1 = {
                {'X', 'Y', '.'},
                {'Y', '.', '.'}
        };
        System.out.println(countSubmatrices(grid1)); // Output: 3

        char[][] grid2 = {
                {'X', 'X'},
                {'X', 'Y'}
        };
        System.out.println(countSubmatrices(grid2)); // Output: 0

        char[][] grid3 = {
                {'.', '.'},
                {'.', '.'}
        };
        System.out.println(countSubmatrices(grid3)); // Output: 0
    }


    public  static int countSubmatrices(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        // Iterate over all possible bottom-right corners of submatrices
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Initialize counts of 'X' and 'Y'
                int countX = 0;
                int countY = 0;
                boolean containsX = false;

                // Iterate over the submatrix starting from (0, 0) to (i, j)
                for (int x = 0; x <= i; x++) {
                    for (int y = 0; y <= j; y++) {
                        if (grid[x][y] == 'X') {
                            countX++;
                            containsX = true;
                        } else if (grid[x][y] == 'Y') {
                            countY++;
                        }
                    }
                }

                // Check if the submatrix has equal 'X' and 'Y' and contains at least one 'X'
                if (countX == countY && containsX) {
                    count++;
                }
            }
        }

        return count;
    }

}
