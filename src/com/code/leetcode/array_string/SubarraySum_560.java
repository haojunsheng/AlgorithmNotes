package com.code.leetcode.array_string;

import java.util.HashMap;

/**
 * 和为K的子数组
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 * https://leetcode-cn.com/problems/subarray-sum-equals-k/
 *
 * @author 俊语
 * @date 2020/9/18 11:33
 */
public class SubarraySum_560 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        int k = 2;
        System.out.println(subarraySum(nums, k));
    }

    /**
     * 前缀和，主要用于处理数组区间的问题
     * preSum[i] 就是 nums[0..i- 1] 的和，
     * 如果我们想求 nums[i..j] 的和，只需要一步操作,preSum[j+1]-preSum[i] 即可，而不需要重新去遍历数组了
     */
    private static int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] preSum = new int[n + 1];
        preSum[0] = 0;
        for (int i = 0; i < n; ++i) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        int ans = 0;
        // 穷举所有子数组
        for (int i = 1; i <= n; ++i) {
            //在计算，有几个 j 能够使得 sum[i] 和 sum[j] 的差为 k。毎找到一个这样的 j ，就把结果加一。
            for (int j = 0; j < i; ++j) {
                // sum of nums[j..i-1]
                if (preSum[i] - preSum[j] == k) {
                    ans++;
                }
            }
        }
        return ans;
    }

    /**
     * hashmap版本,我直接记录下有几个sum[j]和sum[i]-k相等，直接更新结果，
     * 就避免了内层的for循环。我们可以用哈希表，在记录前缀和的同时记录该前缀和出现的次数。
     */
    int subarraySumHashMap(int[] nums, int k) {
        int n = nums.length;
        // 前缀和 -》该前缀和出现的次数
        HashMap<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);
        int ans = 0, sum0_i = 0;
        for (int i = 0; i < n; ++i) {
            sum0_i += nums[i];
            // 这是我们想找的前缀和 nums[0..j]
            int sum0_j = sum0_i - k;
            if (preSum.containsKey(sum0_j)) {
                ans += preSum.get(sum0_j);
            }
            // 把前缀和nums[0..i]加入并记录出现次数
            preSum.put(sum0_i, preSum.getOrDefault(sum0_i, 0) + 1);
        }
        return ans;
    }
}
