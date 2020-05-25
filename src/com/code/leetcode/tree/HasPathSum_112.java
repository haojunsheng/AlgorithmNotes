package com.code.leetcode.tree;

/**
 * 路径总和
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 * https://leetcode.com/problems/path-sum
 */
public class HasPathSum_112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        // 遍历完未找到符合要求的节点
        if (root == null) {
            return false;
        }
        // 叶节点是否符合要求
        if (root.left == null && root.right == null) {
            return sum - root.val == 0;
        }
        // 左右子树中找到一个即可
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
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