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

public class Isomorphic {
    // Function to check if two binary trees are isomorphic
    public boolean isIsomorphic(TreeNode r1, TreeNode r2) {
        // Base cases
        if (r1 == null && r2 == null) {
            return true;
        }
        if (r1 == null || r2 == null) {
            return false;
        }
        if (r1.val != r2.val) {
            return false;
        }

        // Check if subtrees are isomorphic with no swap or with swap
        boolean c1 = isIsomorphic(r1.left, r2.left) && isIsomorphic(r1.right, r2.right); // no swap
        boolean c2 = isIsomorphic(r1.right, r2.left) && isIsomorphic(r1.left, r2.right); // with swap

        return c1 || c2;
    }
}
