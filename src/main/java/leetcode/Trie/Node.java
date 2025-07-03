package src.main.java.leetcode.Trie;

public class Node {
    Node [] children;
    Boolean isEnd;

    public Node(){
        children = new Node[26];
    }
}
