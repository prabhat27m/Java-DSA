package src.main.java.basic.graph;


public class DFSTraversal {
    public void dfs(int[][]graph, int node, int []visited){
        visited[node] = 1;
        System.out.println("Visiting node: " + node);
        for (int i = 0; i < graph[0].length; i++) {
            if(visited[i]==0 && graph[node][i] ==1){
                dfs(graph, i, visited);
            }
        }
    }

    public static void main(String[] args) {
        int [][] graph = {{1,0,1,1}, {0,1,0,0}, {1,0,1,0}, {0,1,0,1}};
        DFSTraversal dfsTraversal = new DFSTraversal();
        int n = graph.length;
        int[]visited = new int[n];
        dfsTraversal.dfs(graph, 0, visited );
    }
}
