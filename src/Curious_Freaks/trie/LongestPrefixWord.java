package Curious_Freaks.trie;

public class LongestPrefixWord {
}

class Solution {

    Trie root;
    int max;
    int size;

    public void insert(String key) {
        int height = key.length();
        Trie t = root;
        int len = 0;
        for (int i = 0; i < height; i++) {
            int ind = key.charAt(i) - 'a';
            if (t.children[ind] == null) {
                t.children[ind] = (Curious_Freaks.trie.Trie) new Trie();
            }
            len++;
            t = t.children[ind];
            t.count += 1;
            if (t.count == size)
                max = Math.max(max, len);
        }
    }

    public String longestCommonPrefix(String[] strs) {
        root = new Trie();
        max = 0;
        size = strs.length;
        for (String s : strs) insert(s);
        return max > 0 ? strs[0].substring(0, max) : "";
    }

    static class Trie {
        Curious_Freaks.trie.Trie[] children;
        boolean isEnd;
        int count;

        public Trie() {
            children = new Curious_Freaks.trie.Trie[26];
        }
    }
}