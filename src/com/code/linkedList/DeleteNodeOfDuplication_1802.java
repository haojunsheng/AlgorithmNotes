package com.code.linkedList;

/**
 * 删除链表中的重复节点
 */
public class DeleteNodeOfDuplication_1802 {
    static class ListNode {
        int nodeValue;
        ListNode nextNode;
    }

    private ListNode deleteDuplication(ListNode head) {
        if (head == null) {
            return null;
        }
        //保存前一个节点
        ListNode preNode = new ListNode();
        // 最终头结点，因为可能删除头结点
        ListNode lastHead = preNode;
        preNode.nextNode = head;
        // 当前处理节点
        ListNode nowNode = head;
        while (nowNode != null) {
            //删除重复节点
            if (nowNode.nextNode != null && nowNode.nodeValue == nowNode.nextNode.nodeValue) {
                // 相同节点一直删除，更新now
                while (nowNode.nextNode != null && nowNode.nodeValue == nowNode.nextNode.nodeValue) {
                    nowNode = nowNode.nextNode;
                }
                // 更新前一个节点
                preNode.nextNode = nowNode.nextNode;
            } else {
                // 不相等，更新前置节点
                preNode.nextNode = nowNode;
            }
            // 不管相等与否，更新当前节点
            nowNode = nowNode.nextNode;
        }
        return lastHead.nextNode;
    }
}
