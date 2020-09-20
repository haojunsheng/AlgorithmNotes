package com.code.leetcode.array_string;

import java.util.HashMap;
import java.util.Map;

/**
 * 和等于 k 的最长子数组长度
 * 给定一个数组nums和一个目标值k，找到和等于k的最长子数组长度。如果不存在任意一个符合要求的子数组，则返回0。
 * <p>
 * 输入: nums = [1, -1, 5, -2, 3], k = 3
 * 输出: 4
 * 解释: 子数组 [1, -1, 5, -2] 和等于 3，且长度最长。
 * https://leetcode-cn.com/problems/maximum-size-subarray-sum-equals-k/
 *
 * @author 俊语
 * @date 2020/9/19 09:56
 */
public class MaxSubArrayLen_325 {
    public static void main(String[] args) {
        int[] nums = {1, -1, 5, -2, 3};
        int k = 3;
        System.out.println(maxSubArrayLen(nums, k));
    }

    public static int maxSubArrayLen(int[] nums, int k) {
        int len = nums.length;
        // max储存最长子数组长度
        int max = -1;

        // 求前缀和，并利用 Map<前缀和, 对应索引> 储存，如果出现前缀和相同的情况，则储存较小的索引
        int[] sum = new int[len + 1];
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        for (int i = 1; i <= len; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
            // 后序碰到sum[i]，则丢弃，因为要求最小的
            if (!map.containsKey(sum[i])) {
                map.put(sum[i], i);
            }
        }

        // 从后向前遍历数组，i为子数组的结尾，寻找符合条件的前缀和及其索引
        for (int i = len; i > max; i--) {
            // 寻找map中是否储存有key为sum[i] - k的索引，如果有则更新max；
            if (map.containsKey(sum[i] - k)) {
                max = Math.max(max, i - map.get(sum[i] - k));
            }
        }
        return max;
    }
}
