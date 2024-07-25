package Curious_Freaks.slidingWindow;

import java.util.HashMap;

public class SubstringDistinctcount {
    // Function to count substrings of length K with exactly K-1 distinct characters
    static int countOfSubstrings(String S, int K) {
        // Edge case: if K > length of the string, return 0
        if (K > S.length()) {
            return 0;
        }

        int count = 0;
        HashMap<Character, Integer> frequencyMap = new HashMap<>();

        // Initialize the frequency map for the first window of size K
        for (int i = 0; i < K; i++) {
            frequencyMap.put(S.charAt(i), frequencyMap.getOrDefault(S.charAt(i), 0) + 1);
        }

        // Check the first window
        if (frequencyMap.size() == K - 1) {
            count++;
        }

        // Slide the window
        for (int i = K; i < S.length(); i++) {
            char newChar = S.charAt(i);
            char oldChar = S.charAt(i - K);

            // Add the new character to the frequency map
            frequencyMap.put(newChar, frequencyMap.getOrDefault(newChar, 0) + 1);

            // Remove the old character from the frequency map
            frequencyMap.put(oldChar, frequencyMap.get(oldChar) - 1);
            if (frequencyMap.get(oldChar) == 0) {
                frequencyMap.remove(oldChar);
            }

            // Check the current window
            if (frequencyMap.size() == K - 1) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        String S1 = "abcc";
        int K1 = 2;
        System.out.println(countOfSubstrings(S1, K1)); // Output: 1

        String S2 = "aabab";
        int K2 = 3;
        System.out.println(countOfSubstrings(S2, K2)); // Output: 3
    }
}
