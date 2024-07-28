package Curious_Freaks.binarytree;

class TreeNode {
    int val;
    TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

public class findMinandMaxofBST {

    // Example usage
    public static void main(String[] args) {
        // Example 1: Binary Tree
        TreeNode root1 = new TreeNode(11);
        root1.left = new TreeNode(7);
        root1.right = new TreeNode(9);
        root1.left.left = new TreeNode(1);
        root1.left.right = new TreeNode(12);

        findMinandMaxofBST solution = new findMinandMaxofBST();
        int min1 = solution.findMin(root1);
        int max1 = solution.findMax(root1);
        System.out.println("Example 1: Min = " + min1 + ", Max = " + max1); // Output: Min = 1, Max = 12

        // Example 2: Binary Tree
        TreeNode root2 = new TreeNode(6);
        root2.left = new TreeNode(5);
        root2.right = new TreeNode(8);
        root2.left.left = new TreeNode(2);

        int min2 = solution.findMin(root2);
        int max2 = solution.findMax(root2);
        System.out.println("Example 2: Min = " + min2 + ", Max = " + max2); // Output: Min = 2, Max = 8
    }

    // Function to find the minimum value in the binary tree
    public int findMin(TreeNode root) {
        if (root == null) {
            return Integer.MAX_VALUE; // Return a large value for empty tree
        }

        int minValue = root.val;
        int leftMin = findMin(root.left);
        int rightMin = findMin(root.right);

        if (leftMin < minValue) {
            minValue = leftMin;
        }
        if (rightMin < minValue) {
            minValue = rightMin;
        }

        return minValue;
    }

    // Function to find the maximum value in the binary tree
    public int findMax(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE; // Return a small value for empty tree
        }

        int maxValue = root.val;
        int leftMax = findMax(root.left);
        int rightMax = findMax(root.right);

        if (leftMax > maxValue) {
            maxValue = leftMax;
        }
        if (rightMax > maxValue) {
            maxValue = rightMax;
        }

        return maxValue;
    }
}
