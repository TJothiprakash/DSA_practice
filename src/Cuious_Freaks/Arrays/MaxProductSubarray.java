package Cuious_Freaks.Arrays;

public class MaxProductSubarray {
    public static void main(String[] args) {

    }
}

class Solution03 {
    // Function to find maximum product subarray
    long maxProduct(int[] arr, int n) {
        // code here

        if (n == 0) return 0;

        long maxEndingHere = arr[0];
        long minEndingHere = arr[0];
        long maxSoFar = arr[0];

        for (int i = 1; i < n; i++) {
            // When arr[i] is negative, swap maxEndingHere and minEndingHere
            if (arr[i] < 0) {
                long temp = maxEndingHere;
                maxEndingHere = minEndingHere;
                minEndingHere = temp;
            }

            // Update maxEndingHere and minEndingHere
            maxEndingHere = Math.max(arr[i], maxEndingHere * arr[i]);
            minEndingHere = Math.min(arr[i], minEndingHere * arr[i]);

            // Update maxSoFar
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }
}
