package src.main.java.basic.tree;

class Node{
    public int val;
    public Node left;
    public Node right;

    public Node(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }

    @Override
    public String toString(){
        return "The root left is : " + (this.left == null ? "null" : this.left.val) +
                " The root right is: " + (this.right == null ? "null" : this.right.val);
    }

}
public class BinaryTree {

    public static void main(String[] args) {
        // Create a root;

        Node root = new Node(1);

        // Create a left node
        Node firstLeftNode = new Node(2);

        // Create a right node
        Node firstRightNode = new Node(3);

        // Assign the left and right to the root

        root.left = firstLeftNode;

        root.right = firstRightNode;

        System.out.println(root.toString());
    }

}
