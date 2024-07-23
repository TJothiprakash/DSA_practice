package Curious_Freaks.LinkedList;

public class ReverseLinkedList {
    public static void main(String[] args) {

        Node2 head = new Node2(1);
        head.next = new Node2(2);
        head.next.next = new Node2(3);
        head.next.next.next = new Node2(4);
        head.next.next.next.next = new Node2(5);

        Node2 newHead = reverseLinkedList(head);
        while (newHead != null) {
            System.out.print(newHead.data + " ");
            newHead = newHead.next;
        }
    }

    static Node2 reverseLinkedList(Node2 head) {
        Node2 temp = head, prev = null;
        while (temp != null) {
            Node2 front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }
}
