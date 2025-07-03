package src.main.java.basic.tree;

import java.util.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class ZigZagTraversal {
    public List<int[]> zigzag(Node root){
        List<int[]> ans = new ArrayList<>();
        if(root == null) return ans;

        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        boolean dir = true; // true = left to right, false = right to left

        while (!q.isEmpty()){
            int size = q.size();
            int[] res = new int[size];

            for(int i = 0; i < size; i++){
                Node node = q.poll();
                int ind = dir ? i : size - 1 - i;
                res[ind] = node.val;

                if(node.left != null){
                    q.offer(node.left);
                }

                if(node.right != null){
                    q.offer(node.right);
                }
            }

            dir = !dir;
            ans.add(res);
        }

        return ans;
    }

    public static void main(String[] args) {
        // Tree structure:
        //       1
        //      / \
        //     2   3
        //    / \ / \
        //   4  5 6  7
        //  /    \
        // 8      9

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.left.left = new Node(8);
        root.left.right.right = new Node(9);

        ZigZagTraversal zt = new ZigZagTraversal();
        List<int[]> result = zt.zigzag(root);

        for (int[] level : result) {
            for (int val : level) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
