package Curious_Freaks.LinkedList.temp2;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example 1
        Node head1 = new Node(9);
        head1.next = new Node(1);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(5);
        head1.next.next.next.next = new Node(9);
        head1.next.next.next.next.next = new Node(4);
        head1.next.next.next.next.next.next = new Node(10);
        head1.next.next.next.next.next.next.next = new Node(1);

        head1 = sol.deleteNodes(head1, 1, 2);
        sol.printList(head1); // Output: 9 1 5 9 10 1

        // Example 2
        Node head2 = new Node(1);
        head2.next = new Node(2);
        head2.next.next = new Node(3);
        head2.next.next.next = new Node(4);
        head2.next.next.next.next = new Node(5);
        head2.next.next.next.next.next = new Node(6);

        head2 = sol.deleteNodes(head2, 1, 6);
        sol.printList(head2); // Output: 1 2 3 4 5 6
    }

    Node deleteNodes(Node head, int n, int m) {
        if (head == null || (n == 0 && m == 0)) {
            return head;
        }

        Node current = head;

        while (current != null) {
            // Skip m nodes
            for (int i = 1; i < m && current != null; i++) {
                current = current.next;
            }

            if (current == null) {
                return head;
            }

            // Delete n nodes
            Node temp = current.next;
            for (int i = 0; i < n && temp != null; i++) {
                temp = temp.next;
            }

            // Connect the last skipped node to the node after the deleted ones
            current.next = temp;

            // Move to the next segment
            current = temp;
        }

        return head;
    }

    // Helper function to print the list
    void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

public class DeleteNnodes {
}
