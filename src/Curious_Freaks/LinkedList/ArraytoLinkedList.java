package Curious_Freaks.LinkedList;

public class ArraytoLinkedList {
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
// traversal in linked list
/*
     //   Node head = coventArraytolist(arr);
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

    static Node2 coventArraytolist(int[] arr) {

        Node2 head = new Node2(arr[0]);
        Node2 it = head;
        for (int i = 1; i < arr.length; i++) {
            Node2 temp = new Node2(arr[i]);
            it.next = temp;
            it = temp;
        }
        return head;
    }

    static Node2 deleteHead(Node2 head) {
        if (head == null) return head;
        Node2 temp = head;
        head = head.next;
        temp.next = null;
        return head;

    }

    static void deleteTail(Node2 head) {

        while (head.next.next != null) {
            head = head.next;
        }
        head.next = null;
        //    return head;
    }


    static Node2 deleteKthElement(Node2 head, int k) {
        if (head == null) return head;
        if (k == 1) return head.next;

        Node2 temp = null, prev = null;
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

    static Node2 insertAtHead(Node2 head, int data) {
        Node2 temp = new Node2(data);
        temp.next = head;
        return temp;
    }

    static Node2 insertAtKthposition(Node2 head, int data, int k) {
        Node2 temp = new Node2(data);
        if (head == null) return head;
        if (k == 1) {
            temp.next = head;
            return temp;
        }
        int count = 0;
        Node2 pre = null, cur = head;

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
