package Curious_Freaks.LinkedList;


/*
class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}*/

class Solution {
    // Helper function to create a linked list with a loop
    public static Node createLinkedList(int[] values, int pos) {
        if (values == null || values.length == 0) {
            return null;
        }

        Node head = new Node(values[0]);
        Node current = head;
        Node loopNode = null;

        for (int i = 1; i < values.length; i++) {
            current.next = new Node(values[i]);
            current = current.next;

            // If pos is equal to i, store the reference to create a loop later
            if (i == pos - 1) {
                loopNode = current;
            }
        }

        // Create a loop if pos is greater than 0
        if (pos > 0) {
            current.next = loopNode;
        }

        return head;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[] values1 = {1, 3, 4};
        int pos1 = 2;
        Node head1 = createLinkedList(values1, pos1);
        System.out.println("Test case 1: " + solution.hasLoop(head1)); // Output: True

        // Test case 2
        int[] values2 = {1, 8, 3, 4};
        int pos2 = 0;
        Node head2 = createLinkedList(values2, pos2);
        System.out.println("Test case 2: " + solution.hasLoop(head2)); // Output: False

        // Test case 3
        int[] values3 = {1, 2, 3, 4};
        int pos3 = 1;
        Node head3 = createLinkedList(values3, pos3);
        System.out.println("Test case 3: " + solution.hasLoop(head3)); // Output: True
    }

    public boolean hasLoop(Node head) {
        if (head == null || head.next == null) {
            return false;
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true; // Loop detected
            }
        }

        return false; // No loop
    }
}

public class DetectLoop {
}
