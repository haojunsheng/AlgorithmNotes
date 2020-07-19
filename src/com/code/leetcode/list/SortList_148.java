package com.code.leetcode.list;

/**
 * 排序链表
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 */
public class SortList_148 {
    /**
     * 归并算法
     *
     * @param head
     * @return
     */
    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 1. 链表分为2半，双指针法
        ListNode slow = head, fast = head, temp = null;
        while (fast != null && fast.next != null) {
            temp=slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        temp.next = null;
        // 2. 递归处理
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        // 3. 把l1和l2进行排序
        return merge(l1, l2);
    }

    private static ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        if (l1 != null) {
            prev.next = l1;
        }
        if (l2 != null) {
            prev.next = l2;
        }
        return dummy.next;
    }

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        ListNode head = init();
        head = sortList(head);
        System.out.println(head);
    }

    private static ListNode init() {
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        return node1;
    }
}
