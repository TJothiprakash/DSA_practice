package Curious_Freaks.Stack;

import java.util.ArrayList;
import java.util.Stack;

// next smaller elemenf for both right and left sides
class Solution12 {
    static ArrayList<Integer> nextSmallerElement(ArrayList<Integer> arr, int n) {
        ArrayList<Integer> result = new ArrayList<>(n);
        Stack<Integer> stack = new Stack<>();

        // Initialize result list with -1
        for (int i = 0; i < n; i++) {
            result.add(-1);
        }

        for (int i = n - 1; i >= 0; i--) {
            // Pop elements from the stack until we find a smaller element
            while (!stack.isEmpty() && stack.peek() >= arr.get(i)) {
                stack.pop();
            }

            // If stack is not empty, then the top element is the next smaller element
            if (!stack.isEmpty()) {
                result.set(i, stack.peek());
            }

            // Push the current element onto the stack
            stack.push(arr.get(i));
        }

        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr1 = new ArrayList<>();
        arr1.add(2);
        arr1.add(1);
        arr1.add(4);
        arr1.add(3);
        System.out.println(nextSmallerElement(arr1, arr1.size())); // Output: [1, -1, 3, -1]

        ArrayList<Integer> arr2 = new ArrayList<>();
        arr2.add(1);
        arr2.add(3);
        arr2.add(2);
        System.out.println(nextSmallerElement(arr2, arr2.size())); // Output: [-1, 2, -1]
    }
}

public class NextSmallestElement {
}

class Solution14 {
    static ArrayList<Integer> nextSmallerElementToLeft(ArrayList<Integer> arr, int n) {
        ArrayList<Integer> result = new ArrayList<>(n);
        Stack<Integer> stack = new Stack<>();

        // Initialize result list with -1
        for (int i = 0; i < n; i++) {
            result.add(-1);
        }

        for (int i = 0; i < n; i++) {
            // Pop elements from the stack until we find a smaller element
            while (!stack.isEmpty() && stack.peek() >= arr.get(i)) {
                stack.pop();
            }

            // If stack is not empty, then the top element is the next smaller element
            if (!stack.isEmpty()) {
                result.set(i, stack.peek());
            }

            // Push the current element onto the stack
            stack.push(arr.get(i));
        }

        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr1 = new ArrayList<>();
        arr1.add(2);
        arr1.add(1);
        arr1.add(4);
        arr1.add(3);
        System.out.println(nextSmallerElementToLeft(arr1, arr1.size())); // Output: [-1, -1, 1, 1]

        ArrayList<Integer> arr2 = new ArrayList<>();
        arr2.add(1);
        arr2.add(3);
        arr2.add(2);
        System.out.println(nextSmallerElementToLeft(arr2, arr2.size())); // Output: [-1, 1, 1]
    }
}
