package src.main.java.basic.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterativePostOrderTraversal {
    public List<Integer> traverse(Node root){
        List<Integer> postorder = new ArrayList<>();
        Stack<Node> st = new Stack<>();

        if(root == null){
            return postorder;
        }

        while(!st.isEmpty() || root != null){
            while(root!= null){
                st.push(root);
                root = root.left;
            }

            // move right
            Node temp = root.right;

            if(temp == null){
                temp = st.peek();
                st.pop();

                postorder.add(temp.val);

                while (!st.isEmpty() && temp == st.peek().right){
                    temp = st.peek();
                    st.pop();
                    postorder.add(temp.val);
                }
            }
            else{
                root = temp;
            }


        }


        return postorder;


    }

    public static void main(String[] args) {
        IterativePostOrderTraversal pot = new IterativePostOrderTraversal();

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

        System.out.println("Post-order traversal:");
        pot.traverse(root);
    }
}
