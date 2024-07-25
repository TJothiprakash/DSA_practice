package Curious_Freaks.LinkedList;


class Solution00 {
    // Function to rearrange the linked list such that all even numbers come before all odd numbers
    public Node divide(int N, Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node evenStart = null, evenEnd = null;
        Node oddStart = null, oddEnd = null;
        Node current = head;

        // Traverse the linked list and segregate nodes into even and odd lists
        while (current != null) {
            if (current.data % 2 == 0) {  // Even node
                if (evenStart == null) {
                    evenStart = current;
                    evenEnd = evenStart;
                } else {
                    evenEnd.next = current;
                    evenEnd = evenEnd.next;
                }
            } else {  // Odd node
                if (oddStart == null) {
                    oddStart = current;
                    oddEnd = oddStart;
                } else {
                    oddEnd.next = current;
                    oddEnd = oddEnd.next;
                }
            }
            current = current.next;
        }

        // If there are no even nodes or no odd nodes, return the list as is
        if (evenStart == null) {
            return head;
        }
        if (oddStart == null) {
            return evenStart;
        }

        // Combine even and odd lists
        evenEnd.next = oddStart;
        oddEnd.next = null;

        return evenStart;
    }
}

// Test the function with a sample input
class Main09 {
    public static void main(String[] args) {
        // Creating the linked list: 17 -> 15 -> 8 -> 9 -> 2 -> 4 -> 6
        Node head = new Node(17);
        head.next = new Node(15);
        head.next.next = new Node(8);
        head.next.next.next = new Node(9);
        head.next.next.next.next = new Node(2);
        head.next.next.next.next.next = new Node(4);
        head.next.next.next.next.next.next = new Node(6);

        // Rearrange the linked list
        Solution00 solution = new Solution00();
        head = solution.divide(7, head);

        // Print the rearranged linked list
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }
}

public class SegregateOddEven {
}
