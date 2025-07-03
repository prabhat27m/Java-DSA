package src.main.java.basic.tree;

import java.util.LinkedList;
import java.util.Queue;

// Maximum width means the number of maximum nodes in a level.
public class MaximumWidthOfBinaryTree {
    public static int maxWidth(Node root){
        if(root == null) return 0;
        int ans =0;

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0, root));

        while (!q.isEmpty()){
            int size = q.size();
            int mmin = q.peek().line;

            int first =0, last=0;

            for (int i = 0; i < size; i++) {
                Pair curr = q.poll();
                int curr_id = curr.line - mmin;

                if(i==0) first = curr_id;
                if(i== size -1) last = curr_id;

                if(root.left != null){
                    q.offer(new Pair(curr_id*2 +1, root.left));
                }

                if(root.right != null){
                    q.offer(new Pair(curr_id*2 +2, root.right));
                }

            }

            ans = Math.max(ans, last - first +1);
        }
        return  ans;
    }

    public static void main(String[] args){
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
    }
}
