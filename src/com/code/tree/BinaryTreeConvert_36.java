package com.code.tree;

import java.util.Stack;

/**
 * 将二叉搜索树转换成排序的双向链表
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

    // 中序遍历
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        Convert(pRootOfTree.left);
        pRootOfTree.left = pre;
        if (pre != null) {
            pre.right = pRootOfTree;
        }
        pre = pRootOfTree;
        //头结点，中序遍历最先访问到的是最左边的节点
        lastLeft = (lastLeft == null ? pRootOfTree : lastLeft);
        Convert(pRootOfTree.right);
        return lastLeft;
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
