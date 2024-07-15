package july_15;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CreateBinaryTree {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 1}, {2, 3, 0}, {3, 4, 1}};
        Solution sol = new Solution();
        TreeNode root = sol.createBinaryTree(arr);

        System.out.println(root.val);

    }

}

// hashmap method -2
class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        if (descriptions == null || descriptions.length == 0) return null;

        Map<Integer, TreeNode> map = new HashMap<>();

        // Step 1: Create nodes and populate the map
        for (int[] desc : descriptions) {
            int parent = desc[0];
            int child = desc[1];
            int isLeft = desc[2];

            TreeNode parentNode = map.computeIfAbsent(parent, TreeNode::new);
            TreeNode childNode = map.computeIfAbsent(child, TreeNode::new);

            if (isLeft == 1) {
                parentNode.left = childNode;
            } else {
                parentNode.right = childNode;
            }
        }

        // Step 2: Find the root node
        TreeNode root = null;
        Set<Integer> childSet = new HashSet<>();

        for (int[] desc : descriptions) {
            int child = desc[1];
            childSet.add(child);
        }

        for (int[] desc : descriptions) {
            int parent = desc[0];
            if (!childSet.contains(parent)) {
                root = map.get(parent);
                break;
            }
        }

        return root;
    }
}

/*import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

/*
class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        if (descriptions == null || descriptions.length == 0) return null;

        Map<Integer, TreeNode> map = new HashMap<>();

        // Step 1: Create nodes and populate the map
        for (int[] desc : descriptions) {
            int parent = desc[0];
            int child = desc[1];
            int isLeft = desc[2];

            TreeNode parentNode = map.computeIfAbsent(parent, TreeNode::new);
            TreeNode childNode = map.computeIfAbsent(child, TreeNode::new);

            if (isLeft == 1) {
                parentNode.left = childNode;
            } else {
                parentNode.right = childNode;
            }
        }

        // Step 2: Find the root node
        TreeNode root = null;
        Set<Integer> childSet = new HashSet<>();

        for (int[] desc : descriptions) {
            int child = desc[1];
            childSet.add(child);
        }

        for (int[] desc : descriptions) {
            int parent = desc[0];
            if (!childSet.contains(parent)) {
                root = map.get(parent);
                break;
            }
        }

        return root;
    }
}
*/
