package com.code.offer.linkedList;

/**
 * 题目描述：
 * 定义一个函数，输入一个链表的头结点，反转该链表并输出反转后的链表的头结点。
 * <p>
 * 要想反转链表，对于结点i，我们要把它的next指向它的前趋，因此我们需要保存前趋结点，
 * 同时，如果我们已经把i的next重新赋值，会无法找到i的后继，因此，在重新赋值之前，我们要保存i的后继。
 */
public class ReverseList_24 {
    static class ListNode {
        int value;
        ListNode next;

        ListNode(int value) {
            this.value = value;
        }
    }

    // 使用循环的方法
    public ListNode reverseCycle(ListNode head) {
        //判空
        if (head == null) {
            return null;
        }
        //只有一个头结点
        if (head.next == null) {
            return head;
        }
        //当前结点
        ListNode currentNode = head;
        //翻转后的头结点
        ListNode revHead = null;
        while (currentNode != null) {
            //防止丢失，存放下一个结点
            ListNode nextNode = currentNode.next;
            currentNode.next = revHead;
            revHead = currentNode;
            currentNode = nextNode;
        }
        return revHead;
    }

    /**
     * 使用递归的方法
     * reverse(ListNode head)=记录当前节点下一个节点 + 断开 + 递归处理子问题 + 指回来
     *
     * @param head
     * @return realHead
     */
    public static ListNode reverse(ListNode head) {
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

    static ListNode successor = null; // 后驱节点

    /**
     * 反转前n个节点
     *
     * @param head
     * @param n
     * @return
     */
    public static ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            successor = head.next;
            return head;
        }
        ListNode secNode = head.next;
        head.next = successor;
        // 以 head.next 为起点，需要反转前 n - 1 个节点
        ListNode revNode = reverseN(secNode, n - 1);
        secNode.next = head;
        //最后的节点
        return revNode;
    }

    /**
     * 反转链表的一部分
     *
     * @param head
     * @param m
     * @param n
     * @return
     */
    ListNode reverseBetween(ListNode head, int m, int n) {
        // base case,如果 m == 1, 相当于反转链表开头的 n 个元素
        if (m == 1) {
            return reverseN(head, n);
        }
        // 前进到反转的起点触发 base case
        // 如果 m != 1 怎么办?如果我们把 head 的索引视为 1，那么我们是想从第 m 个元素开始反转对吧;
        // 如果把 head.next 的索引视为 1 呢?那么相对于 head.next ，反转的区间应该是从第 m - 1 个元素开始的;
        // 那么对于head.next.next呢
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode cur = head;
        for (int i = 2; i < 5; ++i) {
            ListNode temp = new ListNode(i);
            cur.next = temp;
            cur = temp;
        }
        ListNode res = reverseN(head, 3);
        System.out.println(1);
    }
}
