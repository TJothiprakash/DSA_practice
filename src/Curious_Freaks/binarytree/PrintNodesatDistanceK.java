package Curious_Freaks.binarytree;

import java.util.*;
/*

// TreeNode class
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
}
*/

// Class to find nodes at a distance K from a target node
class PrintAllNodesAtDistanceK {

    // Main method
    public static void main(String[] args) {
        // Create a sample tree for testing
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        PrintAllNodesAtDistanceK sol = new PrintAllNodesAtDistanceK();
        TreeNode target = root.left; // target node with value 5
        int k = 2;

        // Find nodes at distance 2 from the target node
        List<Integer> result = sol.distanceK(root, target, k);

        // Print the elements at distance k from the target node
        System.out.print("Nodes at distance " + k + " from target node " + target.val + ": ");
        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    // Helper function to mark parents of nodes in the tree
    void markParents(TreeNode root, Map<TreeNode, TreeNode> parentTrack) {
        // Level Order Traversal by taking a queue
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        // Iterate over all nodes
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            // Assign parents to left child and right child if they exist
            if (current.left != null) {
                parentTrack.put(current.left, current);
                queue.add(current.left);
            }

            if (current.right != null) {
                parentTrack.put(current.right, current);
                queue.add(current.right);
            }
        }
    }

    // Function to find nodes at a distance K from the target node
    List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        // Map to mark the parents of all nodes
        Map<TreeNode, TreeNode> parentTrack = new HashMap<>();
        // Mark parents of all nodes
        markParents(root, parentTrack);
        // Keeps track of visited nodes
        Map<TreeNode, Boolean> visited = new HashMap<>();
        // Queue to perform level-order traversal
        Queue<TreeNode> queue = new LinkedList<>();
        // Start traversal from the target node
        queue.add(target);
        // Mark the target node as visited
        visited.put(target, true);
        // Tracks the current level while traversing the tree
        int currLevel = 0;

        // Continue traversal until the queue is empty
        while (!queue.isEmpty()) {
            // Get the number of nodes at the current level
            int size = queue.size();
            if (currLevel++ == k) {
                // Break if the current level matches the required distance (k)
                break;
            }

            // Traverse the current level of the tree
            for (int i = 0; i < size; i++) {
                // Get the front node in the queue
                TreeNode current = queue.poll();

                // Add unvisited left child to the queue
                if (current.left != null && !visited.containsKey(current.left)) {
                    queue.add(current.left);
                    // Mark left child as visited
                    visited.put(current.left, true);
                }

                // Add unvisited right child to the queue
                if (current.right != null && !visited.containsKey(current.right)) {
                    queue.add(current.right);
                    // Mark right child as visited
                    visited.put(current.right, true);
                }

                // Add unvisited parent node to the queue
                if (parentTrack.containsKey(current) && !visited.containsKey(parentTrack.get(current))) {
                    queue.add(parentTrack.get(current));
                    // Mark parent node as visited
                    visited.put(parentTrack.get(current), true);
                }
            }
        }

        // Stores nodes at distance k from the target
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            // Extract nodes at distance k from the queue
            TreeNode current = queue.poll();
            // Store node values in the result list
            result.add(current.val);
        }

        // Return nodes at distance K from the target
        return result;
    }
}
