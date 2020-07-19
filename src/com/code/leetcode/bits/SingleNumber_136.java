package com.code.leetcode.bits;

/**
 * 只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * <p>
 * Input: [2,2,1]
 * Output: 1
 * Input: [4,1,2,1,2]
 * Output: 4
 * https://leetcode.com/problems/single-number/
 */
public class SingleNumber_136 {
    /**
     * 异或运算
     *
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }
        return ans;
    }

    public static void main(String[] args) {
        // 非法数组
        testInvlid();
        // 正常元素
        testValid();
    }

    private static void testValid() {
        int[] nums = {1, 1, 2, 3, 3};
        System.out.println(singleNumber(nums));
    }

    private static void testInvlid() {
        int[] nums = {};
        System.out.println(singleNumber(nums));
    }
}
