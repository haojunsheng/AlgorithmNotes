package com.code.leetcode.list;

/**
 * @author 俊语
 * @date 2020/9/18 18:12
 */
public class OddIncreaseEvenDecrease {
    public static void main(String[] args) {

    }

    /**
     * 奇升偶降链表排序
     *
     * @return
     */
    private ListNode oddIncreaseEvenDecrease(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 把链表拆分为两个
        ListNode odd = head, even = head.next, evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        // 偶数链表反转
        evenHead = reverse(evenHead);
        head = merge(head, evenHead);
        return head;
    }

    /**
     * 反转链表
     *
     * @param head
     * @return
     */
    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode secNode = head.next;
        head.next = null;
        //递归去寻找最后的节点
        ListNode revNode = reverse(secNode);
        secNode.next = head;
        //最后的节点
        return revNode;
    }

    /**
     * 合并两个有序链表
     */
    private ListNode merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }

        ListNode merge = null;
        if (list1.val < list2.val) {
            merge = list1;
            merge.next = merge(list1.next, list2);
        } else {
            merge = list2;
            merge.next = merge(list1, list2.next);
        }
        return merge;
    }

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
