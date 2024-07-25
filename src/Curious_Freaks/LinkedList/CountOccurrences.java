package Curious_Freaks.LinkedList;
/*class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}*/

class Solution03 {
    // Function to segregate 0s, 1s, and 2s in a linked list
    static Node segregate(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        // Step 1: Count the number of 0s, 1s, and 2s
        int count0 = 0, count1 = 0, count2 = 0;
        Node current = head;
        while (current != null) {
            if (current.data == 0) {
                count0++;
            } else if (current.data == 1) {
                count1++;
            } else {
                count2++;
            }
            current = current.next;
        }

        // Step 2: Rearrange the nodes
        current = head;
        while (count0 > 0) {
            current.data = 0;
            current = current.next;
            count0--;
        }
        while (count1 > 0) {
            current.data = 1;
            current = current.next;
            count1--;
        }
        while (count2 > 0) {
            current.data = 2;
            current = current.next;
            count2--;
        }

        return head;
    }
}

// Test the function with a sample input
class Main {
    public static void main(String[] args) {
        // Creating the linked list: 1 -> 2 -> 2 -> 1 -> 2 -> 0 -> 2 -> 2
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);
        head.next.next.next.next = new Node(2);
        head.next.next.next.next.next = new Node(0);
        head.next.next.next.next.next.next = new Node(2);
        head.next.next.next.next.next.next.next = new Node(2);

        // Segregate the linked list
        head = Solution03.segregate(head);

        // Print the segregated linked list
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }
}


public class CountOccurrences {
}
