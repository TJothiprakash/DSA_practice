package Curious_Freaks.LinkedList;

/*lass Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}*/

class Solution04 {
    // Function to swap elements in the linked list pairwise
    static Node pairWiseSwap(Node head) {
        // If the list is empty or has only one node, no swap needed
        if (head == null || head.next == null) {
            return head;
        }

        // Initialize pointers
        Node prev = null;
        Node current = head;
        Node next = current.next;

        // Update head to the second node
        head = next;

        // Traverse the list and swap nodes in pairs
        while (current != null && next != null) {
            // Perform the swap
            if (prev != null) {
                prev.next = next;
            }
            current.next = next.next;
            next.next = current;

            // Move to the next pair
            prev = current;
            current = current.next;
            if (current != null) {
                next = current.next;
            }
        }

        return head;
    }
}

// Test the function with a sample input
class PairWiseSwap {
    public static void main(String[] args) {
        // Creating the linked list: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
    }
}

