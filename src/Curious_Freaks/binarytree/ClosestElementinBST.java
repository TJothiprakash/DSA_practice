package Curious_Freaks.binarytree;


public class ClosestElementinBST {
    public static int minDiff(TreeNode root, int K) {
        // Initialize the minimum difference to a large value
        int minDiff = Integer.MAX_VALUE;
        TreeNode current = root;

        // Traverse the tree
        while (current != null) {
            // Update the minimum difference
            int currentDiff = Math.abs(current.val - K);
            if (currentDiff < minDiff) {
                minDiff = currentDiff;
            }

            // If the current node's value is equal to K, return 0
            if (current.val == K) {
                return 0;
            }

            // Move to the left or right child based on the value of K
            if (K < current.val) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        return minDiff;
    }

    public static void main(String[] args) {
        // Example 1
        TreeNode root1 = new TreeNode(10);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(11);
        root1.left.left = new TreeNode(1);
        root1.left.right = new TreeNode(5);
        root1.left.right.left = new TreeNode(3);
        root1.left.right.right = new TreeNode(6);
        root1.left.right.left.right = new TreeNode(4);

        int K1 = 13;
        System.out.println("Minimum difference: " + minDiff(root1, K1)); // Output: 2

        // Example 2
        TreeNode root2 = new TreeNode(8);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(9);
        root2.left.right = new TreeNode(4);
        root2.left.right.left = new TreeNode(3);
        root2.right.right = new TreeNode(10);

        int K2 = 9;
        System.out.println("Minimum difference: " + minDiff(root2, K2)); // Output: 0
    }

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int x) {
            val = x;
            left = right = null;
        }
    }
}
