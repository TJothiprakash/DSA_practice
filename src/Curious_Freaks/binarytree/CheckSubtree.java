package Curious_Freaks.binarytree;
/*
class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
*/

public class CheckSubtree {
    // Function to check if two trees are identical
    public static boolean isIdentical(Node root1, Node root2) {
        // Base cases
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }

        // Check if the data of both nodes is the same
        if (root1.data != root2.data) {
            return false;
        }

        // Check recursively for left and right subtrees
        return isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right);
    }

    // Function to check if S is a subtree of T
    public static boolean isSubtree(Node T, Node S) {
        // Base case
        if (S == null) {
            return true;
        }
        if (T == null) {
            return false;
        }

        // If the data of the current nodes of T and S match,
        // check if the subtrees are identical
        if (T.data == S.data && isIdentical(T, S)) {
            return true;
        }

        // Otherwise, check if S is a subtree of either the left or right subtree of T
        return isSubtree(T.left, S) || isSubtree(T.right, S);
    }

    public static void main(String[] args) {
        // Creating example trees for testing
        Node T = new Node(1);
        T.left = new Node(2);
        T.right = new Node(3);
        T.left.left = new Node(4);
        T.left.right = new Node(5);
        T.right.left = new Node(4);

        Node S = new Node(3);
        S.left = new Node(4);

        // Test example 1
        System.out.println(isSubtree(T, S) ? 1 : 0); // Output: 1

        // Modifying T for another test case
        T = new Node(26);
        T.left = new Node(10);
        T.right = null;
        T.left.left = new Node(20);
        T.left.right = new Node(30);
        T.left.left.left = new Node(40);
        T.left.left.right = new Node(60);

        S = new Node(26);
        S.left = new Node(10);
        S.right = null;
        S.left.left = new Node(20);
        S.left.right = new Node(30);
        S.left.left.left = new Node(40);
        S.left.left.right = new Node(60);

        // Test example 2
        System.out.println(isSubtree(T, S) ? 1 : 0); // Output: 1
    }
}

