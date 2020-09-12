package com.code.nowcoder;

import java.util.HashMap;

/**
 * 算出一共有几个和为k的连续子数组
 */
public class PreSum {
    // 时间复杂度过高
    int subarraySum(int[] nums, int k) {
        int n = nums.length;
        // 前缀和数组
        // preSum[i] 就是 nums[0..i- 1] 的和。
        // 那么如果我们想求 nums[i..j] 的和，只需要一步操作,preSum[j+1]-preSum[i] 即可，而不需要重新去遍历数组了。
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
     *
     * @param nums
     * @param k
     * @return
     */
    int subarraySumHashMap(int[] nums, int k) {
        int n = nums.length;
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

    public static void main(String args[]) {

    }
}
