package Curious_Freaks.slidingWindow;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class Max_subArray {
    // Function to find maximum of each subarray of size k.
    static ArrayList<Integer> max_of_subarrays(int[] arr, int n, int k) {
        // List to store the maximums of each subarray
        ArrayList<Integer> result = new ArrayList<>();
        // Deque to store indices of array elements
        Deque<Integer> deque = new LinkedList<>();

        // Process the first window of size k
        for (int i = 0; i < k; i++) {
            // Remove elements not useful from the deque
            while (!deque.isEmpty() && arr[deque.peekLast()] <= arr[i]) {
                deque.pollLast();
            }
            // Add the current element at the rear of the deque
            deque.addLast(i);
        }

        // Add the maximum of the first window
        result.add(arr[deque.peekFirst()]);

        // Process the rest of the windows
        for (int i = k; i < n; i++) {
            // Remove elements not within the window
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            // Remove elements not useful from the deque
            while (!deque.isEmpty() && arr[deque.peekLast()] <= arr[i]) {
                deque.pollLast();
            }

            // Add the current element at the rear of the deque
            deque.addLast(i);

            // Add the maximum of the current window
            result.add(arr[deque.peekFirst()]);
        }

        return result;
    }

    public static void main(String[] args) {
        Max_subArray solution = new Max_subArray();
        int[] arr = {1, 2, 3, 1, 4, 5, 2, 3, 6, 7};
        int k = 3;
        ArrayList<Integer> result = max_of_subarrays(arr, arr.length, k);
        System.out.println(result);
    }
}
