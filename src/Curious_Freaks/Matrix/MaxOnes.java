package Curious_Freaks.Matrix;

public class MaxOnes {


    public static void main(String[] args) {
        // Example usage
        int N = 3;
        int[][] mat1 = {
                {0, 0, 1},
                {0, 1, 1},
                {0, 0, 0}
        };

        int[] result1;
        result1 = Solution7.findMaxRow(mat1, N);
        System.out.println("Row number = " + result1[0]);
        System.out.println("MaxCount = " + result1[1]);


    }

}


class Solution7 {
    static int[] findMaxRow(int[][] mat, int N) {
        int maxRow = 0;
        int maxCount = 0;
        int currentCount;

        for (int i = 0; i < N; i++) {
            // Binary search for the first 1 in the current row
            int left = 0, right = N - 1;
            int firstOneIndex = -1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (mat[i][mid] == 1) {
                    firstOneIndex = mid;
                    right = mid - 1; // Search for earlier 1s
                } else {
                    left = mid + 1; // Search for 1s to the left
                }
            }

            if (firstOneIndex != -1) {
                currentCount = N - firstOneIndex; // Count of 1s in this row
                if (currentCount > maxCount) {
                    maxCount = currentCount;
                    maxRow = i;
                }
            }
        }

        int[] result = new int[2];
        result[0] = maxRow; // Row number with max 1s
        result[1] = maxCount; // Max count of 1s in that row
        return result;
    }


    //// Driver Code
    //array is sorted row wise and column wise in ascending order so that we can use corner case method

    static boolean search(int[][] matrix, int n, int m, int x) {

        // code here
        int i = 0, j = m - 1;

        while (i < n && j >= 0) {
            if (matrix[i][j] == x) {
                return true; // Found x
            } else if (matrix[i][j] > x) {
                j--; // Move left
            } else {
                i++; // Move down
            }
        }

        return false; // x
    }

}

