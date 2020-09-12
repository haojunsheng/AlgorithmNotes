package com.code.leetcode.map;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 前 K 个高频元素
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * <p>
 * 示例 1:
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 * 输入: nums = [1], k = 1
 * 输出: [1]
 *
 * https://leetcode-cn.com/problems/top-k-frequent-elements/
 */
public class TopKFrequent_347 {
    public static int[] topKFrequent(int[] nums, int k) {
        if (nums.length <= 0 || nums == null || k <= 0) {
            return new int[]{-1};
        }
        HashMap<Integer, Integer> count = new HashMap<>(k);
        for (int num : nums) {
            if (count.containsKey(num)) {
                count.put(num, count.get(num) + 1);
            } else {
                count.put(num, 1);
            }
        }
        // 最小堆
        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return count.get(o1) - count.get(o2);
            }
        });
        for (Integer key : count.keySet()) {
            if (queue.size() < k) {
                queue.add(key);
            } else if (count.get(key) > count.get(queue.peek())) {
                queue.remove();
                queue.add(key);
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; ++i) {
            res[i] = queue.remove();
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(topKFrequent(new int[]{1,1,1,2,2,3},2));
    }
}