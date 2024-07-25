package Curious_Freaks.LinkedList;

import java.util.HashSet;

class LinkedList {

    static Node head; // head of list

    // funtion to detect and remove loop from linked list
    static void removeLoop(Node head) {
        HashSet<Node> s = new HashSet<Node>();
        Node prev = null;
        while (head != null) {
            // If we have already has this node
            // in hashmap it means there is a cycle, and we
            // need to remove this cycle so set the next of
            // the previous pointer with null.

            if (s.contains(head)) {
                prev.next = null;
                return;
            }

            // If we are seeing the node for
            // the first time, insert it in hash
            else {
                s.add(head);
                prev = head;
                head = head.next;
            }
        }
    }

    /* Driver program to test above function */
    public static void main(String[] args) {
        LinkedList llist = new LinkedList();

        head = new Node(50);
        head.next = new Node(20);
        head.next.next = new Node(15);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(10);

        /*Create loop for testing */
        head.next.next.next.next.next
                = head.next.next;

        removeLoop(head);
        System.out.println(
                "Linked List after removing loop");
        llist.printList(head);
    }

    // Function to print the linked list
    void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    /* Linked list Node*/
    static class Node {
        int data;
        Node next;

        Node(int x) {
            data = x;
            next = null;
        }
    }
}

public class RemoveLoop {
}
