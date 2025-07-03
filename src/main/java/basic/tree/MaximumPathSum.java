package src.main.java.basic.tree;


public class MaximumPathSum {
    public static int maxSum = Integer.MIN_VALUE;

    public int getMaxPathSum(Node root) {
        if (root == null) return 0;

        // This is to avoid the negative paths
        int left = Math.max(0, getMaxPathSum(root.left));
        int right = Math.max(0, getMaxPathSum(root.right));

        // update global max if this path is higher
        maxSum = Math.max(maxSum, left + right + root.val);

        // return max single branch path
        return root.val + Math.max(left, right);
    }

    public static void main(String[] args) {
        MaximumPathSum sol = new MaximumPathSum();

        /*
              1
             / \
            2   3
               /
              4
             / \
            5   6
               / \
              7   8

            Values:
            1, 2, 3, 4, 5 = small
            6 = 50, 7 = 40, 8 = 30
            Max path = 7 → 6 → 8 = 120 (does not pass through root)
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(4);
        root.right.left.left = new Node(5);
        root.right.left.right = new Node(6);
        root.right.left.right.left = new Node(7);
        root.right.left.right.right = new Node(8);

        // Assign high values to right subtree
        root.val = 1;
        root.left.val = 2;
        root.right.val = 3;
        root.right.left.val = 4;
        root.right.left.left.val = 5;
        root.right.left.right.val = 50;
        root.right.left.right.left.val = 40;
        root.right.left.right.right.val = 30;

        sol.getMaxPathSum(root);
        System.out.println("Maximum Path Sum: " + maxSum); // should print 120
    }
}
