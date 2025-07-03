package src.main.java.basic.tree;

import java.util.HashMap;

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class ConstructBinaryTreeFromInorderAndPreOrder {

    public static void main(String[] args) {
        int[] preorder = {10, 20, 40, 50, 30, 60};
        int[] inorder = {40, 20, 50, 10, 60, 30};

        Solution solution = new Solution();
        TreeNode root = solution.buildTree(preorder, inorder);

        System.out.print("Inorder traversal of constructed tree: ");
        printInorder(root); // should match the original inorder input
    }

    public static void printInorder(TreeNode root) {
        if (root == null) return;
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }
}

class Solution {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return solve(0, preorder.length - 1, 0, inorder.length - 1, preorder, inorder, map);
    }

    private TreeNode solve(int preStart, int preEnd, int inStart, int inEnd,
                           int[] preorder, int[] inorder, HashMap<Integer, Integer> map) {
        if (preStart > preEnd || inStart > inEnd) return null;

        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);

        int rootIndexInorder = map.get(rootVal);
        int numsLeft = rootIndexInorder - inStart;

        root.left = solve(preStart + 1, preStart + numsLeft, inStart, rootIndexInorder - 1, preorder, inorder, map);
        root.right = solve(preStart + numsLeft + 1, preEnd, rootIndexInorder + 1, inEnd, preorder, inorder, map);

        return root;
    }
}
