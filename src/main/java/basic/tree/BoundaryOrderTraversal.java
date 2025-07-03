package src.main.java.basic.tree;

import java.util.*;

public class BoundaryOrderTraversal {

    public List<Integer> boundaryTraversal(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        if (!isLeaf(root)) result.add(root.val);

        // 1. Left Boundary (excluding leaves)
        addLeftBoundary(root.left, result);

        // 2. Leaf Nodes
        addLeaves(root, result);

        // 3. Right Boundary (excluding leaves, reversed)
        addRightBoundary(root.right, result);

        return result;
    }

    private boolean isLeaf(Node node) {
        return node != null && node.left == null && node.right == null;
    }

    private void addLeftBoundary(Node node, List<Integer> result) {
        while (node != null) {
            if (!isLeaf(node)) result.add(node.val);
            node = (node.left != null) ? node.left : node.right;
        }
    }

    private void addLeaves(Node node, List<Integer> result) {
        if (node == null) return;
        if (isLeaf(node)) {
            result.add(node.val);
            return;
        }
        addLeaves(node.left, result);
        addLeaves(node.right, result);
    }

    private void addRightBoundary(Node node, List<Integer> result) {
        Stack<Integer> stack = new Stack<>();
        while (node != null) {
            if (!isLeaf(node)) stack.push(node.val);
            node = (node.right != null) ? node.right : node.left;
        }
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
    }

    public static void main(String[] args) {
        /*
                 1
               /   \
              2     3
             / \   / \
            4   5 6   7
               / \
              8   9

            Boundary = 1 2 4 8 9 6 7 3
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.right.left = new Node(8);
        root.left.right.right = new Node(9);

        BoundaryOrderTraversal bot = new BoundaryOrderTraversal();
        List<Integer> boundary = bot.boundaryTraversal(root);
        System.out.println("Boundary Order Traversal: " + boundary);
    }
}
