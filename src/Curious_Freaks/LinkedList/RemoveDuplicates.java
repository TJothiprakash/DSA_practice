package Curious_Freaks.LinkedList;

// https://leetcode.com/problems/remove-duplicates-from-sorted-list/

/*class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}*/

class GfG {
    // Function to remove duplicates from a sorted linked list
    Node removeDuplicates(Node head) {
        // Your code here
        if (head == null) return head;

        Node current = head;

        while (current != null && current.next != null) {
            if (current.data == current.next.data) {
                // Bypass the duplicate node
                current.next = current.next.next;
            } else {
                // Move to the next node if no duplicate
                current = current.next;
            }
        }

        return head;
    }
}

// Test the function with a sample input
class Main1 {
    public static void main(String[] args) {
        // Creating the linked list: 2 -> 2 -> 4 -> 5
        Node head = new Node(2);
        head.next = new Node(2);
        head.next.next = new Node(4);
        head.next.next.next = new Node(5);

        // Remove duplicates from the linked list
        GfG gfg = new GfG();
        head = gfg.removeDuplicates(head);

        // Print the linked list after removing duplicates
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }
}

public class RemoveDuplicates {
}
