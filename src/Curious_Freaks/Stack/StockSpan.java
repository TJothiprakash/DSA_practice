package Curious_Freaks.Stack;

import java.util.Stack;

class Solution {
    public static int[] calculateSpan(int[] price, int n) {
        int[] span = new int[n];
        Stack<Integer> stack = new Stack<>();

        // Traverse each day
        for (int i = 0; i < n; i++) {
            // While the stack is not empty and the price at the top of the stack is less than or equal to current price
            while (!stack.isEmpty() && price[stack.peek()] <= price[i]) {
                stack.pop();
            }

            // If the stack is empty, span is i + 1 (all previous days including current day)
            if (stack.isEmpty()) {
                span[i] = i + 1;
            } else {
                // Span is the difference between current day and the top of the stack
                span[i] = i - stack.peek();
            }

            // Push the current day index onto the stack
            stack.push(i);
        }

        return span;
    }

    public static void main(String[] args) {
        int[] price1 = {100, 80, 60, 70, 60, 75, 85};
        int n1 = price1.length;
        int[] result1 = calculateSpan(price1, n1);
        for (int i : result1) {
            System.out.print(i + " ");
        }
        System.out.println(); // Output: 1 1 1 2 1 4 6

        int[] price2 = {10, 4, 5, 90, 120, 80};
        int n2 = price2.length;
        int[] result2 = calculateSpan(price2, n2);
        for (int i : result2) {
            System.out.print(i + " ");
        }
        System.out.println(); // Output: 1 1 2 4 5 1
    }
}

public class StockSpan {
}
