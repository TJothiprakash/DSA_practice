package Curious_Freaks.LinkedList;

public class IntersectionPointofLinkedList {
}

/**
 * Node class for linked list
 */
class Node2 {
    public boolean data;
    int num;
    Node2 next;

    Node2(int val) {
        num = val;
        next = null;
    }
}

class TUF {
    //utility function to insert node at the end of the linked list
    static Node2 insertNode(Node2 head, int val) {
        Node2 newNode = new Node2(val);

        if (head == null) {
            head = newNode;
            return head;
        }

        Node2 temp = head;
        while (temp.next != null) temp = temp.next;

        temp.next = newNode;
        return head;
    }

    //utility function to check presence of intersection
    static Node2 intersectionPresent(Node2 head1, Node2 head2) {
        Node2 d1 = head1;
        Node2 d2 = head2;

        while (d1 != d2) {
            d1 = d1 == null ? head2 : d1.next;
            d2 = d2 == null ? head1 : d2.next;
        }

        return d1;
    }

    //utility function to print linked list created
    static void printList(Node2 head) {
        while (head.next != null) {
            System.out.print(head.num + "->");
            head = head.next;
        }
        System.out.println(head.num);
    }

    public static void main(String[] args) {
        // creation of both lists
        Node2 head = null;
        head = insertNode(head, 1);
        head = insertNode(head, 3);
        head = insertNode(head, 1);
        head = insertNode(head, 2);
        head = insertNode(head, 4);
        Node2 head1 = head;
        head = head.next.next.next;
        Node2 headSec = null;
        headSec = insertNode(headSec, 3);
        Node2 head2 = headSec;
        headSec.next = head;
        //printing of the lists
        System.out.print("List1: ");
        printList(head1);
        System.out.print("List2: ");
        printList(head2);
        //checking if intersection is present
        Node2 answerNode = intersectionPresent(head1, head2);
        if (answerNode == null)
            System.out.println("No intersection\n");
        else
            System.out.println("The intersection point is " + answerNode.num);

    }
}