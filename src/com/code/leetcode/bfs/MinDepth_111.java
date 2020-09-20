package com.code.leetcode.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的最小深度
 * 给定一个二叉树，找出其最小深度。最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 说明: 叶子节点是指没有子节点的节点。
 * 给定二叉树 [3,9,20,null,null,15,7],返回它的最小深度2.
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 */
public class MinDepth_111 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        // root 本身就是一层，depth 初始化为 1
        int depth = 1;

        while (!q.isEmpty()) {
            int sz = q.size();
            /* 将当前队列中的所有节点向四周扩散 */
            for (int i = 0; i < sz; i++) {
                TreeNode cur = q.poll();
                // 找到结果，退出
                if (cur.left == null && cur.right == null) {
                    return depth;
                }
                /* 将 cur 的相邻节点加入队列 */
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
            /* 这里增加步数 */
            depth++;
        }
        return depth;
    }

    /**
     * 深度优先
     *
     * @param root
     * @return
     */
    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int ans = Integer.MAX_VALUE;
        if (root.left != null) {
            ans = Math.min(dfs(root.left), ans);
        }
        if (root.right != null) {
            ans = Math.min(dfs(root.right), ans);
        }
        return ans + 1;
    }
}