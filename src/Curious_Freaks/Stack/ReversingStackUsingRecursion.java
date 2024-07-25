package Curious_Freaks.Stack;

import java.util.Stack;

class Solution06 {

    // Function to reverse the stack
    public static void reverse(Stack<Integer> st) {
        if (st.isEmpty()) {
            return;
        }

        // Remove the top element
        int top = st.pop();

        // Reverse the remaining stack
        reverse(st);

        // Insert the removed element at the bottom of the reversed stack
        insertAtBottom(st, top);
    }

    // Function to insert an element at the bottom of the stack
    private static void insertAtBottom(Stack<Integer> st, int x) {
        if (st.isEmpty()) {
            st.push(x);
        } else {
            // Remove the top element
            int top = st.pop();

            // Recursive call to insert x at the bottom
            insertAtBottom(st, x);

            // Push the top element back
            st.push(top);
        }
    }

    public static void main(String[] args) {
        Stack<Integer> st1 = new Stack<>();
        st1.push(3);
        st1.push(2);
        st1.push(1);
        st1.push(7);
        st1.push(6);
        reverse(st1);
        System.out.println(st1); // Output: [6, 7, 1, 2, 3]

        Stack<Integer> st2 = new Stack<>();
        st2.push(4);
        st2.push(3);
        st2.push(9);
        st2.push(6);
        reverse(st2);
        System.out.println(st2); // Output: [6, 9, 3, 4]
    }
}

public class ReversingStackUsingRecursion {
}
