package com.code.offer.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 请实现两个函数，分别用来
 * 。
 * <p>
 * 根据前序遍历规则完成序列化与反序列化。
 * 所谓序列化指的是遍历二叉树为字符串；所谓反序列化指的是依据字符串重新构造成二叉树。
 * 依据前序遍历序列来序列化二叉树，因为前序遍历序列是从根结点开始的。
 * 当在遍历二叉树时碰到Null指针时，这些Null指针被序列化为一个特殊的字符“#”。
 * 另外，结点之间的数值用逗号隔开。
 */
public class BinaryTreeSerialize_37 {
    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    private String Serialize(TreeNode root) {
        return serializeHelper(root, new StringBuilder("")).toString();
    }

    private StringBuilder serializeHelper(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return sb.append("#,");
        }
        sb.append(root.val).append(",");
        serializeHelper(root.left, sb);
        serializeHelper(root.right, sb);
        return sb;
    }

    private TreeNode Deserialize(String str) {
        String[] strData = str.split(",");
        List<String> list = new LinkedList<>(Arrays.asList(strData));
        return deserializeHelper(list);
    }

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
}