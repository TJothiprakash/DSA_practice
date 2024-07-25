package Curious_Freaks.Stack;


class tuf {

    public static void main(String[] args) {

        stack s = new stack();
        s.push(6);
        s.push(3);
        s.push(7);
        System.out.println("Top of the stack before deleting any element " + s.top());
        System.out.println("Size of the stack before deleting any element " + s.size());
        System.out.println("The element deleted is " + s.pop());
        System.out.println("Size of the stack after deleting an element " + s.size());
        System.out.println("Top of the stack after deleting an element " + s.top());
    }
}

class stack {
    int size = 10000;
    int[] arr = new int[size];
    int top = -1;

    void push(int x) {
        top++;
        arr[top] = x;
    }

    int pop() {
        int x = arr[top];
        top--;
        return x;
    }

    int top() {
        return arr[top];
    }

    int size() {
        return top + 1;
    }
}

public class StackImplementation {
}
/*class TwoStacks {
    int size = 200;
    int[] arr;
    int top1, top2;

    TwoStacks() {
        arr = new int[size];
        top1 = -1;
        top2 = size;
    }

    // Function to push an integer into stack1.
    void push1(int x) {
        if (top1 < top2 - 1) {
            arr[++top1] = x;
        } else {
            System.out.println("Stack Overflow in Stack1");
        }
    }

    // Function to push an integer into stack2.
    void push2(int x) {
        if (top1 < top2 - 1) {
            arr[--top2] = x;
        } else {
            System.out.println("Stack Overflow in Stack2");
        }
    }

    // Function to remove an element from top of stack1.
    int pop1() {
        if (top1 >= 0) {
            return arr[top1--];
        } else {
            System.out.println("Stack Underflow in Stack1");
            return -1; // Return a sentinel value or throw an exception
        }
    }

    // Function to remove an element from top of stack2.
    int pop2() {
        if (top2 < size) {
            return arr[top2++];
        } else {
            System.out.println("Stack Underflow in Stack2");
            return -1; // Return a sentinel value or throw an exception
        }
    }

    // Optional: Function to check if stack1 is empty
    boolean isEmpty1() {
        return top1 == -1;
    }

    // Optional: Function to check if stack2 is empty
    boolean isEmpty2() {
        return top2 == size;
    }

    // Optional: Function to get the top element of stack1
    int peek1() {
        if (top1 >= 0) {
            return arr[top1];
        } else {
            System.out.println("Stack1 is empty");
            return -1; // Return a sentinel value or throw an exception
        }
    }

    // Optional: Function to get the top element of stack2
    int peek2() {
        if (top2 < size) {
            return arr[top2];
        } else {
            System.out.println("Stack2 is empty");
            return -1; // Return a sentinel value or throw an exception
        }
    }

    public static void main(String[] args) {
        TwoStacks ts = new TwoStacks();
*/