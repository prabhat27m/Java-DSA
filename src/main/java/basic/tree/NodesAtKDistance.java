package src.main.java.basic.tree;

import java.util.*;

public class NodesAtKDistance {
    // Build parent relationships
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

    // DFS traversal from target to find nodes at distance k
    public static void dfs(Node node, int k, HashMap<Node, Node> graph, Set<Node> visited, List<Integer> result, int dist) {
        if (node == null || visited.contains(node)) return;

        visited.add(node);

        if (dist == k) {
            result.add(node.val);
            return;
        }

        dfs(node.left, k, graph, visited, result, dist + 1);
        dfs(node.right, k, graph, visited, result, dist + 1);
        dfs(graph.get(node), k, graph, visited, result, dist + 1); // move to parent
    }

    public static void main(String[] args) {
        // Constructing the binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.left.left = new Node(8);
        root.left.right.left = new Node(9);

        // Step 1: Build graph (child -> parent map)
        HashMap<Node, Node> graph = new HashMap<>();
        buildGraph(root, graph);

        // Step 2: Choose target node and distance k
        Node target = root.left; // node with value 2
        int k = 2;

        // Step 3: DFS from target node to find all nodes at distance k
        List<Integer> result = new ArrayList<>();
        Set<Node> visited = new HashSet<>();
        dfs(target, k, graph, visited, result, 0);

        // Step 4: Output result
        System.out.println("Nodes at distance " + k + " from node " + target.val + ": " + result);
    }
}
