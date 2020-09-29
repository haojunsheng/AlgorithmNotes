package com.code.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的完全性检验,判断一棵树是完全树
 * 输入：[1,2,3,4,5,null,7]
 * 输出：false
 * https://leetcode-cn.com/problems/check-completeness-of-a-binary-tree/
 * <p>
 * tag:tree/bfs/
 *
 * @author 俊语
 * @date 2020/9/23 23:53
 */
public class IsCompleteTree_958 {
    public static void main(String[] args) {
        IsCompleteTree_958 isCompleteTree958=new IsCompleteTree_958();
        TreeNode root = isCompleteTree958.stringToTreeNode("[1,2,3,4,5,6]");
        boolean ret = new IsCompleteTree_958().isCompleteTree(root);
        System.out.println(ret);
    }

    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode prev = root;
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            if (prev == null && node != null) {
                return false;
            }
            if (node != null) {
                queue.add(node.left);
                queue.add(node.right);
            }
            prev = node;
        }
        return true;
    }

    public TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }

    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
