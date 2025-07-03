package src.main.java.basic.tree;


public class BSTFromPreorder {

    public static Node constructBST(int[] preorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }

        return constructBSTHelper(preorder, 0, preorder.length - 1);
    }

    private static Node constructBSTHelper(int[] preorder, int start, int end) {
        // Base case
        if (start > end) {
            return null;
        }

        // First element in preorder is the root
        Node root = new Node(preorder[start]);

        // Find the index where elements greater than root start
        int i;
        for (i = start + 1; i <= end; i++) {
            if (preorder[i] > preorder[start]) {
                break;
            }
        }

        // Recursively construct left and right subtrees
        root.left = constructBSTHelper(preorder, start + 1, i - 1);
        root.right = constructBSTHelper(preorder, i, end);

        return root;
    }

    // Utility method to print inorder traversal for verification
    public static void printInorder(Node root) {
        if (root == null) {
            return;
        }

        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }

    public static void main(String[] args) {
        int[] preorder = {8, 5, 1, 7, 10, 12};
        Node root = constructBST(preorder);

        System.out.println("InOrderTraversal traversal of the constructed BST:");
        printInorder(root);
    }
}
