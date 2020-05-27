package com.code.leetcode.tree;

import java.util.Stack;

/**
 * 二叉搜索树迭代器
 * 实现一个二叉搜索树迭代器。你将使用二叉搜索树的根节点初始化迭代器。
 * 调用 next() 将返回二叉搜索树中的下一个最小的数。
 * https://leetcode.com/problems/binary-search-tree-iterator/
 */
public class BSTIterator_173 {
    private Stack<TreeNode> stack;

    public BSTIterator_173(TreeNode root) {
        stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        TreeNode node = stack.pop();
        TreeNode temp = node.right;
        // 把当前节点的右子树及右子树的所有子节点加入栈中
        while (temp != null) {
            stack.push(temp);
            temp = temp.left;
        }
        return node.val;
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !stack.empty();
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