package com.code.leetcode.list;

/**
 * 回文链表
 * 输入: 1->2
 * 输出: false
 * 输入: 1->2->2->1
 * 输出: true
 */
public class PalindromeList_234 {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        // 一块一慢两个指针，为了找到需要翻转的半条链表的起点。
        ListNode slow = head;
        ListNode fast = head;
        // 用于辅助翻转前半条链表,遍历的同时翻转前半个列表
        // 注意：如果要求不可以修改链表，那么我们可以通过栈来实现
        ListNode pre = null;
        while (fast != null && fast.next != null) {
            ListNode cur = slow;
            slow = slow.next;
            fast = fast.next.next;
            cur.next = pre;
            pre = cur;
        }
        if (fast != null) {
            slow = slow.next;
        }
        // 两个半长链表的比较 遍历两个半长链表
        while (pre != null) {
            if (pre.val != slow.val) {
                return false;
            }
            slow = slow.next;
            pre = pre.next;
        }
        return true;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}