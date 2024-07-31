package Curious_Freaks.LinkedList.temp;

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

        Node head = new Node(12);
        head.next = new Node(15);
        head.next.next = new Node(10);
        head.next.next.next = new Node(11);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(2);
        head.next.next.next.next.next.next.next = new Node(3);

        head = sol.compute(head);
        sol.printList(head); // Output: 15 11 6 3
    }

    Node compute(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        // Step 1: Reverse the linked list
        head = reverse(head);

        // Step 2: Traverse the reversed list and remove nodes
        Node maxNode = head;
        Node current = head;
        while (current != null && current.next != null) {
            if (current.next.data < maxNode.data) {
                current.next = current.next.next;
            } else {
                current = current.next;
                maxNode = current;
            }
        }

        // Step 3: Reverse the list again to restore original order
        head = reverse(head);
        return head;
    }

    // Helper function to reverse a linked list
    Node reverse(Node head) {
        Node prev = null;
        Node current = head;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
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

public class RemoveRightElements {
}
