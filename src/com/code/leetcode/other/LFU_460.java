package com.code.leetcode.other;

import java.util.Map;

/**
 * https://leetcode-cn.com/problems/lfu-cache
 *
 * @author 俊语
 * @date 2020/7/25 15:37
 */
public class LFU_460 {
    private Map<Integer, Node> map;
    /**
     * 访问次数
     */
    private Map<Integer, DoubleList> frequentMap;

    public LFU_460(int capacity) {

    }

    public int get(int key) {
        return 0;
    }

    public void put(int key, int value) {

    }

    class DoubleList {
        private Node dummyHead;
        private Node dummyTail;
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
