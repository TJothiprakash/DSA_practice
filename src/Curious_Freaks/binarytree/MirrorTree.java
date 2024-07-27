package Curious_Freaks.binarytree;


/*
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
*/

public class MirrorTree {
    public static void main(String[] args) {
        MirrorTree tree = new MirrorTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        tree.mirrorTree(root);
        tree.printTree(root);
    }

    // Function to convert the binary tree into its mirror tree
    public void mirrorTree(TreeNode root) {
        if (root == null) {
            return;
        }

        // Swap the left and right children
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // Recursively mirror the left and right subtrees
        mirrorTree(root.left);
        mirrorTree(root.right);
    }

    // Optional: Helper method to print the tree for verification
    public void printTree(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }
}
