package src.main.java.basic.tree;

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
