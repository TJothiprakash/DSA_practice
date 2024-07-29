package Curious_Freaks.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Streams {
    //ok
}


class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example 1
        int k1 = 4;
        int[] arr1 = {1, 2, 3, 4, 5, 6};
        System.out.println(sol.kthLargest(k1, arr1.length, arr1)); // Output: [-1, -1, -1, 1, 2, 3]

        // Example 2
        int k2 = 1;
        int[] arr2 = {3, 4};
        System.out.println(sol.kthLargest(k2, arr2.length, arr2)); // Output: [3, 4]
    }

    public List<Integer> kthLargest(int k, int n, int[] arr) {
        List<Integer> result = new ArrayList<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            minHeap.offer(arr[i]);
            if (minHeap.size() > k) {
                minHeap.poll(); // Remove the smallest element if the heap size exceeds k
            }

            // Check if the heap has at least k elements
            if (minHeap.size() < k) {
                result.add(-1);
            } else {
                result.add(minHeap.peek()); // The root of the min-heap is the Kth largest element
            }
        }

        return result;
    }
}
