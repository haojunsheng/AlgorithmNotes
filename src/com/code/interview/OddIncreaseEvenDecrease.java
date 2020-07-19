package com.code.interview;

/**
 * 奇升偶降排序
 * 一个单链表，奇数位递增，偶数位递减，最终实现一个整体递增链表
 */
public class OddIncreaseEvenDecrease {

    public static ListNode oddIncreaseEvenDecrease(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode realHead = null;
        // 1. 把链表按照奇数位和偶数位进行分隔
        ListNode[] temp = separate(head);
        ListNode oddHead = temp[0];
        ListNode evenHead = temp[1];
        // 2. 反转偶数链表
        evenHead = reverse(evenHead);
        // 3. 合并链表
        realHead = mergeList(oddHead, evenHead);
        return realHead;
    }

    private static ListNode mergeList(ListNode oddHead, ListNode evenHead) {
        if (oddHead == null) {
            return evenHead;
        }
        if (evenHead == null) {
            return oddHead;
        }
        if (oddHead.val < evenHead.val) {
            oddHead.next = mergeList(oddHead.next, evenHead);
            return oddHead;
        } else {
            evenHead.next = mergeList(oddHead, evenHead.next);
            return evenHead;
        }
    }

    //反转链表
    private static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    private static ListNode[] separate(ListNode head) {
        ListNode oddHead = head;
        ListNode evenHead = head.next;
        ListNode temp = evenHead;
        ListNode oddTemp = oddHead;
        ListNode evenTemp = evenHead;
        while (temp.next != null) {
            oddTemp = temp.next;
            evenTemp = oddTemp.next;
            temp = temp.next;
        }
        return new ListNode[]{oddHead, evenHead};
    }

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        ListNode node = init();
        node = oddIncreaseEvenDecrease(node);
        System.out.println(node);
    }

    private static ListNode init() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        return node1;
    }
}
