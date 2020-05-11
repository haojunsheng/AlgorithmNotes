package com.code.offer.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目描述：
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。
 * 注意，如果一个二叉树和它的镜像是一样的，那么它是对称的。
 * <p>
 * 分析：
 * 对于一棵二叉树，从根结点开始遍历，
 * 如果左右子结点有一个为NULL，那么肯定不是对称二叉树；
 * 如果左右子结点均不为空，但不相等，那么肯定不是对称二叉树；
 * 如果左右子结点均不为空且相等，那么
 * 遍历左子树，遍历顺序为：当前结点，左子树，右子树；
 * 遍历右子树，遍历顺序为：当前结点，右子树，左子树；
 * 如果遍历左子树的序列和遍历右子树的序列一样，那么该二叉树为对称的二叉树。（递归实现）
 */
public class SymmetricalBinaryTree_28 {
    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean isSymmetrical(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        return isSymmetrical(root, root);
    }

    public boolean isSymmetrical(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return isSymmetrical(root1.left, root2.right) && isSymmetrical(root1.right, root2.left);
    }

    /**
     * 时间复杂度：O(n)，因为我们遍历整个输入树一次，所以总的运行时间为 O(n)，其中 n是树中结点的总数。
     * 空间复杂度：搜索队列需要额外的空间。在最糟糕情况下，我们不得不向队列中插入O(n)个结点。因此，空间复杂度为O(n)。
     */
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            if (t1 == null && t2 == null) {
                continue;
            }
            if (t1 == null || t2 == null) {
                return false;
            }
            if (t1.val != t2.val) {
                return false;
            }
            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }
        return true;
    }
}