package com.code.leetcode.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 存在重复元素 III
 * 给定一个整数数组，判断数组中是否有两个不同的索引i和j，使得nums[i]和nums[j]的差的绝对值最大为t，并且i和j之间的差的绝对值最大为ķ。
 * 输入: nums = [1,2,3,1], k = 3, t = 0
 * 输出: true
 * 输入: nums = [1,0,1,1], k = 1, t = 2
 * 输出: true
 * 输入: nums = [1,5,9,1,5,9], k = 2, t = 3
 * 输出: false
 * https://leetcode.com/problems/contains-duplicate-iii
 *
 * @author anapodoton
 */
public class ContainsNearbyAlmostDuplicate_220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k < 1 || t < 0) {
            return false;
        }
        // 桶的大小 1L + t，桶内元素差值必然不超过 t
        long w = 1L + t;
        // 构建桶
        Map<Long, Long> bucket = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            // 得到桶 id
            long id = getId(nums[i], w);
            if (bucket.containsKey(id) ||   // 同一个桶的元素差值必然不超过 t
                    bucket.containsKey(id - 1) && nums[i] - bucket.get(id - 1) <= t ||  // 前面一个桶二者差值不超过 t
                    bucket.containsKey(id + 1) && bucket.get(id + 1) - nums[i] <= t) {  // 后面一个桶二者差值不超过 t
                return true;
            }
            // 维持窗口大小不超过 k
            if (bucket.size() == k) {
                bucket.remove(getId(nums[i - k], w));
            }
            bucket.put(id, Long.valueOf(nums[i]));
        }
        return false;
    }

    private long getId(long num, long w) {
        // num 可能为负数，减去 Integer.MIN_VALUE 这个偏移量得到非负数
        return (num - Integer.MIN_VALUE) / w;
    }
}