package src.main.java.basic.tree;

import java.util.*;

public class BottomViewOfBinaryTree {
    public List<Integer> bottomView(Node root) {
        List<Integer> ans = new ArrayList<>();

        if (root == null) return ans;

        // Map to store the first node at each horizontal distance (line)
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(0, root));  // Start from line 0

        while (!q.isEmpty()) {
            Pair pair = q.poll();
            int currLine = pair.line;
            Node currNode = pair.node;

            // update
            map.put(currLine, currNode.val);

            if (currNode.left != null) {
                q.offer(new Pair(currLine - 1, currNode.left));
            }

            if (currNode.right != null) {
                q.offer(new Pair(currLine + 1, currNode.right));
            }
        }

        // Add nodes in the order of horizontal distance (left to right)
        for (int val : map.values()) {
            ans.add(val);
        }

        return ans;
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

        BottomViewOfBinaryTree solution = new BottomViewOfBinaryTree();
        List<Integer> result = solution.bottomView(root);
        System.out.println("Top view: " + result); // Expected: [8, 4, 2, 1, 3, 7]
    }
}
