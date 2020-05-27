package com.code.leetcode.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的序列化与反序列化
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中
 * 同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 */
public class Serialize_297 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return serializeHelper(root, new StringBuilder("")).toString();
    }

    // 序列化的思想是利用dfs的preorder遍历得到一个完整地序列，遇到null的地方可以直接存储#即可
    public StringBuilder serializeHelper(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#,");
            return sb;
        }
        sb.append(root.val).append(",");
        serializeHelper(root.left, sb);
        serializeHelper(root.right, sb);
        return sb;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strData = data.split(",");
        List<String> list = new LinkedList<>(Arrays.asList(strData));
        return deserializeHelper(list);
    }

    // 反序列化的思想是利用list这个结构，每次都返回list的首元素，作为上一个节点的左节点和右节点，然后依次删除掉list的首元素
    private TreeNode deserializeHelper(List<String> list) {
        if (list.get(0).equals("#")) {
            list.remove(0);
            return null;
        }
        int val = Integer.valueOf(list.get(0));
        TreeNode root = new TreeNode(val);
        list.remove(0);
        root.left = deserializeHelper(list);
        root.right = deserializeHelper(list);
        return root;
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