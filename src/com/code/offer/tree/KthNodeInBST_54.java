package com.code.offer.tree;

/**
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 * 输入: root = [3,1,4,null,2], k = 1,输出: 4
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3,输出: 4
 */
public class KthNodeInBST_54 {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    int k = 0;
    TreeNode res = null;

    /**
     * 二叉搜索树的中序遍历为递增序列,所以先处理右子树
     */
    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null || k <= 0) {
            return null;
        }
        this.k = k;
        dfs(pRoot);
        return res;
    }

    void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.right);
        // 及时剪枝
        if (k == 0) {
            return;
        }
        if (--k == 0) {
            res = root;
            return;
        }
        dfs(root.left);
    }

    public static void main(String[] args) {
        TreeNode temp2 = new TreeNode(2);
        TreeNode temp3 = new TreeNode(3);
        TreeNode temp4 = new TreeNode(4);
        TreeNode temp5 = new TreeNode(5);
        TreeNode temp6 = new TreeNode(6);
        TreeNode temp7 = new TreeNode(7);
        TreeNode temp8 = new TreeNode(8);

        temp5.left = temp3;
        temp5.right = temp7;
        temp3.left = temp2;
        temp3.right = temp4;
        temp7.left = temp6;
        temp7.right = temp8;
        KthNodeInBST_54 node = new KthNodeInBST_54();
        node.KthNode(temp5, 3);
    }
}
