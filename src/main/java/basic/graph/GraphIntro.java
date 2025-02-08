package src.main.java.basic.graph;

import java.util.ArrayList;

public class GraphIntro {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int n = 4;
        // you can directly add the rows like this.
        for(int i=0; i< n; i++){
            graph.add(new ArrayList<Integer>());
        }

        graph.get(1).add(2);
        graph.get(2).add(1);
        graph.get(1).add(3);
        graph.get(3).add(2);
        graph.get(3).add(0);
        graph.get(2).add(3);
        graph.get(0).add(2);

        for (int i = 0; i < graph.size(); i++) {
            System.out.print(i + "-->");
            for (int j = 0; j < graph.get(i).size(); j++) {
                System.out.print(" " + graph.get(i).get(j)+ " ");
            }
            System.out.println();
        }


    }


}
