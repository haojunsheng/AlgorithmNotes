package com.code.leetcode.dp;

import java.util.Arrays;

/**
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
