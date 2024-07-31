package Curious_Freaks.LinkedList;

class GfG2 {
    public static void main(String[] args) {

    }

    Node3 mergeTwoLists(Node3 a, Node3 b) {

        Node3 temp = new Node3(0);
        Node3 res = temp;

        while (a != null && b != null) {
            if (a.data < b.data) {
                temp.bottom = a;
                temp = temp.bottom;
                a = a.bottom;
            } else {
                temp.bottom = b;
                temp = temp.bottom;
                b = b.bottom;
            }
        }

        if (a != null) temp.bottom = a;
        else temp.bottom = b;
        return res.bottom;

    }

    Node3 flatten(Node3 root) {

        if (root == null || root.next == null)
            return root;

        // recur for list on right
        root.next = flatten(root.next);

        // now merge
        root = mergeTwoLists(root, root.next);

        // return the root
        // it will be in turn merged with its left
        return root;
    }
}

public class FlattenList {
}

class Node3 {
    int data;
    Node3 next;
    Node3 bottom;

    Node3(int d) {
        data = d;
        next = null;
        bottom = null;
    }
}