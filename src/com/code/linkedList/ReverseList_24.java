package com.code.linkedList;

/**
 * 题目描述：
 * 定义一个函数，输入一个链表的头结点，反转该链表并输出反转后的链表的头结点。
 *
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

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode cur = head;
        for (int i = 2; i < 5; ++i) {
            ListNode temp = new ListNode(i);
            cur.next = temp;
            cur = temp;
        }
        reverse(head);
    }
}
