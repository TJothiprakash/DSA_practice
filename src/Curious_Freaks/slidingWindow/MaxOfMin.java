package Curious_Freaks.slidingWindow;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Stack;

public class MaxOfMin {
    public static int @NotNull [] maxOfMin(int[] arr, int N) {
        int[] result = new int[N];

        // Arrays to store previous and next smaller elements
        int[] left = new int[N];
        int[] right = new int[N];

        // Initialize left and right arrays to -1 and N respectively
        Arrays.fill(left, -1);
        Arrays.fill(right, N);

        // Stack to store indices
        Stack<Integer> stack = new Stack<>();

        // Find previous smaller elements using stack
        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                left[i] = stack.peek();
            }
            stack.push(i);
        }

        // Clear the stack for next use
        stack.clear();

        // Find next smaller elements using stack
        for (int i = N - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                right[i] = stack.peek();
            }
            stack.push(i);
        }

        // Calculate the result
        for (int i = 0; i < N; i++) {
            int windowSize = right[i] - left[i] - 1;
            result[windowSize - 1] = Math.max(result[windowSize - 1], arr[i]);
        }

        // Fill the gaps (any zeros in result array) with the last seen maximum
        for (int i = N - 2; i >= 0; i--) {
            result[i] = Math.max(result[i], result[i + 1]);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 50, 10, 70, 30};
        int N = arr.length;
        int[] result = maxOfMin(arr, N);
        System.out.println(Arrays.toString(result));
    }
}
