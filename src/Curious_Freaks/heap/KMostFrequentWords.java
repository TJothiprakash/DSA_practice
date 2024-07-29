package Curious_Freaks.heap;
import java.util.*;

public class KMostFrequentWords {
    public static void main(String[] args) {
        String[] words1 = {"i","love","leetcode","i","love","coding"};
        int k1 = 2;
        System.out.println(findKMostFrequent(words1, k1)); // Output: [i, love]

        String[] words2 = {"the","day","is","sunny","the","the","the","sunny","is","is"};
        int k2 = 4;
        System.out.println(findKMostFrequent(words2, k2)); // Output: [the, is, sunny, day]
    }

    public static List<String> findKMostFrequent(String[] words, int k) {
        // Step 1: Count frequencies
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String word : words) {
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }

        // Step 2: Use a min-heap to keep track of k most frequent elements
        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(
                (a, b) -> a.getValue().equals(b.getValue()) ?
                        b.getKey().compareTo(a.getKey()) :
                        a.getValue() - b.getValue()
        );

        for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
            minHeap.offer(entry);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // Step 3: Extract elements from the heap and sort them
        List<String> result = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll().getKey());
        }
        Collections.reverse(result); // Since we used a min-heap, reverse to get the correct order

        return result;
    }
}
