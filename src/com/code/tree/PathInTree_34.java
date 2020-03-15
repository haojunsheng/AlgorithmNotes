package com.code.tree;

import java.util.ArrayList;

/**
 * 题目描述：
 * 输入一颗二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。
 * 路径定义为从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 * <p>
 * 分析：
 * 对于树的遍历一般就是深度遍历和广度遍历下四种中的一种，
 * 从根节点往下找到叶节点形成一条路径，若是和为给定的值这个路径便是需要找的路径，从根节点到叶节点边访问边相加判断可以采用先序遍历。
 * （1）若根节点的值大于给定的值或者根节点为空，则清空路径；
 * （1）若根节点的值等于给定的值，需要判断当前节点是否为叶子节点，若为叶子节点，则是需要找的一条路径，若不是，将保存的节点全部清空。
 * （2）若根节点的和小于给定的值，则分别去访问其左右子树。
 */
public class PathInTree_34 {
    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    private ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> path = new ArrayList<Integer>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) {
            return lists;
        }
        path.add(root.val);
        target -= root.val;
        // 合法路径
        if (root.left == null && root.right == null && target == 0) {
            lists.add(new ArrayList<Integer>(path));
        }
        if (root.left != null) {
            FindPath(root.left, target);
        }
        if (root.right != null) {
            FindPath(root.right, target);
        }
        //无论当前路径是否加出了target，必须去掉最后一个，然后返回父节点，去查找另一条路径，最终的path肯定为null
        path.remove(path.size() - 1);
        return lists;
    }
}
