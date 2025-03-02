package Curious_Freaks.binarytree;
// Java program to demonstrate
// insert operation in binary
// search tree

public class InsertNode {

    // Root of BST
    Node root;

    // Constructor
    InsertNode() {
        root = null;
    }

    InsertNode(int value) {
        root = new Node(value);
    }

    // Driver Code
    public static void main(String[] args) {
        InsertNode tree = new InsertNode();

		/* Let us create following BST
			50
		/	 \
		30	 70
		/ \ / \
	20 40 60 80 */
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        // Print inorder traversal of the BST
        tree.inorder();
    }

    // This method mainly calls insertRec()
    void insert(int key) {
        root = insertRec(root, key);
    }

    // A recursive function to
    // insert a new key in BST
    Node insertRec(Node root, int key) {
        // If the tree is empty,
        // return a new node
        if (root == null) {
            root = new Node(key);
            return root;
        }

        // Otherwise, recur down the tree
        else if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        // Return the (unchanged) node pointer
        return root;
    }

    // This method mainly calls InorderRec()
    void inorder() {
        inorderRec(root);
    }

    // A utility function to
    // do inorder traversal of BST
    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    // Class containing left
    // and right child of current node
    // and key value
    class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }
}

// This code is contributed by Ankur Narain Verma
