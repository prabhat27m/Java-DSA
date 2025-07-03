package src.main.java.basic.tree;

import java.util.ArrayList;
import java.util.List;

public class PrintRootToNodePath {
    public static boolean getPath(Node root, List<Integer> ans, int node){
        // UNDERSTOOOOD!!!!!!!, this is base case
        if(root == null){
            return false;
        }

        if(root.val == node){
            ans.add(root.val);
            return true;
        }

        ans.add(root.val);

        if(getPath(root.left, ans, node) || getPath(root.right, ans, node)){
            return true;
        }

        ans.remove(ans.size() -1);

//        this is the case when no call get the true so return false;
        return false;
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

        List<Integer> ans = new ArrayList<>();
        if(getPath(root, ans, 9)){
            System.out.println(ans);
        }

    }
}
