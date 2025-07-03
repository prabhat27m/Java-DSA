package src.main.java.basic.graph;

import java.util.*;

public class BFSTraversal {
    public static void main(String[] args) {
        int [][] graph = {{1,1,0}, {0,1,1}, {1,0,1}};

        int n = graph.length;
        int m = graph[0].length;

       Queue<Integer> bfs = new LinkedList<>();
       int []visited = new int[n];

       bfs.offer(0);
       visited[0]= 1;

       while(!bfs.isEmpty()){
           int curr = bfs.poll();
           System.out.println(curr);

           for(int i=0; i< m ;i++){
               if(graph[curr][i] == 1 && visited[i]==0){
                   visited[i]= 1;
                   bfs.offer(i);
               }
           }
       }

    }
}
