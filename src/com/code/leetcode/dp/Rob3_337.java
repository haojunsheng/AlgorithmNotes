package com.code.leetcode.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * 打家劫舍 III
 * 第三题又想法设法地变花样了，此强盗发现现在面对的房子不是一排，不是 一圈，而是一棵二叉树!房子在二叉树的节点上，相连的两个房子不能同时被抢劫。
 * 输入: [3,2,3,null,3,null,1]
 * 3
 * / \
 * 2   3
 * \   \
 * 3   1
 * 输出: 7
 * 解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
 *
 * @author 俊语
 * @date 2020/9/15 12:38
 */
public class Rob3_337 {
    public static void main(String[] args) {
        System.out.println();
    }

    Map<TreeNode, Integer> memo = new HashMap<>();

    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (memo.containsKey(root)) {
            return memo.get(root);
        }
        //不抢，去下家，两个儿子去偷
        int notRob = rob(root.left) + rob(root.right);
        // 抢，去下下家，自己偷，4个孙子也偷
        int doRob = root.val
                + (root.left == null ? 0 : rob(root.left.left) + rob(root.left.right))
                + (root.right == null ? 0 : rob(root.right.left) + rob(root.right.right));
        int res = Math.max(notRob, doRob);
        memo.put(root, res);
        return res;
    }

    /**
     *
     * @param root
     * @return
     */
    public int rob2(TreeNode root) {
        int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    }

    private int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }

        // 分类讨论的标准是：当前结点偷或者不偷
        // 由于需要后序遍历，所以先计算左右子结点，然后计算当前结点的状态值
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);

        // dp[0]：以当前 node 为根结点的子树能够偷取的最大价值，规定 node 结点不偷
        // dp[1]：以当前 node 为根结点的子树能够偷取的最大价值，规定 node 结点偷
        int[] dp = new int[2];

        dp[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        dp[1] = node.val + left[0] + right[0];
        return dp;
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
