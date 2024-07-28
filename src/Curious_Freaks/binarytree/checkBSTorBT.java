package Curious_Freaks.binarytree;
// Importing necessary packages

// Definition of TreeNode structure
// for a binary tree node
/*

class TreeNode {
    // Value of the node
    int val;

    // Pointer to the left child node
    TreeNode left;
    // Pointer to the right child node
    TreeNode right;

    // Constructor to initialize the node with a
    // value and set left and right pointers to null
    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
}
*/

class checkBSTorBT {
    // Function to check if a given binary
    // tree is a valid binary search tree (BST)
    public boolean isValid(TreeNode root) {
        // Calls the helper function isValidBST
        // with initial min and max values
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    // Helper function to recursively validate the BST property
    public boolean isValidBST(TreeNode root, long minVal, long maxVal) {
        if (root == null) {
            // Base case: an empty
            // tree is a valid BST
            return true;
        }

        // Checks if the current node
        // violates the BST property
        if (root.val >= maxVal || root.val <= minVal) {
            return false;
        }

        // Recursively checks left and right
        // subtrees with updated constraints
        // that every value on its left subtree
        // should be smaller than the current node
        // and every value on its right subtree
        // should be greater than the current node
        return isValidBST(root.left, minVal, root.val)
                && isValidBST(root.right, root.val, maxVal);
    }
}

// Function to perform an in-order traversal
// of a binary tree and print its nodes
class TreeTraversal {
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
}

class Main05 {
    public static void main(String[] args) {
        checkBSTorBT solution = new checkBSTorBT();

        // Creating a sample tree
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        System.out.println("Inorder Traversal of Tree:");
        TreeTraversal.printInOrder(root);
        System.out.println();

        // Checking if the created tree is a valid BST
        boolean isValidBST = solution.isValid(root);

        if (isValidBST) {
            System.out.println("The tree is a valid BST.");
        } else {
            System.out.println("The tree is not a valid BST.");
        }
    }
}
