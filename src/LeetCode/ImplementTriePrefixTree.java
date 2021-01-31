package LeetCode;

public class ImplementTriePrefixTree {
    public static void main(String[] args) {
        Trie208 trie = new Trie208();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // returns true
        System.out.println(trie.search("app"));     // returns false
        System.out.println(trie.startsWith("app")); // returns true
        trie.insert("app");
        System.out.println(trie.search("app"));     // returns true
    }
}
//https://leetcode.com/problems/implement-trie-prefix-tree/
class Trie208 {// 28 ms
    static class Node {
        char val;
        Node[] next;
        boolean isLeaf;

        Node() {
            this.next = new Node[26];
        }

        Node(char val) {
            this.val = val;
            this.next = new Node[26];
        }

        Node(char val, boolean isLeaf) {
            this.val = val;
            this.next = new Node[26];
            this.isLeaf = isLeaf;
        }
    }

    /**
     * Initialize your data structure here.
     */
    Node root;

    public Trie208() {
        root = new Node();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        int n = word.length(), i = 0;
        Node curr = root;
        char c = word.charAt(i++);
        while (i < n && curr.next[c - 'a'] != null) {
            curr = curr.next[c - 'a'];
            c = word.charAt(i++);
        }
        while (i < n) {
            curr.next[c - 'a'] = new Node(c);
            curr = curr.next[c - 'a'];
            c = word.charAt(i++);
        }
        /*
        consider this example
        insert -> aaaaa (1)
        insert -> aaa   (2)
        if we only write curr.next[c - 'a'] = new Node(c, true); in below if else code,
        then when if insert (1) it well perfectly inserted but
        when we insert (2) then last two "aa" of (1) will be lost.
        Since we have create new node.
        Instead of updating the node as a LEAF node.
         */
        if (curr.next[c - 'a'] == null)
            curr.next[c - 'a'] = new Node(c, true);
        else
            curr.next[c - 'a'].isLeaf = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        Node curr = root;
        int n = word.length(), i = 0;
        char c = word.charAt(i++);
        while (i < n && curr.next[c - 'a'] != null) {
            curr = curr.next[c - 'a'];
            c = word.charAt(i++);
        }
        curr = curr.next[c - 'a'];
        return curr != null && curr.isLeaf;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String word) {
        Node curr = root;
        int n = word.length(), i = 0;
        char c = word.charAt(i++);
        while (curr.next[c - 'a'] != null) {
            curr = curr.next[c - 'a'];
            if (i < n)
                c = word.charAt(i++);
            else
                return true;
        }
        return false;
    }
}