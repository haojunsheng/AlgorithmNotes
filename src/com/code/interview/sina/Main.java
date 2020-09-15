package com.code.interview.sina;

import java.util.Scanner;

/**
 * @author 俊语
 * @date 2020/9/13 16:50
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strs = scanner.nextLine().split(",");
        TreeNode root = new TreeNode(Integer.parseInt(strs[0]));
        TreeNode curRoot = root;
        for (int i = 1; i < strs.length; ) {
            TreeNode temp1 = new TreeNode(Integer.parseInt(strs[i]));
            TreeNode temp2 = new TreeNode(Integer.parseInt(strs[i + 1]));
            curRoot.left = temp1;
            curRoot.right = temp2;
            curRoot = temp1;
        }
        dfs(root);
    }

    private static TreeNode dfs(TreeNode root) {
        if (root == null || root.left == null || root.right == null) {
            return root;
        }
        TreeNode left = dfs(root.left);
        TreeNode temp = left;
        while (temp.right != null) {
            temp = temp.right;
        }
        temp.left = root.right;
        temp.right = root;
        root.left = root.right = null;
        return left;
    }

    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        TreeNode(int val) {
            this.val = val;
        }
    }
}
