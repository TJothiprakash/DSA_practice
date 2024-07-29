package Curious_Freaks.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import static Curious_Freaks.heap.SortStringByFrequency.sortByFrequency;

public class SortCharacters {
    public static void main(String[] args) {
        String s1 = "tree";
        System.out.println(sortByFrequency(s1)); // Output: "eert" or "eetr"
    }
}


class SortStringByFrequency {
    public static void main(String[] args) {
        String s1 = "tree";
        System.out.println(sortByFrequency(s1)); // Output: "eert" or "eetr"

        String s2 = "cccaaa";
        System.out.println(sortByFrequency(s2)); // Output: "aaaccc" or "cccaaa"

        String s3 = "Aabb";
        System.out.println(sortByFrequency(s3)); // Output: "bbAa" or "bbaA"
    }

    public static String sortByFrequency(String s) {
        // Step 1: Count frequencies
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        // Step 2: Use a max-heap to keep track of characters by frequency
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(
                (a, b) -> b.getValue() - a.getValue() // Max-heap based on frequency
        );

        // Add all characters with their frequencies to the heap
        maxHeap.addAll(frequencyMap.entrySet());

        // Step 3: Build the result string
        StringBuilder result = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> entry = maxHeap.poll();
            char c = entry.getKey();
            int freq = entry.getValue();
            // Append the character `freq` times to the result
            for (int i = 0; i < freq; i++) {
                result.append(c);
            }
        }

        return result.toString();
    }
}
