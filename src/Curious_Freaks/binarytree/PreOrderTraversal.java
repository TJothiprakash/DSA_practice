package Curious_Freaks.binarytree;

import java.util.ArrayList;

public class PreOrderTraversal {
    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        ArrayList<Integer> ans = Preorder(root);
        System.out.println(ans);

    }

    static ArrayList<Integer> Preorder(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        return find(ans, root);
    }

    static ArrayList<Integer> Inorder(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        return findin(ans, root);
    }

    private static ArrayList<Integer> findin(ArrayList<Integer> ans, Node root) {
        if (root == null) {
            return ans;
        }
        findin(ans, root.left);
        ans.add(root.data);
        findin(ans, root.right);
        return ans;
    }

    static ArrayList<Integer> Postorder(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        return findpost(ans, root);
    }

    private static ArrayList<Integer> findpost(ArrayList<Integer> ans, Node root) {
        if (root == null) {
            return ans;
        }
        findpost(ans, root.left);
        findpost(ans, root.right);
        ans.add(root.data);
        return ans;
    }

    private static ArrayList<Integer> find(ArrayList<Integer> ans, Node root) {
        if (root == null) {
            return ans;
        }
        ans.add(root.data);
        find(ans, root.left);
        find(ans, root.right);
        return ans;
    }

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }


}
