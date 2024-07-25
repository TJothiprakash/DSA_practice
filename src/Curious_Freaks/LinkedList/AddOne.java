package Curious_Freaks.LinkedList;
/*class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}*/

class Solution09 {
    public Node addOne(Node head) {
        // Step 1: Convert the linked list to an array
        int length = getLength(head);
        int[] digits = new int[length];
        Node current = head;

        for (int i = length - 1; i >= 0; i--) {
            digits[i] = current.data;
            current = current.next;
        }

        // Step 2: Add 1 to the number
        int carry = 1;
        for (int i = length - 1; i >= 0; i--) {
            int sum = digits[i] + carry;
            digits[i] = sum % 10;
            carry = sum / 10;
        }

        // Step 3: Convert the array back to a linked list
        Node newHead = new Node(digits[0]);
        Node newCurrent = newHead;

        for (int i = 1; i < length; i++) {
            newCurrent.next = new Node(digits[i]);
            newCurrent = newCurrent.next;
        }

        // If there is still a carry, add a new node at the front
        if (carry > 0) {
            Node newHeadWithCarry = new Node(carry);
            newHeadWithCarry.next = newHead;
            newHead = newHeadWithCarry;
        }

        return newHead;
    }

    // Function to get the length of the linked list
    private int getLength(Node head) {
        int length = 0;
        Node current = head;
        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }
}

// Test the function with a sample input
class Main4 {
    public static void main(String[] args) {
        // Creating the linked list: 5 -> 7 -> 9
        Node head = new Node(5);
        head.next = new Node(7);
        head.next.next = new Node(9);

        // Add 1 to the number represented by the linked list
        Solution09 solution = new Solution09();
        head = solution.addOne(head);

        // Print the modified linked list
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }
}

public class AddOne {
}
