package com.code.offer.tree;

/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。一个节点也可以是它自己的祖先。
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 */
public class CommonParentInTree_68 {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 此题相当于查找以root为根节点的树上是否有p节点或者q节点,
     * 从左右子树分别进行递归，即查找左右子树上是否有p节点或者q节点。
     * 左右子树均无p节点或q节点；-》返回null
     * 左子树找到，右子树没有找到，返回左子树的查找结果；-》left
     * 右子树找到，左子树没有找到，返回右子树的查找结果；-》right
     * 左、右子树均能找到；-》说明此时的p节点和q节点在当前root节点两侧，返回root节点。
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }
}