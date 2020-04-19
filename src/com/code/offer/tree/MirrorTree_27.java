package com.code.offer.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树，将其变换为源二叉树的镜像。
 */
public class MirrorTree_27 {
    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    //递归去实现
    public void Mirror(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        Mirror(root.left);
        Mirror(root.right);
    }

    //非递归去实现,层次遍历
    public void MirrorNotRecursively(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            if (temp.left != null || temp.right != null) {
                swap(temp);
                if (root.left != null) {
                    queue.add(temp.left);
                }
                if (root.right != null) {
                    queue.add(temp.right);
                }
            }
        }
    }

    private void swap(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}