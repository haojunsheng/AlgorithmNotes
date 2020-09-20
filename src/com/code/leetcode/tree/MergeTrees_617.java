package com.code.leetcode.tree;

import java.util.LinkedList;

/**
 * 合并二叉树
 * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
 * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。
 * 输入:
 * Tree 1                     Tree 2
 * 1                         2
 * / \                       / \
 * 3   2                     1   3
 * /                           \   \
 * 5                             4   7
 * 输出:
 * 合并后的树:
 * 3
 * / \
 * 4   5
 * / \   \
 * 5   4   7
 * https://leetcode-cn.com/problems/merge-two-binary-trees/
 *
 * @author 俊语
 * @date 2020/9/19 23:04
 */
public class MergeTrees_617 {
    public static void main(String[] args) {
        System.out.println();
    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        return dfs(t1, t2);
    }

    private TreeNode dfs(TreeNode r1, TreeNode r2) {
        // 如果 r1和r2中，只要有一个是null，函数就直接返回
        if (r1 == null) {
            return r2;
        }
        if (r2 == null) {
            return r1;
        }
        //让r1的值 等于  r1和r2的值累加，再递归的计算两颗树的左节点、右节点
        r1.val += r2.val;
        r1.left = dfs(r1.left, r2.left);
        r1.right = dfs(r1.right, r2.right);
        return r1;
    }

    public TreeNode mergeTrees2(TreeNode t1, TreeNode t2) {
        //如果 t1和t2中，只要有一个是null，函数就直接返回
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(t1);
        queue.add(t2);
        while (queue.size() > 0) {
            TreeNode r1 = queue.remove();
            TreeNode r2 = queue.remove();
            r1.val += r2.val;
            //如果r1和r2的左子树都不为空，就放到队列中
            //如果r1的左子树为空，就把r2的左子树挂到r1的左子树上
            if (r1.left != null && r2.left != null) {
                queue.add(r1.left);
                queue.add(r2.left);
            } else if (r1.left == null) {
                r1.left = r2.left;
            }
            //对于右子树也是一样的
            if (r1.right != null && r2.right != null) {
                queue.add(r1.right);
                queue.add(r2.right);
            } else if (r1.right == null) {
                r1.right = r2.right;
            }
        }
        return t1;
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
