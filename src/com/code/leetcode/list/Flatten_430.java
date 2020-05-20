package com.code.leetcode.list;

/**
 * 扁平化多级双向链表
 * 多级双向链表中，除了指向下一个节点和前一个节点指针之外，它还有一个子链表指针，可能指向单独的双向链表。
 * 这些子列表也可能会有一个或多个自己的子项，依此类推，生成多级数据结构。
 * 输入：head = [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
 * 输出：[1,2,3,7,8,11,12,9,10,4,5,6]
 * 输入：head = [1,2,null,3]
 * 输出：[1,3,2]
 */
public class Flatten_430 {
    private Node prev = null;

    /**
     * 多级链表结构的扁平化类似二叉树的先序遍历
     * child就相当于left tree，next相当于right tree
     * 需要维护一个prev指针用于访问当前节点的上一个节点
     * prev指针非空时，建立prev与当前节点的双向连接
     * 处理完一个child后记得把它设为null
     */
    public Node flatten(Node head) {
        dfs(head);
        return head;
    }

    private void dfs(Node head) {
        if (head == null) {
            return;
        }
        Node next = head.next;
        if (prev != null) {
            prev.next = head;
            head.prev = prev;
        }
        prev = head;
        dfs(head.child);
        head.child = null;
        dfs(next);
    }

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }
}