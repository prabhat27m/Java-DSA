package src.main.java.basic.tree;

public class IterativePreOrderTraversal {
    public void traverse(Node root){
        
    }

    public static void main(String[] args) {
        IterativePreOrderTraversal pot = new IterativePreOrderTraversal();

        // Creating an 8-node binary tree
        //       1
        //      / \
        //     2   3
        //    / \ / \
        //   4  5 6  7
        //  /
        // 8

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.left.left = new Node(8);

        System.out.println("Post-order traversal:");
        pot.traverse(root);
    }
}
