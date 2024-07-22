package Curious_Freaks.LinkedList;

public class ArraytoLinkedList {
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
// traversal in linked list

        Node head = coventArraytolist(arr);
        Node node = head;
        while (node != null) {
            //   System.out.print(node.data + " ");
            node = node.next;
        }

        //head = deleteHead(head);
        head = deleteKthElement(head, 5);


        // Node node1 = insertAtHead(head, 432);
        Node node1 = insertAtKthposition(head, 432, 5);
        // node1 = head;
        while (node1 != null) {
            System.out.print(node1.data + " ");
            node1 = node1.next;
        }

        //deleteTail(head);
        //deleteTail(head);
        /*Node node1 = head;
        while (node1 != null) {
            System.out.print(node1.data + " ");
          //  node1 = node1.next;
        }*/
    }

    static Node coventArraytolist(int[] arr) {

        Node head = new Node(arr[0]);
        Node it = head;
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            it.next = temp;
            it = temp;
        }
        return head;
    }

    static Node deleteHead(Node head) {
        if (head == null) return head;
        Node temp = head;
        head = head.next;
        temp.next = null;
        return head;

    }

    static void deleteTail(Node head) {

        while (head.next.next != null) {
            head = head.next;
        }
        head.next = null;
        //    return head;
    }


    static Node deleteKthElement(Node head, int k) {
        if (head == null) return head;
        if (k == 1) return head.next;

        Node temp = null, prev = null;
        int count = 0;
        temp = head;
        while (temp != null) {
            count++;
            if (count == k) {
                prev.next = prev.next.next;
                break;
            }
            prev = temp;
            temp = temp.next;

        }
        return head;


    }

    static Node insertAtHead(Node head, int data) {
        Node temp = new Node(data);
        temp.next = head;
        return temp;
    }

    static Node insertAtKthposition(Node head, int data, int k) {
        Node temp = new Node(data);
        if (head == null) return head;
        if (k == 1) {
            temp.next = head;
            return temp;
        }
        int count = 0;
        Node pre = null, cur = head;

        while (cur != null) {
            count++;
            if (k == count) {
                pre.next = temp;
                temp.next = cur;
                break;
            }
            pre = cur;
            cur = cur.next;
        }
        return head;
    }


}

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }

}
