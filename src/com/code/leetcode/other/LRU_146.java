package com.code.leetcode.other;

import java.util.HashMap;

/**
 * LRU缓存机制:最近最少使用，按照访问时间进行排序
 * https://leetcode-cn.com/problems/lru-cache/
 *
 * @author 俊语
 * @date 2020/7/25 11:41
 */
public class LRU_146 {
    /**
     * 头结点和尾节点
     */
    private DoubleList list;
    /**
     * 最大容量
     */
    private int capacity;

    private HashMap<Integer, Node> map;

    public LRU_146(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);
        list = new DoubleList();
    }

    public int get(int key) {
        Node node = map.get(key);
        // 不包含则返回-1
        if (node == null) {
            return -1;
        }
        // 移动到头部，返回该节点值
        list.moveToHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            list.moveToHead(node);
            node.val = value;
        } else {//key不存在
            Node newNode = new Node(key, value);
            if (map.size() == capacity) {
                Node tail = list.getTail();
                map.remove(tail.key);
                list.removeTail();
            }
            map.put(key, newNode);
            list.moveToHead(newNode);
        }
    }


    /**
     * 删除最后一个节点
     */

    class DoubleList {
        private Node dummyHead;
        private Node dummyTail;

        DoubleList() {
            dummyHead = new Node(0, 0);
            dummyTail = new Node(0, 0);
            dummyHead.next = dummyTail;
            dummyTail.pre = dummyHead;
        }

        /**
         * 在链表的头部添加节点
         */
        public void addToHead(Node node) {
            node.pre = dummyHead;
            node.next = dummyHead.next;
            dummyHead.next.pre = node;
            dummyHead.next = node;
        }

        /**
         * 把节点移动到头部
         */
        void moveToHead(Node node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
            addToHead(node);
        }

        /**
         * 获得尾节点
         *
         * @return
         */
        public Node getTail() {
            return dummyTail.pre;
        }

        /**
         * 删除尾节点
         */
        public void removeTail() {
            Node temp = dummyTail.pre.pre;
            temp.next = dummyTail;
            dummyTail.pre = temp;
        }
    }

    class Node {
        public int key, val;
        Node pre, next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}
