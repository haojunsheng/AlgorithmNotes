package com.code.nowcoder;

import java.util.HashMap;

/**
 * 给你一个数组和一个整数target，可以保证数组中存在两个数的和为target，请你返回这两个数的索引。
 * 输入nums = [3,1,3,6], target = 6 ，算法应该返回数组[0,2] ，因为 3 + 3 = 6。
 */
public class TwoSum {
    // 哈希表的查询时间为 O(1)，算法的时间复杂度降低到 O(N)，但 是需要 O(N) 的空间复杂度来存储哈希表
    int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        // 构造一个哈希表:元素映射到相应的索引
        HashMap<Integer, Integer> index = new HashMap<>();
        for (int i = 0; i < n; i++) {
            index.put(nums[i], i);
        }
        for (int i = 0; i < n; i++) {
            int other = target - nums[i];
            // 如果 other 存在且不是 nums[i] 本身
            if (index.containsKey(other) && index.get(other) != i) {
                return new int[]{i, index.get(other)};
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String args[]) {

    }
}
