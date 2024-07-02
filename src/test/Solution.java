package test;
public class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        // 1. Get the length of the answerKey string
        int n = answerKey.length();

        // 2. Initialize the maximum window size
        int windowSize = 0;

        // 3. Initialize the left pointer for the sliding window
        int left = 0;

        // 4. Initialize an array to count the occurrences of 'T' and 'F'
        int[] count = new int[2]; // count[0] for 'T', count[1] for 'F'

        // 5. Iterate over each character in answerKey using the right pointer
        for (int right = 0; right < n; right++) {
            // 6. If the character at the right pointer is 'T', increment count[0]
            if (answerKey.charAt(right) == 'T') {
                count[0]++;
            } else {
                // 7. If the character at the right pointer is 'F', increment count[1]
                count[1]++;
            }

            // 8. Find the minimum count between 'T' and 'F'
            int minor = Math.min(count[0], count[1]);

            // 9. If the minimum count is less than or equal to k, expand the window
            if (minor <= k) {
                windowSize++;
            } else {
                // 10. If the minimum count is greater than k, shrink the window from the left
                if (answerKey.charAt(left) == 'T') {
                    count[0]--;
                } else {
                    count[1]--;
                }
                // 11. Move the left pointer to the right
                left++;
            }
        }

        // 12. Return the maximum window size found
        return windowSize;
    }
}
