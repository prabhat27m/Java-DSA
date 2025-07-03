package src.main.java.basic.tree;

public class LowestCommonAncestor {
    public static Node lca(Node root, int node1, int node2){
        if(root == null || root.val == node1 || root.val == node2){
            return root;
        }

        Node left = lca(root.left, node1, node2);
        Node right = lca(root.right, node1, node2);

        if(left == null){
            return right;
        }
        else if(right == null){
            return left;
        }

        return root;

    }


    public static void main(String[] args) {
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
        root.left.right.left = new Node(9);

        System.out.println(lca(root, 4,9).val);
    }
}
