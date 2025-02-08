package src.main.java.basic.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Graph{
    int V;
    ArrayList<ArrayList<Integer>> graph;

    public Graph(int v){
        this.V = v;
        this.graph = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            graph.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v){
        graph.get(u).add(v);

    }

    public void printGraph(){
        for (ArrayList<Integer> rows : graph){
            for(Integer row : rows){
                System.out.print(row + " ");
            }
            System.out.println();
        }
    }
}

public class TopologicalSort {
    public static List<Integer> TopoSort(ArrayList<ArrayList<Integer>> graph, int V){
        List<Integer> topo = new ArrayList<>();
        int [] indegree = new int[V];

        Queue<Integer> queue = new LinkedList<>();

        for(int i=0; i< V; i++){
            for(int it : graph.get(i)){
                indegree[it]++;
            }
        }

        for (int i = 0; i < V; i++) {
            System.out.println(i +" indegree :" + indegree[i]);
        }

        for (int i = 0; i < V; i++) {
            if(indegree[i]==0){
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()){
            int curr = queue.poll();

            System.out.println(curr);

            for(int node : graph.get(curr)){
                indegree[node]--;
                if(indegree[node] ==0){
                    queue.offer(node);
                }
            }
        }

        return topo;
    }
    public static void main(String[] args) {
        int n =6;

        Graph graph = new Graph(n);

        graph.addEdge(1,2);
        graph.addEdge(1,3);
        graph.addEdge(1,4);
        graph.addEdge(1,5);
        graph.addEdge(2,3);
        graph.addEdge(2,4);
        graph.addEdge(3,5);
        graph.addEdge(3,4);
        graph.addEdge(4,5);

        graph.printGraph();

        for (int i = 0; i < graph.V; i++) {
            for (int it : graph.graph.get(i)) {
                System.out.print(it+ " ");
            }
            System.out.println();
        }

        TopoSort(graph.graph, graph.V);


    }
}
