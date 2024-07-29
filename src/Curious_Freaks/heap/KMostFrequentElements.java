package Curious_Freaks.heap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class KMostFrequentElements {
    public static void main(String[] args) {
        int[] nums1 = {1, 1, 1, 2, 2, 3};
        int k1 = 2;
        System.out.println(Arrays.toString(findKMostFrequent(nums1, k1))); // Output: [1, 2]

        int[] nums2 = {1};
        int k2 = 1;
        System.out.println(Arrays.toString(findKMostFrequent(nums2, k2))); // Output: [1]
    }

    public static int[] findKMostFrequent(int[] nums, int k) {
        // Step 1: Count frequencies
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Use a min-heap to keep track of k most frequent elements
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
                (a, b) -> a.getValue() - b.getValue()
        );

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            minHeap.offer(entry);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // Step 3: Extract elements from the heap
        int[] result = new int[k];
        int index = 0;
        while (!minHeap.isEmpty()) {
            result[index++] = minHeap.poll().getKey();
        }

        return result;
    }
}
