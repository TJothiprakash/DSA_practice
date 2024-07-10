package test;

import test.Solution;


public class SlidingWindow {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String answerKey = "TTFTTTFTF";
        int k = 2;

        int result = solution.maxConsecutiveAnswers(answerKey, k);
        System.out.println(result); // Expected output: 4
    }
}
