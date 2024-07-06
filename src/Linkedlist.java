
class Node{
    int data;
    Node next;

    Node(int data){
        this.data = data;
        this.next =null;

    }

}
public class Linkedlist {

    public static void main(String[] args) {
        Node p1 = new Node(10);
        Node p2 = new Node(20);
        Node p3 = new Node(30);
        Node p4 = new Node(40);

        // System.out.println(p1.data);
        p1.next = p2;
        p2.next = p3;
        p3.next = p4;

        System.out.println(p2.data);
        Node head =p1;



    }
}
