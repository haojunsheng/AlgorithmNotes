package com.code.leetcode.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的所有路径
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * <p>
 * 输入:
 * <p>
 * 1
 * /   \
 * 2     3
 * \
 * 5
 * <p>
 * 输出: ["1->2->5", "1->3"]
 * <p>
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 * <p>
 * https://leetcode-cn.com/problems/binary-tree-paths
 *
 * @author 俊语
 * @date 2020/7/22 23:48
 */
public class BinaryTreePaths_257 {
    private List<String> res;

    public List<String> binaryTreePaths(TreeNode root) {
        res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        dfs(root, "");
        return res;
    }

    private void dfs(TreeNode root, String path) {
        if (root == null) {
            return;
        }
        path += String.valueOf(root.val);
        if (root.left == null && root.right == null) {
            res.add(path);
            return;
        }
        path += "->";
        dfs(root.left, path);
        dfs(root.right, path);
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
