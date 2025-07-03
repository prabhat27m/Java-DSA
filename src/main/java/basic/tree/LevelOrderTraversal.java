package src.main.java.basic.tree;

import src.main.java.basic.tree.Node;

import java.util.Queue;
import java.util.LinkedList;

public class LevelOrderTraversal {
    public void traverse(Node root) {
        if (root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            System.out.print("Level " + level + ": ");

            for (int i = 0; i < levelSize; i++) {
                Node current = queue.poll();
                System.out.print(current.val + " ");

                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
            System.out.println();
            level++;
        }
    }

    public static void main(String[] args) {
        LevelOrderTraversal lot = new LevelOrderTraversal();

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

        System.out.println("Level-order traversal:");
        lot.traverse(root);

        // Expected output:
        // Level 0: 1 
        // Level 1: 2 3 
        // Level 2: 4 5 6 7 
        // Level 3: 8
    }
}