package com.code.leetcode.tree;

/**
 * 填充每个节点的下一个右侧节点指针
 * 给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * 初始状态下，所有 next 指针都被设置为 NULL。
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 */
public class Connect_116 {
    public Node connect(Node root) {
        //每行的第一个元素
        Node levelStart = root;
        while (levelStart != null) {
            Node cur = levelStart;
            while (cur != null) {
                if (cur.left != null) {
                    cur.left.next = cur.right;
                }
                if (cur.right != null && cur.next != null) {
                    cur.right.next = cur.next.left;
                }
                cur = cur.next;
            }
            levelStart = levelStart.left;
        }
        return root;
    }

    public class Node {
        int val;
        Node left;
        Node right;
        Node next;
        Node(int x) {
            val = x;
        }
    }
}