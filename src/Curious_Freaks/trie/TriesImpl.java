package Curious_Freaks.trie;

public class TriesImpl {
    private final Node root;

    public TriesImpl() {
        root = new Node();
    }

    public static void main(String[] args) {
        TriesImpl trie = new TriesImpl();
        trie.insert("apple");
        System.out.println(trie.serach("apple"));
        System.out.println(trie.serach("app"));
        System.out.println(trie.startsWith("app"));
    }

    public void insert(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (!node.containsKey(word.charAt(i))) {
                node.put(word.charAt(i), new Node());
            }
            node = node.get(word.charAt(i));
        }
        node.setEnd();
    }

    public boolean serach(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (!node.containsKey(word.charAt(i))) {
                return false;
            }
            node = node.get(word.charAt(i));
        }
        return node.isEnd();

    }

    public boolean startsWith(String prefix) {
        Node node = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (!node.containsKey(prefix.charAt(i))) {
                return false;
            }
            node = node.get(prefix.charAt(i));
        }
        return true;
    }

    static class Node {
        Node[] links = new Node[26];
        boolean flag = false;

        public boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }

        public Node get(char ch) {
            return links[ch - 'a'];
        }

        public void put(char ch, Node node) {
            links[ch - 'a'] = node;
        }

        public void setEnd() {
            flag = true;
        }

        public boolean isEnd() {
            return flag;
        }

    }


}