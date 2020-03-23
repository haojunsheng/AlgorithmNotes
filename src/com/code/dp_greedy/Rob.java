package com.code.dp_greedy;

import java.util.Arrays;

/**
 * 打家劫舍问题
 */
public class Rob {
    //    public int rob(int[] nums) {
//        return dp(nums, 0);
//    }
//
//    // 返回 nums[start..] 能抢到的最大值
//    // 你面前房子的索引就是状态，抢和不抢就是选择。
//    private int dp(int[] nums, int start) {
//        if (start >= nums.length) {
//            return 0;
//        }
//        // 分别是不抢去下家，和抢了去下下家
//        int res = Math.max(dp(nums, start + 1), nums[start] + dp(nums, start + 2));
//        return res;
//    }
    // 上面的存在重叠子问题，下面进行优化
//    private int[] memo;
//
//    public int rob(int[] nums) {
//        memo = new int[nums.length];
//        Arrays.fill(memo, -1);
//        return dp(nums, 0);
//    }
//
//    // 返回 dp[start..] 能抢到的最大值
//    private int dp(int[] nums, int start) {
//        if (start >= nums.length) {
//            return 0;
//        }
//        if (memo[start] != -1) {
//            return memo[start];
//        }
//        int res = Math.max(dp(nums, start + 1), nums[start] + dp(nums, start + 2));
//        // 记入入备忘录
//        memo[start] = res;
//        return res;
//    }
    int rob(int[] nums) {
        int n = nums.length;
        // dp[i] = x 表示:
        // 从第 i 间房子开始抢劫，最多能抢到的钱为 x
        // base case: dp[n] = 0
        int[] dp = new int[n + 2];
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = Math.max(dp[i + 1], nums[i] + dp[i + 2]);
        }
        return dp[0];
    }
}