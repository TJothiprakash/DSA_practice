package Curious_Freaks.binarytree;

import java.util.ArrayList;
import java.util.List;
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

public class PrintKpathsequaltosum {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(-1);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(1);
        root.left.right.left = new TreeNode(1);
        root.right.left = new TreeNode(4);
        root.right.left.left = new TreeNode(1);
        root.right.left.right = new TreeNode(2);
        root.right.right = new TreeNode(5);
        root.right.right.right = new TreeNode(2);

        int k = 5;
        PrintKpathsequaltosum solution = new PrintKpathsequaltosum();
        solution.kSumPaths(root, k);
    }

    // Function to find and print all k-sum paths in a binary tree
    public void kSumPaths(TreeNode root, int k) {
        List<Integer> path = new ArrayList<>();
        findKSumPaths(root, k, path);
    }

    private void findKSumPaths(TreeNode node, int k, List<Integer> path) {
        // Base case
        if (node == null) {
            return;
        }

        // Add the current node's value to the path
        path.add(node.val);

        // Check if there are any k-sum paths that end at this node
        int sum = 0;
        for (int i = path.size() - 1; i >= 0; i--) {
            sum += path.get(i);
            if (sum == k) {
                printPath(path, i);
            }
        }

        // Traverse the left and right subtrees
        findKSumPaths(node.left, k, path);
        findKSumPaths(node.right, k, path);

        // Remove the current node from the path before returning to the parent
        path.remove(path.size() - 1);
    }

    private void printPath(List<Integer> path, int start) {
        for (int i = start; i < path.size(); i++) {
            System.out.print(path.get(i) + " ");
        }
        System.out.println();
    }
}
