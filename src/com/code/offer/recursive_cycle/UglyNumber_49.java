package com.code.offer.recursive_cycle;

/**
 * 编写一个程序，找出第 n 个丑数。丑数就是只包含质因数 2, 3, 5 的正整数。
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 * 注意：1是丑数，n 不超过1690。
 */
public class UglyNumber_49 {
    /**
     * (1) 1×2, 2×2, 3×2, 4×2, 5×2, …
     * (2) 1×3, 2×3, 3×3, 4×3, 5×3, …
     * (3) 1×5, 2×5, 3×5, 4×5, 5×5, …
     */
    public int nthUglyNumber(int n) {
        if (n <= 0) {
            return -1;
        }
        int[] nums = new int[n];
        nums[0] = 1;
        int index2 = 0, index3 = 0, index5 = 0;
        for (int i = 1; i < n; ++i) {
            // 下一个丑数
            nums[i] = Math.min(nums[index2] * 2, Math.min(nums[index3] * 3, nums[index5] * 5));
            if (nums[i] == nums[index2] * 2) {
                index2++;
            }
            if (nums[i] == nums[index3] * 3) {
                index3++;
            }
            if (nums[i] == nums[index5] * 5) {
                index5++;
            }
        }
        return nums[n - 1];
    }

    public static void main(String[] args) {
        UglyNumber_49 uglyNumber_49 = new UglyNumber_49();
        System.out.println(uglyNumber_49.nthUglyNumber(10000));
    }
}