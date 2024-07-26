package Curious_Freaks.slidingWindow;


import java.util.ArrayList;
import java.util.List;

public class AnagramCount {

    public static void main(String[] args) {
        AnagramCount solution = new AnagramCount();
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> result = solution.findAnagrams(s, p);
        System.out.println(result); // Output: [0, 6]

        s = "abab";
        p = "ab";
        result = solution.findAnagrams(s, p);
        System.out.println(result); // Output: [0, 1, 2]
    }

    public List<Integer> findAnagrams(String s, String p) {
        // Initialize the result list
        List<Integer> result = new ArrayList<>();

        // Edge case: if length of s is less than length of p, return empty result
        if (s.length() < p.length()) {
            return result;
        }

        // Initialize frequency arrays for p and the current window in s
        int[] pHash = new int[26];
        int[] sHash = new int[26];

        // Initialize the sliding window
        int windowSize = p.length();
        for (int i = 0; i < windowSize; i++) {
            pHash[p.charAt(i) - 'a']++;
            sHash[s.charAt(i) - 'a']++;
        }

        // Slide the window across the string s
        for (int i = windowSize; i < s.length(); i++) {
            if (matches(pHash, sHash)) {
                result.add(i - windowSize);
            }
            sHash[s.charAt(i) - 'a']++;
            sHash[s.charAt(i - windowSize) - 'a']--;
        }

        // Check the last window
        if (matches(pHash, sHash)) {
            result.add(s.length() - windowSize);
        }

        return result;
    }

    private boolean matches(int[] pHash, int[] sHash) {
        for (int i = 0; i < 26; i++) {
            if (pHash[i] != sHash[i]) {
                return false;
            }
        }
        return true;
    }
}
