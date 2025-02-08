package src.main.java.basic.trie;

class TrieNode {
    private TrieNode[] children;
    private boolean isEndOfWord;

    public TrieNode() {
        children = new TrieNode[26]; // Assuming only lowercase English letters
        isEndOfWord = false;
    }

    public TrieNode[] getChildren() {
        return children;
    }

    public boolean isEndOfWord() {
        return isEndOfWord;
    }

    public void setEndOfWord(boolean end) {
        isEndOfWord = end;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Insert a word into the trie
    public void insert(String word) {
        TrieNode current = root;

        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (current.getChildren()[index] == null) {
                current.getChildren()[index] = new TrieNode();
            }
            current = current.getChildren()[index];
        }
        current.setEndOfWord(true);
    }

    // Search for a word in the trie
    public boolean search(String word) {
        TrieNode node = searchNode(word);
        return node != null && node.isEndOfWord();
    }

    // Check if there is any word in the trie that starts with the given prefix
    public boolean startsWith(String prefix) {
        return searchNode(prefix) != null;
    }

    // Helper method to search for a node
    private TrieNode searchNode(String str) {
        TrieNode current = root;

        for (char ch : str.toCharArray()) {
            int index = ch - 'a';
            if (current.getChildren()[index] == null) {
                return null;
            }
            current = current.getChildren()[index];
        }
        return current;
    }

    // Delete a word from the trie
    public void delete(String word) {
        delete(root, word, 0);
    }

    private boolean delete(TrieNode current, String word, int index) {
        if (index == word.length()) {
            if (!current.isEndOfWord()) {
                return false;
            }
            current.setEndOfWord(false);
            return isEmpty(current);
        }

        int charIndex = word.charAt(index) - 'a';
        TrieNode node = current.getChildren()[charIndex];
        if (node == null) {
            return false;
        }

        boolean shouldDeleteCurrentNode = delete(node, word, index + 1);

        if (shouldDeleteCurrentNode) {
            current.getChildren()[charIndex] = null;
            return isEmpty(current);
        }
        return false;
    }

    private boolean isEmpty(TrieNode node) {
        for (TrieNode child : node.getChildren()) {
            if (child != null) {
                return false;
            }
        }
        return true;
    }
}
