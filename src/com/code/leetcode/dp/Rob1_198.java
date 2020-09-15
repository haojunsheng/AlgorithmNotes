package com.code.leetcode.dp;

import java.util.Arrays;

/**
 * 打家劫舍I
 * 每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 * 输入：[1,2,3,1], 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。偷窃到的最高金额 = 1 + 3 = 4 。
 * <p>
 * 输入：[2,7,9,3,1], 输出：12
 * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 * https://leetcode-cn.com/problems/house-robber/
 */
public class Rob1_198 {
    public int rob(int[] nums) {
        if (nums.length < 0) {
            return 0;
        }
        return dfs(nums, 0);
    }

    private int dfs(int[] nums, int index) {
        if (index >= nums.length) {
            return 0;
        }
        int res = Math.max(dfs(nums, index + 1),//不抢，去下家
                dfs(nums, index + 2) + nums[index]);// 抢，抢完去下下家
        return res;
    }

    /**
     * 备忘录优化
     *
     * @param nums
     * @return
     */
    private int[] memo;

    public int rob2(int[] nums) {
        if (nums.length < 0) {
            return 0;
        }
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return dfs(nums, 0);
    }

    private int dfs2(int[] nums, int index) {
        if (index >= nums.length) {
            return 0;
        }
        if (memo[index] != -1) {
            return memo[index];
        }
        int res = Math.max(dfs2(nums, index + 1),//不抢，去下家
                dfs2(nums, index + 2) + nums[index]);// 抢，抢完去下下家
        memo[index] = res;
        return res;
    }

    public static int rob3(int[] nums) {
        if (nums.length <= 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        // dp[i]表示第i号房子可以抢到的最大值
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i < dp.length; ++i) {
            dp[i] = Math.max(dp[i - 1], //抢了上家
                    nums[i - 1] + dp[i - 2]);//抢当前的
        }
        return dp[nums.length];
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(rob3(nums));
    }
}