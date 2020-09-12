package com.code.leetcode.tree;

/**
 * 完全二叉树的最后一个节点
 *
 * @author 俊语
 * @date 2020/7/25 11:12
 */
public class CompleteBSTLastNode {
    /**
     * 二分查找
     *
     * @param root
     * @return
     */
    public TreeNode getLastNode(TreeNode root) {
        // 叶子节点
        if (root != null && root.left == null) {
            return root;
        }
        // 1. 左右子树的高度
        int leftHeight = 0;
        TreeNode left = root.left;
        while (left != null) {
            leftHeight++;
            left = left.left;
        }
        int rightHeight = 0;
        TreeNode right = root.right;
        while (right != null) {
            rightHeight++;
            right = right.left;
        }
        // 2. 左子树大于右子树，则去左子树去找;否则去右子树
        if (leftHeight > rightHeight) {
            return getLastNode(root.left);
        } else {
            return getLastNode(root.right);
        }
    }

    public static void main(String[] args) {

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
