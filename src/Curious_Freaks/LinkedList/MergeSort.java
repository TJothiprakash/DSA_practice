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

class Solution06 {
    // Function to sort a linked list using Merge Sort
    public Node mergeSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        // Step 1: Split the list into two halves
        Node middle = getMiddle(head);
        Node nextOfMiddle = middle.next;
        middle.next = null;

        // Step 2: Recursively sort both halves
        Node left = mergeSort(head);
        Node right = mergeSort(nextOfMiddle);

        // Step 3: Merge the sorted halves
        return sortedMerge(left, right);
    }

    // Function to merge two sorted linked lists
    private Node sortedMerge(Node left, Node right) {
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }

        Node result;
        if (left.data <= right.data) {
            result = left;
            result.next = sortedMerge(left.next, right);
        } else {
            result = right;
            result.next = sortedMerge(left, right.next);
        }
        return result;
    }

    // Function to get the middle of the linked list
    private Node getMiddle(Node head) {
        if (head == null) {
            return head;
        }

        Node slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}

// Test the function with a sample input
class Main01 {
    public static void main(String[] args) {
        // Creating the linked list: 3 -> 5 -> 2 -> 4 -> 1
        Node head = new Node(3);
        head.next = new Node(5);
        head.next.next = new Node(2);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(1);

        // Sort the linked list using merge sort
        Solution06 solution = new Solution06();
        head = solution.mergeSort(head);

        // Print the sorted linked list
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }
}

public class MergeSort {
}
