package Curious_Freaks.BinarySearch;

public class InfiniteArray {
}

class Solution {

    // Assuming get(i) is defined elsewhere and returns the value at index i
    // Example:
    // public static int get(int index) {
    //     // Implementation to get the value at index i
    // }

    public static long firstOne() {
        // Step 1: Exponential Search to find a range where `1` appears
        long index = 1;

        // Keep doubling the index until we find a `1`
        while (get((int) index) == 0) {
            index *= 2; // Exponentially increase the index
        }

        // Step 2: Binary Search within the range [index / 2, index]
        long low = index / 2;
        long high = index;
        long result = -1;

        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (get((int) mid) == 1) {
                result = mid; // Found a `1`, but we need to find the first occurrence
                high = mid - 1; // Continue searching in the left half
            } else {
                low = mid + 1; // Continue searching in the right half
            }
        }

        return result; // Return the index of the first occurrence of `1`
    }

    public static int get(int index) {
        // Mock implementation for testing
        // This should be replaced with actual implementation
        // For example:
        // if (index < 5) return 0;
        // else return 1;

        if (index < 5) return 0;
        else return 1;
    }

}
