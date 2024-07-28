package Curious_Freaks.binarytree;

import july_15.TreeNode;


// Definition of TreeNode structure
//// for a binary tree node
//class TreeNode {
//    // Value of the node
//    int val;
//
//    // Pointer to the left child node
//    TreeNode left;
//
//    // Pointer to the right child node
//    TreeNode right;
//
//    // Constructor to initialize the node with a
//    // value and set left and right pointers to null
//    TreeNode(int x) {
//        val = x;
//        left = null;
//        right = null;
//    }
//}

class Solution02 {
    // This function searches for a node with
    // a specified value in a Binary Search Tree (BST).
    public TreeNode searchBST(TreeNode root, int val) {
        // Loop until either the tree is
        // exhausted (null) or the value is found.
        while (root != null && root.val != val) {
            // Check if the target value is
            // less than the current node's value.
            // If so, move to the left subtree
            // (values smaller than the current node).
            // Otherwise, move to the right subtree
            // (values larger than the current node).
            root = val < root.val ? root.left : root.right;
        }
        // Return the node containing the target value,
        // if found; otherwise, return null.
        return root;
    }
}

class Main {
    // Function to perform an in-order traversal
    // of a binary tree and print its nodes
    public static void printInOrder(TreeNode root) {
        // Check if the current node
        // is null (base case for recursion)
        if (root == null) {
            // If null, return and
            // terminate the function
            return;
        }

        // Recursively call printInOrder
        // for the left subtree
        printInOrder(root.left);

        // Print the value of the current node
        System.out.print(root.val + " ");

        // Recursively call printInOrder
        // for the right subtree
        printInOrder(root.right);
    }

    public static void main(String[] args) {
        // Creating a BST
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(10);

        System.out.println("Binary Search Tree: ");
        printInOrder(root);
        System.out.println();

        Solution02 solution = new Solution02();

        // Searching for a value in the BST
        int target = 6;
        TreeNode result = solution.searchBST(root, target);

        // Displaying the search result
        if (result != null) {
            System.out.println("Value " + target + " found in the BST!");
        } else {
            System.out.println("Value " + target + " not found in the BST.");
        }
    }
}

