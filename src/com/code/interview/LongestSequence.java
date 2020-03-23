package com.code.interview;

import java.util.Arrays;

/**
 * 腾讯一面
 * 最长递增子序列
 */
public class LongestSequence {
    /**
     * @param nums
     * @return 最长子序列的长度
     */
    public int lengthOfLongestSequence(int[] nums) {
        if (nums.length <= 0 || nums == null) {
            return -1;
        }
        //dp[i]表示以arr[i]为结尾的最长子序列
        int dp[] = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int res = 0;
        for (int i = 0; i < dp.length; ++i) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void test1(LongestSequence longestSequence, int[] nums) {
        System.out.println(longestSequence.lengthOfLongestSequence(nums));
    }

    public static void test2(LongestSequence longestSequence, int[] nums) {
        System.out.println(longestSequence.lengthOfLongestSequence(nums));
    }

    public static void test3(LongestSequence longestSequence, int[] nums) {
        System.out.println(longestSequence.lengthOfLongestSequence(nums));
    }

    public static void test4(LongestSequence longestSequence, int[] nums) {
        System.out.println(longestSequence.lengthOfLongestSequence(nums));
    }

    public static void main(String[] args) {
        LongestSequence longestSequence = new LongestSequence();
        // 1. 输入的数组非法
        int[] nums1 = {};
        test1(longestSequence, nums1);
        // 2. 数组中只有一个元素
        int[] nums2 = {1};
        test2(longestSequence, nums2);
        // 3. 无序数组，存在递增子序列
        int[] nums3 = {10, 9, 2, 5, 3, 8, 6};
        test3(longestSequence, nums3);
        // 4. 有序数组
        int[] nums4 = {1, 2, 3, 4, 5};
        test4(longestSequence, nums4);
    }
}