package Curious_Freaks.LinkedList;

// https://www.geeksforgeeks.org/find-first-node-of-loop-in-linked-list/

class Solution08 {
    //Function to find first node if the linked list has a loop.
    public static int findFirstNode(Node head) {
        //code here

        if (head == null || head.next == null) {
            return -1;
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow.data;
            }
        }

        return -1;
    }
}

public class FirstNodeofCycleLinkedList {
}
