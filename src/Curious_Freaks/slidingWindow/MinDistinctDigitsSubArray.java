package Curious_Freaks.slidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
// still some logic error need to deep dive this problem

public class MinDistinctDigitsSubArray {
    public static int findSubString(String str) {
        // Create a set to store unique characters
        Set<Character> uniqueChars = new HashSet<>();
        for (char c : str.toCharArray()) {
            uniqueChars.add(c);
        }

        // Initialize variables
        int i = 0, j = 0, ans = str.length(), n = uniqueChars.size();
        Map<Character, Integer> m = new HashMap<>();

        // Sliding window technique
        while (i < str.length()) {
            // Increment the frequency of the current character
            m.put(str.charAt(i), m.getOrDefault(str.charAt(i), 0) + 1);

            // If the current window contains all unique characters
            if (m.size() == n) {
                // Shrink the window from the left
                while (m.get(str.charAt(j)) > 1) {
                    m.put(str.charAt(j), m.get(str.charAt(j)) - 1);
                    j++;
                }
                // Update the answer with the smallest window size
                ans = Math.min(ans, i - j + 1);
            }
            i++;
        }
        return ans;
    }

    public static void main(String[] args) {
       /* String s1 = "AABBBCBBAC";
        System.out.println("The length of the smallest window is: " + findSubString(s1)); // Output: 3

        String s2 = "aaab";
        System.out.println("The length of the smallest window is: " + findSubString(s2)); // Output: 2

        String s3 = "GEEKSGEEKSFOR";
        System.out.println("The length of the smallest window is: " + findSubString(s3)); // Output: 8
        */
        String test = "1210";
        System.out.println(smallestSubstring(test));
    }

    public static int smallestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
        }

        int uniqueCharCount = set.size(); // Total number of unique characters
        int ptr1 = 0, ptr2 = 0, ans = Integer.MAX_VALUE;
        Map<Character, Integer> map = new HashMap<>();

        // Sliding window technique
        while (ptr1 < s.length()) {
            // Increment the frequency of the current character
            char currentChar = s.charAt(ptr1);
            map.put(currentChar, map.getOrDefault(currentChar, 0) + 1);

            // If the current window contains all unique characters
            if (map.size() == uniqueCharCount) {
                // Shrink the window from the left
                while (map.get(s.charAt(ptr2)) > 1) {
                    map.put(s.charAt(ptr2), map.get(s.charAt(ptr2)) - 1);
                    if (map.get(s.charAt(ptr2)) == 0) {
                        map.remove(s.charAt(ptr2));
                    }
                    ptr2++;
                }
                // Update the answer with the smallest window size
                ans = Math.min(ans, ptr1 - ptr2 + 1);
            }
            ptr1++;
        }
        return ans;

    }
}

/*
* // Back-end complete function Template for Java
class Solution {
    public int smallestSubstring(String S) {
        // Set a flag to check if an answer exists
        boolean answerExist = false;

        // Initialize variables to keep track of the last positions
        int lastZero = -1, lastOne = -1, lastTwo = -1;

        // Initialize the answer length to be the length of the input string
        int ans = S.length();

        // Iterate through each character in the input string
        for (int i = 0; i < S.length(); i++) {
            // Update the last positions based on the current character
            if (S.charAt(i) == '0') {
                lastZero = i;
            } else if (S.charAt(i) == '1') {
                lastOne = i;
            } else {
                lastTwo = i;
            }

            // Check if all three positions have been updated
            if (lastZero != -1 && lastOne != -1 && lastTwo != -1) {
                // Set the flag to indicate that an answer exists
                answerExist = true;

                // Calculate the length of the substring and update the answer length
                ans = Math.min(
                    ans,
                    1 + i - Math.min(lastZero, Math.min(lastOne, lastTwo)));
            }
        }

        // Check if an answer exists and return the final answer
        if (answerExist) {
            return ans;
        }
        return -1;
    }
};
*/
