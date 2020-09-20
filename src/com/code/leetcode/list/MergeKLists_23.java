package com.code.leetcode.list;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 合并K个排序链表
 * 输入:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/
 */
public class MergeKLists_23 {
    /**
     * 可以使用优先队列来解决
     * 时间复杂度:O(nlog(k))
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        // 从小到大排序
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val > o2.val) {
                    return 1;
                } else if (o1.val == o2.val) {
                    return 0;
                } else {
                    return -1;
                }
            }
        });
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        for (ListNode node : lists) {
            if (node != null) {
                queue.add(node);
            }
        }
        while (!queue.isEmpty()) {
            tail.next = queue.poll();
            tail = tail.next;
            // 把当前最小的节点的下一个节点压入优先队列中
            if (tail.next != null) {
                queue.offer(tail.next);
            }
        }
        return dummy.next;
    }

    // 分而治之
    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        int mid = left + (right - left) / 2;
        ListNode leftNode = merge(lists, left, mid);
        ListNode rightNode = merge(lists, mid + 1, right);
        return mergeTwoList(leftNode, rightNode);
    }

    // 两个链表进行合并
    private ListNode mergeTwoList(ListNode leftNode, ListNode rightNode) {
        if (leftNode == null) {
            return rightNode;
        }
        if (rightNode == null) {
            return leftNode;
        }
        if (leftNode.val < rightNode.val) {
            leftNode.next = mergeTwoList(leftNode.next, rightNode);
            return leftNode;
        } else {
            rightNode.next = mergeTwoList(leftNode, rightNode.next);
            return rightNode;
        }
    }

    public static void main(String[] args) {

    }

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
