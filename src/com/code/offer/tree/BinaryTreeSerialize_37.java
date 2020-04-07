package com.code.offer.tree;

/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树。
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

    //计数变量
    int index = -1;

    private String Serialize(TreeNode root) {
        StringBuilder buffer = new StringBuilder();
        if (root == null) {
            return buffer.append("#,").toString();
        }
        buffer.append(root.val + ",");
        buffer.append(Serialize(root.left));
        buffer.append(Serialize(root.right));
        return buffer.toString();
    }

    private TreeNode Deserialize(String str) {
        index++;
        String[] strr = str.split(",");
        TreeNode node = null;
        if (!strr[index].equals("#")) {
            node = new TreeNode(Integer.valueOf(strr[index]));
            node.left = Deserialize(str);
            node.right = Deserialize(str);
        }
        return node;
    }
}
