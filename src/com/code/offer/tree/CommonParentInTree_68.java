package com.code.offer.tree;

/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。一个节点也可以是它自己的祖先。
 * <p>
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 * <p>
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

    private TreeNode ans = null;

    /**
     * 此题相当于查找以 root 为根节点的树上是否有p节点或者q节点,
     * 从左右子树分别进行递归，即查找左右子树上是否有p节点或者q节点。
     * 左右子树均无p节点或q节点；
     * 左子树找到，右子树没有找到，返回左子树的查找结果；
     * 右子树找到，左子树没有找到，返回右子树的查找结果；
     * 左、右子树均能找到；
     * 说明此时的p节点和q节点在当前root节点两侧，返回root节点。
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Traverse the tree
//        this.recurseTree(root, p, q);
//        return this.ans;
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

    /**
     * 1. 从根节点开始遍历树。
     * 2. 如果当前节点本身是p或q中的一个，我们会将变量mid标记为true，
     * 并继续搜索左右分支中的另一个节点。
     * 3. 如果左分支或右分支中的任何一个返回true，则表示在下面找到了两个节点中的一个。
     * 4. 如果在遍历的任何点上，左、右或中三个标志中的任意两个变为true，这意味着我们找到了节点p和q的最近公共祖先。
     */
    private boolean recurseTree(TreeNode currentNode, TreeNode p, TreeNode q) {

        // If reached the end of a branch, return false.
        if (currentNode == null) {
            return false;
        }

        // Left Recursion. If left recursion returns true, set left = 1 else 0
        int left = this.recurseTree(currentNode.left, p, q) ? 1 : 0;

        // Right Recursion
        int right = this.recurseTree(currentNode.right, p, q) ? 1 : 0;

        // If the current node is one of p or q
        int mid = (currentNode == p || currentNode == q) ? 1 : 0;


        // If any two of the flags left, right or mid become True
        if (mid + left + right >= 2) {
            this.ans = currentNode;
        }

        // Return true if any one of the three bool values is True.
        return (mid + left + right > 0);
    }
}
