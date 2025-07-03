package src.main.java.basic.tree;

import java.util.ArrayList;
import java.util.List;

public class RightOrLeftView {
    public static void rightView(Node root, List<Integer> ans, int currDepth){
        if(root == null){
            return;
        }

        if(currDepth == ans.size()){
            ans.add(root.val);
        }

        rightView(root.left, ans, currDepth + 1);
        rightView(root.right, ans, currDepth + 1);

    }

    public static void main(String[] args) {

        List<Integer> ans = new ArrayList<>();

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
        root.left.left.right = new Node(9);

        rightView(root, ans, 0);
        System.out.println(ans);
    }
}
