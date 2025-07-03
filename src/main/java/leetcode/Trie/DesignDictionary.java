package src.main.java.leetcode.Trie;

public class DesignDictionary {
    public Node root;
    public DesignDictionary(){
        root = new Node();
    }

    public void insert(String word) {
        Node current = root;
        for (Character c : word.toCharArray()) {
            int index = c - 'a';
            if (current.children[index] == null) {
                current.children[index] = new Node();
            }

            current = current.children[index];
        }
    }

    private boolean match(char [] word, Node node,  int index){
        if (node == null){
            return false;
        }

        if(word.length == index) return node.isEnd;

        char c = word[index];

        if(c == '.'){
            for (int i = 0; i < 26; i++) {
                if(node.children[i] != null && match(word, node.children[i], index + 1)){
                    return true;
                }
            }
        }else{
            return (node.children[c - 'a']!= null  && match(word, node.children[c - 'a'], index + 1));
        }

        return false;
    }

    public boolean search(String word){
        return match(word.toCharArray(), root, 0);
    }
}
