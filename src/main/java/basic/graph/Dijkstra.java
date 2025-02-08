package src.main.java.basic.graph;

import java.util.*;

public class Dijkstra {
    public static int[] dijkstra(List<List<int[]>> graph, int start) {
        int n = graph.size();
        int[] distances = new int[n];
        boolean[] visited = new boolean[n];

        // Initialize distances array with infinity except for start node
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[start] = 0;

        // PriorityQueue using int[] where:
        // arr[0] = distance
        // arr[1] = vertex
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0]- b[0]);
        pq.add(new int[]{0, start});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int distance = current[0];
            int vertex = current[1];

            // Skip if we've already processed this vertex
            if (visited[vertex]) continue;
            visited[vertex] = true;

            // Check all adjacent vertices
            for (int[] neighbor : graph.get(vertex)) {
                int nextVertex = neighbor[0];
                int weight = neighbor[1];

                // Relaxation step
                if (!visited[nextVertex] && distances[vertex] != Integer.MAX_VALUE
                        && distances[vertex] + weight < distances[nextVertex]) {
                    distances[nextVertex] = distances[vertex] + weight;
                    pq.add(new int[]{distances[nextVertex], nextVertex});
                }
            }
        }

        return distances;
    }

    // Example usage
    public static void main(String[] args) {
        int n = 5; // Number of vertices
        List<List<int[]>> graph = new ArrayList<>();

        // Initialize adjacency list
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Add edges: int[]{destination, weight}
        graph.get(0).add(new int[]{1, 4});
        graph.get(0).add(new int[]{2, 1});
        graph.get(1).add(new int[]{3, 1});
        graph.get(2).add(new int[]{1, 2});
        graph.get(2).add(new int[]{3, 5});
        graph.get(3).add(new int[]{4, 3});

        int startVertex = 0;
        int[] shortestDistances = dijkstra(graph, startVertex);

        // Print results
        System.out.println("Shortest distances from vertex " + startVertex + ":");
        for (int i = 0; i < n; i++) {
            System.out.println("To vertex " + i + ": " +
                    (shortestDistances[i] == Integer.MAX_VALUE ? "INF" : shortestDistances[i]));
        }
    }
}