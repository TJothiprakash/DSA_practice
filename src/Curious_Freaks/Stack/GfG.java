package Curious_Freaks.Stack;

import java.util.Stack;

public class GfG {
    public Stack<Integer> sort(Stack<Integer> s) {
        // Base case: If stack is empty or has only one element
        if (s.isEmpty()) {
            return s;
        }

        // Remove the top element
        int top = s.pop();

        // Recursively sort the remaining stack
        sort(s);

        // Insert the removed element back in sorted order
        insertSorted(s, top);

        return s;
    }

    // Function to insert an element into the sorted stack
    private void insertSorted(Stack<Integer> s, int x) {
        // Base case: If stack is empty or x is greater than the top element
        if (s.isEmpty() || x >= s.peek()) {
            s.push(x);
            return;
        }

        // Remove the top element
        int top = s.pop();

        // Recursive call to insert x in the sorted stack
        insertSorted(s, x);

        // Push the top element back
        s.push(top);
    }
}
