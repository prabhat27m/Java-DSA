package src.main.java.leetcode.Trie;


class TrieOperations {
    // Node class representing each character node in the Trie
    private static class TrieNode {
        TrieNode[] children;
        boolean isEndOfWord;

        TrieNode() {
            children = new TrieNode[26]; // For 26 lowercase English letters
            isEndOfWord = false;
        }
    }

    private final TrieNode root;

    // Constructor to initialize the Trie
    public TrieOperations() {
        root = new TrieNode();
    }

    // Inserts a word into the Trie
    public void insert(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a'; // Calculate index for the character
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.isEndOfWord = true;
    }

    // Searches for a word in the Trie
    public boolean search(String word) {
        TrieNode node = searchNode(word);
        return node != null && node.isEndOfWord;
    }

    // Checks if there is any word in the Trie that starts with the given prefix
    public boolean startsWith(String prefix) {
        return searchNode(prefix) != null;
    }

    // Helper method to search for a node corresponding to a given prefix or word
    private TrieNode searchNode(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (current.children[index] == null) {
                return null;
            }
            current = current.children[index];
        }
        return current;
    }

    // Main method for demonstration
    public static void main(String[] args) {
        TrieOperations trie = new TrieOperations();

        trie.insert("apple");
        System.out.println(trie.search("apple"));   // Output: true
        System.out.println(trie.search("app"));     // Output: false
        System.out.println(trie.startsWith("app")); // Output: true

        trie.insert("app");
        System.out.println(trie.search("app"));     // Output: true
    }
}
