package Curious_Freaks.binarytree;

public class RangeinBST {
    TreeNode root;

    RangeinBST(int key) {
        root = new TreeNode(key);
    }

    RangeinBST() {
        root = null;
    }

    public static void main(String[] args) {
        RangeinBST tree = new RangeinBST();

        // Adding nodes to the tree for Example 1
        tree.add(10);
        tree.add(5);
        tree.add(50);
        tree.add(1);
        tree.add(40);
        tree.add(100);

        int l = 5, h = 45;
        System.out.println("Number of nodes in range [" + l + ", " + h + "] : " + tree.getCountOfNode(tree.root, l, h));

        // Adding nodes to the tree for Example 2
        RangeinBST tree2 = new RangeinBST();
        tree2.add(5);
        tree2.add(4);
        tree2.add(6);
        tree2.add(3);
        tree2.add(7);

        l = 2;
        h = 8;
        System.out.println("Number of nodes in range [" + l + ", " + h + "] : " + tree2.getCountOfNode(tree2.root, l, h));
    }

    // Function to count nodes in the given range
    public int getCountOfNode(TreeNode node, int l, int h) {
        if (node == null) {
            return 0;
        }

        // Node is within range
        if (node.val >= l && node.val <= h) {
            return 1 + getCountOfNode(node.left, l, h) + getCountOfNode(node.right, l, h);
        }

        // Node is smaller than range, so move to the right subtree
        if (node.val < l) {
            return getCountOfNode(node.right, l, h);
        }

        // Node is greater than range, so move to the left subtree
        return getCountOfNode(node.left, l, h);
    }

    // Example method to add a node
    public void add(int value) {
        root = addRecursive(root, value);
    }

    private TreeNode addRecursive(TreeNode node, int value) {
        if (node == null) {
            return new TreeNode(value);
        }

        if (value < node.val) {
            node.left = addRecursive(node.left, value);
        } else {
            node.right = addRecursive(node.right, value);
        }

        return node;
    }

    // Nested static inner class for TreeNode
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int item) {
            val = item;
            left = right = null;
        }
    }
}
