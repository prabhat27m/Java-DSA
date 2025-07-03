package src.main.java.basic.tree;

public class PostOrderTraversal {
    public void traverse(Node root){
        if(root == null){
            return;
        }

        traverse(root.left);
        traverse(root.right);
        System.out.println(root.val);
    }

    public static void main(String[] args) {
        PostOrderTraversal pot = new PostOrderTraversal();

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
