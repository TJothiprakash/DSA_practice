package Curious_Freaks.binarytree;

import java.util.ArrayList;
import java.util.List;
/*
// Node structure for the binary tree
class Node {
    int data;
    Node left;
    Node right;

    // Constructor to initialize
    // the node with a value
    Node(int val) {
        data = val;
        left = null;
        right = null;
    }
}*/

public class LeftRightViewofBT {

    public static void main(String[] args) {
        // Creating a sample binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(10);
        root.left.left.right = new Node(5);
        root.left.left.right.right = new Node(6);
        root.right = new Node(3);
        root.right.right = new Node(10);
        root.right.left = new Node(9);

        LeftRightViewofBT solution = new LeftRightViewofBT();

        // Get the Right View traversal
        List<Integer> rightView = solution.rightsideView(root);

        // Print the result for Right View
        System.out.print("Right View Traversal: ");
        for (int node : rightView) {
            System.out.print(node + " ");
        }
        System.out.println();

        // Get the Left View traversal
        List<Integer> leftView = solution.leftsideView(root);

        // Print the result for Left View
        System.out.print("Left View Traversal: ");
        for (int node : leftView) {
            System.out.print(node + " ");
        }
        System.out.println();
    }

    // Function to return the Right view of the binary tree
    public List<Integer> rightsideView(Node root) {
        // List to store the result
        List<Integer> res = new ArrayList<>();

        // Call the recursive function
        // to populate the right-side view
        recursionRight(root, 0, res);

        return res;
    }

    // Function to return the Left view of the binary tree
    public List<Integer> leftsideView(Node root) {
        // List to store the result
        List<Integer> res = new ArrayList<>();

        // Call the recursive function
        // to populate the left-side view
        recursionLeft(root, 0, res);

        return res;
    }

    // Recursive function to traverse the
    // binary tree and populate the left-side view
    private void recursionLeft(Node root, int level, List<Integer> res) {
        // Check if the current node is null
        if (root == null) {
            return;
        }

        // Check if the size of the result list
        // is equal to the current level
        if (res.size() == level) {
            // If equal, add the value of the
            // current node to the result list
            res.add(root.data);
        }

        // Recursively call the function for the
        // left child with an increased level
        recursionLeft(root.left, level + 1, res);

        // Recursively call the function for the
        // right child with an increased level
        recursionLeft(root.right, level + 1, res);
    }

    // Recursive function to traverse the
    // binary tree and populate the right-side view
    private void recursionRight(Node root, int level, List<Integer> res) {
        // Check if the current node is null
        if (root == null) {
            return;
        }

        // Check if the size of the result list
        // is equal to the current level
        if (res.size() == level) {
            // If equal, add the value of the
            // current node to the result list
            res.add(root.data);

            // Recursively call the function for the
            // right child with an increased level
            recursionRight(root.right, level + 1, res);

            // Recursively call the function for the
            // left child with an increased level
            recursionRight(root.left, level + 1, res);
        }
    }
}


