package Curious_Freaks.Matrix;

import java.util.Arrays;

public class AggressiveCows {
}


class Solution08 {
    public static void main(String[] args) {
        Solution08 sol = new Solution08();

        int[] stalls1 = {1, 2, 4, 8, 9};
        System.out.println(sol.solve(5, 3, stalls1)); // Output: 3

        int[] stalls2 = {10, 1, 2, 7, 5};
        System.out.println(sol.solve(5, 3, stalls2)); // Output: 4
    }

    public int solve(int n, int k, int[] stalls) {
        // Sort the stall positions
        Arrays.sort(stalls);

        int low = 1;
        int high = stalls[n - 1] - stalls[0];
        int result = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canPlaceCows(stalls, n, k, mid)) {
                result = mid; // mid is a valid minimum distance
                low = mid + 1; // try for a bigger minimum distance
            } else {
                high = mid - 1; // try for a smaller minimum distance
            }
        }

        return result;
    }

    private boolean canPlaceCows(int[] stalls, int n, int k, int distance) {
        int count = 1; // Place the first cow in the first stall
        int lastPosition = stalls[0];

        for (int i = 1; i < n; i++) {
            if (stalls[i] - lastPosition >= distance) {
                count++;
                lastPosition = stalls[i];

                if (count == k) {
                    return true;
                }
            }
        }

        return false;
    }
}

