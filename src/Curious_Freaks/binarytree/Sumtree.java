package Curious_Freaks.binarytree;
/*class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}*/

public class Sumtree {
    // Function to check if the given tree is a Sum Tree
    public boolean isSumTree(TreeNode root) {
        // Call the helper function and use a boolean flag to check the result
        return checkSumTree(root) != -1;
    }

    // Helper function to check if the tree is a Sum Tree and compute the subtree sum
    private int checkSumTree(TreeNode node) {
        // Base cases
        if (node == null) {
            return 0; // Sum of an empty tree is 0
        }
        if (node.left == null && node.right == null) {
            return node.val; // Leaf node
        }

        // Recurse on left and right subtrees
        int leftSum = checkSumTree(node.left);
        int rightSum = checkSumTree(node.right);

        // If either subtree is not a Sum Tree, return -1 to indicate failure
        if (leftSum == -1 || rightSum == -1) {
            return -1;
        }

        // Check if the current node's value is equal to the sum of its children
        if (node.val == leftSum + rightSum) {
            return node.val + leftSum + rightSum; // Return sum of this subtree
        } else {
            return -1; // Not a Sum Tree
        }
    }
}
