package com.code.leetcode.array_string;

/**
 * 题目：长度最小的子数组
 * 给定一个含有n个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组，并返回其长度。
 * 如果不存在符合条件的连续子数组，返回 0。
 * 输入: s = 7, nums = [2,3,1,2,4,3]。输出: 2
 * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 */
public class MinSubArrayLen_209 {
    /**
     * 滑动窗口，双指针。用双指针 left 和 right 表示一个窗口。
     * 1. right 向右移增大窗口，直到窗口内的数字和大于等于了 s。进行第 2 步。
     * 2. 记录此时的长度，left 向右移动，开始减少长度，每减少一次，就更新最小长度。直到当前窗口内的数字和小于了 s，回到第 1 步。
     */
    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length <= 0 || s <= 0) {
            return 0;
        }
        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE, sumLeftToRight = 0;
        // 内外两个循环不是相对独立的
        while (right < nums.length) {
            sumLeftToRight += nums[right];
            right++;
            while (sumLeftToRight >= s) {
                minLen = Math.min(minLen, right - left);
                // left向右滑动
                sumLeftToRight -= nums[left];
                left++;
            }
            //left一直增加，right却不增加，以至于left>right，只有一种可能，即nums存在一个元素>=s,当right指向该元素时，left会一直增加直到超过right
            if (left > right) {
                return 1;
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}