package com.code.leetcode.recursive;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。
 * 输入: 3
 * 输出:
 * [
 *   [1,null,3,2],
 *   [3,2,null,1],
 *   [3,1,null,null,2],
 *   [2,1,3],
 *   [1,null,2,null,3]
 * ]
 * https://leetcode.com/problems/unique-binary-search-trees-ii/discuss/31494/A-simple-recursive-solution
 *
 * I start by noting that 1..n is the in-order traversal for any BST with nodes 1 to n.
 * So if I pick i-th node as my root, the left subtree will contain elements 1 to (i-1),
 * and the right subtree will contain elements (i+1) to n.
 * I use recursive calls to get back all possible trees for left and right subtrees and combine them in all possible ways with the root.
 */
public class GenerateTrees_95 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 递归
    public List<TreeNode> generateTreesRecursive(int n) {
        if (n == 0) {
            return new LinkedList<TreeNode>();
        }
        return generateTreesHelper(1, n);
    }

    public LinkedList<TreeNode> generateTreesHelper(int start, int end) {
        LinkedList<TreeNode> all = new LinkedList<TreeNode>();
        if (start > end) {
            all.add(null);
            return all;
        }

        // pick up a root
        for (int i = start; i <= end; i++) {
            // all possible left subtrees if i is choosen to be a root
            LinkedList<TreeNode> left = generateTreesHelper(start, i - 1);

            // all possible right subtrees if i is choosen to be a root
            LinkedList<TreeNode> right = generateTreesHelper(i + 1, end);

            // connect left and right trees to the root i
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode current = new TreeNode(i);
                    current.left = l;
                    current.right = r;
                    all.add(current);
                }
            }
        }
        return all;
    }

    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> pre = new ArrayList<TreeNode>();
        if (n == 0) {
            return pre;
        }
        pre.add(null);
        //每次增加一个数字
        for (int i = 1; i <= n; i++) {
            List<TreeNode> cur = new ArrayList<TreeNode>();
            //遍历之前的所有解
            for (TreeNode root : pre) {
                //插入到根节点
                TreeNode insert = new TreeNode(i);
                insert.left = root;
                cur.add(insert);
                //插入到右孩子，右孩子的右孩子...最多找 n 次孩子
                for (int j = 0; j <= n; j++) {
                    TreeNode root_copy = treeCopy(root);
                    //找到要插入右孩子的位置
                    TreeNode right = root_copy;
                    int k = 0;
                    //遍历 j 次找右孩子
                    for (; k < j; k++) {
                        if (right == null) {
                            break;
                        }
                        right = right.right;
                    }
                    //到达 null 提前结束
                    if (right == null) {
                        break;
                    }
                    //保存当前右孩子的位置的子树作为插入节点的左孩子
                    TreeNode rightTree = right.right;
                    insert = new TreeNode(i);
                    //右孩子是插入的节点
                    right.right = insert;
                    //插入节点的左孩子更新为插入位置之前的子树
                    insert.left = rightTree;
                    //加入结果中
                    cur.add(root_copy);
                }
            }
            pre = cur;
        }
        return pre;
    }

    private TreeNode treeCopy(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode newRoot = new TreeNode(root.val);
        newRoot.left = treeCopy(root.left);
        newRoot.right = treeCopy(root.right);
        return newRoot;
    }
}