package com.code.leetcode.recursive;

/**
 * 两两交换链表中的节点
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 * 参考：https://leetcode.wang/leetCode-24-Swap-Nodes-in-Pairs.html
 */
public class SwapNodesInPairs_24 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 时间复杂度：O（n），空间复杂度：O（1）。
     * @param head
     * @return
     */
    public ListNode swapPairsCycle(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode point = dummy;
        while (point.next != null && point.next.next != null) {
            ListNode swap1 = point.next;
            ListNode swap2 = point.next.next;
            point.next = swap2;
            swap1.next = swap2.next;
            swap2.next = swap1;
            point = swap1;
        }
        return dummy.next;
    }

    /**
     * 递归来实现
     * @param head
     * @return
     */
    public ListNode swapPairsRecursive(ListNode head) {
        if ((head == null) || (head.next == null)) {
            return head;
        }
        ListNode n = head.next;
        head.next = swapPairsRecursive(head.next.next);
        n.next = head;
        return n;
    }
}
