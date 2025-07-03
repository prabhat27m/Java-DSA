package src.main.java.basic.tree;

// longest path between 2 nodes;
// similar way you can solve the maximum path sum
public class DiameterOfBinaryTree {
    public static int diameter;

    public int getLongestPathBetweenAnyTwoNodes(Node root){
        if(root == null) return 0;

        int l = getLongestPathBetweenAnyTwoNodes(root.left);
        int r = getLongestPathBetweenAnyTwoNodes(root.right);
        diameter = Math.max(diameter, l + r);

        // return the current maximum length
        return 1 + Math.max(l, r);
    }

    public static void main(String[] args) {
        DiameterOfBinaryTree sol = new DiameterOfBinaryTree();

        // Test Case 1: Your original tree
        //       1
        //      / \
        //     2   3
        //    / \ / \
        //   4  5 6  7
        //  /
        // 8

        diameter = 0; // Reset for each test
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.left = new Node(4);
        root1.left.right = new Node(5);
        root1.right.left = new Node(6);
        root1.right.right = new Node(7);
        root1.left.left.left = new Node(8);

        sol.getLongestPathBetweenAnyTwoNodes(root1);
        System.out.println("Test Case 1 - Diameter: " + diameter);
        System.out.println("Longest path: 8 -> 4 -> 2 -> 1 -> 3 -> 7 (length: 5)\n");

        // Test Case 2: More interesting tree for diameter
        //         1
        //        / \
        //       2   3
        //      / \
        //     4   5
        //    /   / \
        //   6   7   8
        //  /
        // 9

        diameter = 0; // Reset for each test
        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);
        root2.left.left = new Node(4);
        root2.left.right = new Node(5);
        root2.left.left.left = new Node(6);
        root2.left.right.left = new Node(7);
        root2.left.right.right = new Node(8);
        root2.left.left.left.left = new Node(9);

        sol.getLongestPathBetweenAnyTwoNodes(root2);
        System.out.println("Test Case 2 - Diameter: " + diameter);
        System.out.println("Longest path: 9 -> 6 -> 4 -> 2 -> 5 -> 8 (length: 5)\n");

        // Test Case 3: Linear tree (worst case)
        //   1
        //  /
        // 2
        //  \
        //   3
        //  /
        // 4

        diameter = 0; // Reset for each test
        Node root3 = new Node(1);
        root3.left = new Node(2);
        root3.left.right = new Node(3);
        root3.left.right.left = new Node(4);

        sol.getLongestPathBetweenAnyTwoNodes(root3);
        System.out.println("Test Case 3 - Diameter: " + diameter);
        System.out.println("Longest path: 4 -> 3 -> 2 -> 1 (length: 3)");
    }
}