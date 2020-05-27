package com.code.leetcode.tree;

/**
 * 给定二叉搜索树（BST）的根节点和要插入树中的值，将值插入二叉搜索树。
 * 返回插入后二叉搜索树的根节点。 保证原始二叉搜索树中不存在新值。
 * https://leetcode.com/problems/insert-into-a-binary-search-tree
 */
public class InsertIntoBST_701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        helper(root, val);
        return root;
    }

    private void helper(TreeNode root, int val) {
        if (root.val < val && root.right == null) {
            root.right = new TreeNode(val);
        } else if (root.val > val && root.left == null) {
            root.left = new TreeNode(val);
        } else if (root.val > val) {
            helper(root.left, val);
        } else {
            helper(root.right, val);
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}