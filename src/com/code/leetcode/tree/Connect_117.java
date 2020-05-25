package com.code.leetcode.tree;

/**
 * 填充每个节点的下一个右侧节点指针 II
 * 给定一个二叉树，填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
 */
public class Connect_117 {
    public Node connect(Node root) {
        // 下一层的头结点
        Node head = root;
        // 下一层的前一个节点
        Node prev = null;
        // 当前层的当前节点
        Node cur = null;
        while (head != null) {
            cur = head;
            prev = null;
            head = null;
            while (cur != null) {
                if (cur.left != null) {
                    if (prev != null) {
                        prev.next = cur.left;
                    } else {
                        // 每一层head只会被赋值一次
                        head = cur.left;
                    }
                    prev = cur.left;
                }
                if (cur.right != null) {
                    if (prev != null) {
                        prev.next = cur.right;
                    } else {
                        head = cur.right;
                    }
                    prev = cur.right;
                }
                cur = cur.next;
            }
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