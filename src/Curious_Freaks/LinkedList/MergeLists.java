package Curious_Freaks.LinkedList;
/*
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
*/

class Solution05 {
    // Function to merge two sorted linked lists
    public Node sortedMerge(Node head1, Node head2) {
        // Base cases
        if (head1 == null) return head2;
        if (head2 == null) return head1;

        // Ensure that head1 points to the smaller data
        if (head1.data > head2.data) {
            Node temp = head1;
            head1 = head2;
            head2 = temp;
        }

        // Now, head1 is the head of the merged list
        Node mergedHead = head1;

        while (head1 != null && head2 != null) {
            Node temp = null;
            // Traverse till end of the first list or smaller element
            while (head1 != null && head1.data <= head2.data) {
                temp = head1;
                head1 = head1.next;
            }
            // Link remaining nodes of second list to the first list
            temp.next = head2;

            // Swap heads
            Node swapTemp = head1;
            head1 = head2;
            head2 = swapTemp;
        }

        return mergedHead;
    }
}

// Test the function with a sample input
class Main08 {
    public static void main(String[] args) {
        // Creating the first linked list: 5 -> 10 -> 15 -> 40
        Node head1 = new Node(5);
        head1.next = new Node(10);
        head1.next.next = new Node(15);
        head1.next.next.next = new Node(40);

        // Creating the second linked list: 2 -> 3 -> 20
        Node head2 = new Node(2);
        head2.next = new Node(3);
        head2.next.next = new Node(20);

        // Merge the two linked lists
        Solution05 solution = new Solution05();
        Node mergedHead = solution.sortedMerge(head1, head2);

        // Print the merged linked list
        Node current = mergedHead;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }
}

public class MergeLists {
}
