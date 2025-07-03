package src.main.java.leetcode.Trie;

class Trie {
    Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
       Node current = root;
       for(Character c : word.toCharArray()){
           if(current.children[c - 'a'] == null){
               current.children[c - 'a'] = new Node();
           }

           current = current.children[c - 'a'];
       }

       current.isEnd = true;
    }

    public boolean search(String word) {
        Node current = root;
        for(Character c : word.toCharArray()){
            if(current.children[c - 'a'] == null){
                return false;
            }

            current = current.children[c - 'a'];
        }

        return current.isEnd != null && current.isEnd;
    }
}

public class ImplementTrie{
        public static void main(String[] args) {
            Trie trie = new Trie();

            trie.insert("apple");
            trie.insert("app");

            System.out.println(trie.search("apple")); // true
            System.out.println(trie.search("app"));   // true
            System.out.println(trie.search("appl"));  // false
            System.out.println(trie.search("banana"));// false
        }


}