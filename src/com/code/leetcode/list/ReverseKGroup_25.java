package com.code.leetcode.list;

/**
 * K 个一组翻转链表
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 * 给你这个链表：1->2->3->4->5
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 */
public class ReverseKGroup_25 {
    /**
     * @param head
     * @param k
     * @return
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        // 1. 根据k找反转的区间
        ListNode a = head, b = head;
        for (int i = 0; i < k; ++i) {
            // 不足k个，不需要反转,base case
            if (b == null) {
                return head;
            }
            b = b.next;
        }
        // 反转前k个元素
        ListNode newHead = reverse(a, b);
        // 递归反转后续链表并连接起来
        a.next = reverseKGroup(b, k);
        return newHead;
    }

    /**
     * 反转区间[a,b)之间的元素,只需要把base case的判断条件从a.next==null修改为a.next==b
     */
    private static ListNode reverse(ListNode a, ListNode b) {
        if (a.next == b) {
            return a;
        }
        ListNode last = reverse(a.next, b);
        a.next.next = a;
        a.next = null;
        return last;
    }

    public static void main(String[] args) {
        ListNode head = init();
        head = reverseKGroup(head, 3);
        System.out.println(head);
    }

    private static ListNode init() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        return node1;
    }

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
