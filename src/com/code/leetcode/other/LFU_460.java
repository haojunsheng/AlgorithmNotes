package com.code.leetcode.other;

import java.util.HashMap;
import java.util.Map;

/**
 * LFU缓存:最近最不常用，按照访问频次排序
 * https://leetcode-cn.com/problems/lfu-cache
 *
 * @author 俊语
 * @date 2020/7/25 15:37
 */
public class LFU_460 {
    int capacity, size, minFrequency;
    private Map<Integer, Node> map;
    /**
     * 每个访问次数对应的双向链表
     */
    private Map<Integer, DoubleList> frequentMap;

    public LFU_460(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);
        frequentMap = new HashMap<>();
    }

    public static void main(String[] args) {
        LFU_460 cache = new LFU_460(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // 返回 1
        cache.put(3, 3);    // 去除 key 2
        cache.get(2);       // 返回 -1 (未找到key 2)
        cache.get(3);       // 返回 3
        cache.put(4, 4);    // 去除 key 1
        cache.get(1);       // 返回 -1 (未找到 key 1)
        cache.get(3);       // 返回 3
        cache.get(4);       // 返回 4
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        updateNode(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (capacity <= 0) {
            return;
        }
        // 如果已经有该键，则更新
        if (map.containsKey(key)) {
            Node curNode = map.get(key);
            curNode.val = value;
            updateNode(curNode);
        } else {
            size++;
            if (size > capacity) {
                // get minimum frequency list
                DoubleList minFreqList = frequentMap.get(minFrequency);
                Node deleteNode = minFreqList.removeTail();
                map.remove(deleteNode.key);
                size--;
            }
            // reset min frequency to 1 because of adding new node
            minFrequency = 1;
            Node newNode = new Node(key, value);
            // get the list with frequency 1, and then add new node into the list, as well as into LFU cache
            DoubleList curList = frequentMap.getOrDefault(1, new DoubleList());
            curList.addToHead(newNode);
            frequentMap.put(1, curList);
            map.put(key, newNode);
        }
    }

    /**
     * 更新节点和频率
     *
     * @param node
     */
    private void updateNode(Node node) {
        int curFreq = node.freq;
        // 获取freq对应的链表，并将该节点删除
        DoubleList oldList = frequentMap.get(curFreq);
        oldList.removeNode(node);
        // 如果当前链表的频率是minFrequency，且删除完了，则更新min
        if (node.freq == minFrequency && oldList.size == 0) {
            minFrequency++;
        }
        // 将该节点插入新的频率为freq+1的链表，如果没有，则初始化1个
        node.freq++;
        DoubleList newList = frequentMap.getOrDefault(node.freq, new DoubleList());
        newList.addToHead(node);
        frequentMap.put(node.freq, newList);
    }


    /**
     * 封装双向链表的相关操作
     */
    class DoubleList {
        int size;
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
            size++;
        }

        /**
         * 删除某个节点
         *
         * @param node
         */
        public void removeNode(Node node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
            size--;
        }

        /**
         * 删除尾节点
         */
        public Node removeTail() {
            if (size > 0) {
                Node temp = dummyTail.pre;
                removeNode(temp);
                return temp;
            }
            return null;
        }
    }

    class Node {
        /**
         * frequency: frequency count of current node
         */
        public int key, val, freq = 1;
        Node pre, next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}
