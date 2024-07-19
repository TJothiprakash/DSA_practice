package Cuious_Freaks.Matrix;

public class MatrixSearch {

    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int target = 3;
        Solution obj = new Solution();
        System.out.println(obj.searchMatrix(matrix, target));
    }
}

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        for (int[] ints : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (target <= ints[matrix[0].length - 1]) {
                    return bs(ints, target);
                }
            }

        }
        return false;
    }

    boolean bs(int[] m, int target) {
        int left = 0, right = m.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (m[mid] == target) {
                return true;
            } else if (m[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }
        return false;
    }
}

class Solution01 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0, right = (m * n) - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int row = mid / n;
            int col = mid % n;

            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
