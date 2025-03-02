package Curious_Freaks.stringHard;

import java.util.Stack;

class Sol {
    int countRev(String S) {
        // your code here
        if (S.length() % 2 != 0) {
            return -1;
        }


        Stack<Character> stack = new Stack<>();

        // Traverse the string
        for (char ch : S.toCharArray()) {
            if (ch == '{') {
                stack.push(ch);
            } else {
                if (!stack.isEmpty() && stack.peek() == '{') {
                    stack.pop(); // Matching pair found
                } else {
                    stack.push(ch); // No match, push to stack
                }
            }
        }

        // At this point, the stack contains unmatched brackets
        int leftBraces = 0; // Count of unmatched '{'
        int rightBraces = 0; // Count of unmatched '}'

        while (!stack.isEmpty()) {
            if (stack.pop() == '{') {
                leftBraces++;
            } else {
                rightBraces++;
            }
        }

        // Calculate the number of reversals needed
        int reversals = (leftBraces + 1) / 2 + (rightBraces + 1) / 2;
        return reversals;
    }
}

public class BracketReversals {
}
