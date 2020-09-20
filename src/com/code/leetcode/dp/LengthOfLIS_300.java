package com.code.leetcode.dp;

import java.util.Arrays;

/**
 * 最长上升子序列,给定一个无序的整数数组，找到其中最长上升子序列的长度
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 *
 * @author 俊语
 * @date 2020/9/13 12:43
 */
public class LengthOfLIS_300 {
    public static void main(String[] args) {

    }

    public int lengthOfLIS(int[] nums) {
        // 非法数组处理
        if (nums.length <= 0) {
            return 0;
        }
        // dp[i]表示以num[i]结尾的最长递增子序列的长度
        int dp[] = new int[nums.length];
        // 长度最少为1
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int max = dp[0];
        for (int temp : dp) {
            if (temp > max) {
                max = temp;
            }
        }
        return max;
    }
}
