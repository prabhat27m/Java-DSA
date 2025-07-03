package src.main.java.basic.tree;

import java.util.*;

public class VerticalOrderTraversal {
    public static class Tuple{
        int vertical;
        int level;

    }

    public List<List<Integer>> solve(Node root){
        List<List<Integer>>ans = new ArrayList<>();

        // Need a TreeMap to store the row and the column
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

        // Need a queue for the bfs traversal
        Queue<Tuple> q = new LinkedList<>();

        while(!q.isEmpty()){

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
        root.left.right.right = new Node(9);
    }
}
