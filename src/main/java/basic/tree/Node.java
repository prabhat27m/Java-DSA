package src.main.java.basic.tree;

public class Node {
    public int val;
    public Node left;
    public Node right;

    public Node(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    @Override
    public String toString() {
        return "The root left is : " + (this.left == null ? "null" : this.left.val) +
                " The root right is: " + (this.right == null ? "null" : this.right.val);
    }

}
