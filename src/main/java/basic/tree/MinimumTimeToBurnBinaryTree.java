package src.main.java.basic.tree;

import java.util.*;

public class MinimumTimeToBurnBinaryTree {
    public static class Pair {
        int time;
        Node node;

        public Pair(int time, Node node) {
            this.time = time;
            this.node = node;
        }
    }

    public static void buildGraph(Node root, HashMap<Node, Node> graph) {
        if (root == null) return;

        if (root.left != null) {
            graph.put(root.left, root);
            buildGraph(root.left, graph);
        }

        if (root.right != null) {
            graph.put(root.right, root);
            buildGraph(root.right, graph);
        }
    }

    public static int burnTree(Node root, HashMap<Node, Node> graph) {
        if (root == null) return 0;

        int time = 0;
        HashMap<Node, Boolean> visited = new HashMap<>();
        Queue<Pair> q = new LinkedList<>();

        visited.put(root, true); // ✅ Mark start node as visited
        q.offer(new Pair(1, root));

        while (!q.isEmpty()) {
            Pair pair = q.poll();
            int currTime = pair.time;
            Node currNode = pair.node;

            time = Math.max(time, currTime);

            if (currNode.left != null && !visited.containsKey(currNode.left)) {
                visited.put(currNode.left, true);
                q.offer(new Pair(currTime + 1, currNode.left));
            }

            if (currNode.right != null && !visited.containsKey(currNode.right)) {
                visited.put(currNode.right, true);
                q.offer(new Pair(currTime + 1, currNode.right));
            }

            if (graph.containsKey(currNode) && !visited.containsKey(graph.get(currNode))) {
                visited.put(graph.get(currNode), true);
                q.offer(new Pair(currTime + 1, graph.get(currNode)));
            }
        }

        return time;
    }

    public static void main(String[] args) {
        // Construct binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.left.left = new Node(8);
        root.left.right.left = new Node(9);

        // Build parent map
        HashMap<Node, Node> parentMap = new HashMap<>();
        buildGraph(root, parentMap);

        // Choose target node
        Node targetNode = root.left; // Node 2

        // Compute burn time
        int timeToBurn = burnTree(targetNode, parentMap);

        System.out.println("Minimum time to burn the entire binary tree from node " + targetNode.val + ": " + timeToBurn);
    }
}
