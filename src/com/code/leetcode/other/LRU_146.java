package com.code.leetcode.other;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LRU缓存机制:最近最少使用，按照访问时间进行排序
 * https://leetcode-cn.com/problems/lru-cache/
 * <p>
 * 缓存容量为2,你可以把 cache 理解成一个队列,假设左边是队头，右边是队尾,最近使用的排在队头，久未使用的排在队尾
 * cache.put(1, 1);cache = [(1, 1)]
 * cache = [(2, 2), (1, 1)];cache = [(2, 2), (1, 1)]
 * cache.get(1); 返回 1,因为最近访问了键 1，所以提前至队头
 * cache.put(3,3);cache = [(3, 3), (1, 1)],缓存容量已满，需要删除内容空出位置,优先删除久未使用的数据，也就是队尾的数据
 * cache.get(2); 返回 -1 (未找到)
 *
 * @author 俊语
 * @date 2020/7/25 11:41
 */
public class LRU_146 {
    /**
     * 双向链表
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

    public static void main(String[] args) {
        LRU_146 cache = new LRU_146(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // 返回  1
        cache.put(3, 3);    // 该操作会使得关键字 2 作废
        cache.get(2);       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得关键字 1 作废
        cache.get(1);       // 返回 -1 (未找到)
        cache.get(3);       // 返回  3
        cache.get(4);// 返回  4
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
            // 如果map已满，删除最旧的
            if (map.size() == capacity) {
                Node tail = list.getTail();
                map.remove(tail.key);
                list.removeTail();
            }
            map.put(key, newNode);
            list.addToHead(newNode);
        }
    }

    /**
     * 封装双向链表的相关操作
     */
    class DoubleList {
        // 虚拟头结点
        private Node dummyHead;
        // 虚拟尾节点
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
        public void moveToHead(Node node) {
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

    /**
     * 节点类
     */
    class Node {
        public int key, val;
        Node pre, next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    /**
     * 使用LinkedHashMap来完成
     */
    class LRUCache extends LinkedHashMap<Integer, Integer> {
        private int capacity;

        public LRUCache(int capacity) {
            // 访问顺序排序
            super(capacity, 0.75f, true);
            this.capacity = capacity;
        }

        public int get(int key) {
            return super.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            super.put(key, value);
        }

        /**
         * 是否删除最旧的元素
         *
         * @param eldest
         * @return
         */
        @Override
        public boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return size() > capacity;
        }
    }
}
