package com.code.offer.tree;

import java.util.Stack;

/**
 * 将二叉搜索树转换成排序的双向链表
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。
 * 要求不能创建任何新的节点，只能调整树中节点指针的指向。
 */
public class BinaryTreeConvert_36 {
    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 我们需要记录上一个节点，因为需要给右节点赋值
     * 还需要记录最终的根节点，这个节点一旦找到就不变了
     */
    TreeNode pre = null;
    TreeNode lastLeft = null;
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        dfs(pRootOfTree);
        return lastLeft;
    }

    // 中序遍历
    public void dfs(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return;
        }
        dfs(pRootOfTree.left);
        // 当pre为空时： 代表正在访问链表头节点，记为 lastLeft。
        if (pre == null) {
            lastLeft = pRootOfTree;
            // 当 pre 不为空时： 修改双向节点引用，即pre.right=pRootOfTree ，pRootOfTree.left=pre
        } else {
            pre.right = pRootOfTree;
            pRootOfTree.left = pre;
        }
        // 更新pre
        pre = pRootOfTree;
        dfs(pRootOfTree.right);
    }

    //非递归，不是尾递归，无法直接转循环，需要借助于栈来帮助我们
    public TreeNode Convert1(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode root = null;
        while (pRootOfTree != null || (!stack.isEmpty())) {
            if (pRootOfTree != null) {
                stack.push(pRootOfTree);
                pRootOfTree = pRootOfTree.right;
            } else {
                pRootOfTree = stack.pop();
                if (root == null) {
                    root = pRootOfTree;
                } else {
                    root.left = pRootOfTree;
                    pRootOfTree.left = root;
                    root = pRootOfTree;
                }
                pRootOfTree = pRootOfTree.left;
            }
        }
        return root;
    }
}