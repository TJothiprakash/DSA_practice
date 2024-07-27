package Curious_Freaks.binarytree;

import java.util.ArrayList;
import java.util.Stack;

public class BundaryTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        ArrayList<Integer> ans = BoundaryTraversal.boundaryTraversal(root);
        //   )boundaryTraversal(root);
        for (int i : ans
        ) {
            System.out.println(i);
        }
        System.out.println(ans);
    }

    private static boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int item) {
            data = item;
            left = right = null;
        }
    }

    public class BoundaryTraversal {
        public static ArrayList<Integer> boundaryTraversal(TreeNode root) {
            ArrayList<Integer> ans = new ArrayList<>();
            if (root == null) return ans;

            // Add root node
            ans.add(root.data);

            // Add left boundary excluding the leaf nodes
            addLeftBoundary(root.left, ans);

            // Add all leaf nodes
            addLeaves(root.left, ans);
            addLeaves(root.right, ans);

            // Add right boundary excluding the leaf nodes
            addRightBoundary(root.right, ans);

            return ans;
        }

        private static void addLeftBoundary(TreeNode node, ArrayList<Integer> ans) {
            while (node != null) {
                if (!isLeaf(node)) {
                    ans.add(node.data);
                }
                if (node.left != null) {
                    node = node.left;
                } else {
                    node = node.right;
                }
            }
        }

        private static void addRightBoundary(TreeNode node, ArrayList<Integer> ans) {
            Stack<Integer> st = new Stack<>();
            while (node != null) {
                if (!isLeaf(node)) {
                    st.push(node.data);
                }
                if (node.right != null) {
                    node = node.right;
                } else {
                    node = node.left;
                }
            }
            while (!st.isEmpty()) {
                ans.add(st.pop());
            }
        }

        private static void addLeaves(TreeNode node, ArrayList<Integer> ans) {
            if (node == null) return;
            if (isLeaf(node)) {
                ans.add(node.data);
            } else {
                addLeaves(node.left, ans);
                addLeaves(node.right, ans);
            }

        }


    }
}