package com.code.leetcode.other;

import java.util.Random;

/**
 * 打乱数组,打乱一个没有重复元素的数组。
 * <p>
 * // 以数字集合 1, 2 和 3 初始化数组。
 * int[] nums = {1,2,3};
 * Solution solution = new Solution(nums);
 * // 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。
 * solution.shuffle();
 * // 重设数组到它的初始状态[1,2,3]。
 * solution.reset();
 * // 随机返回数组[1,2,3]打乱后的结果。
 * solution.shuffle();
 */
public class Shuffle_384 {
    private int[] nums;
    private int[] original;
    private Random rand = new Random();

    public Shuffle_384(int[] nums) {
        this.nums = nums;
        original = nums.clone();
    }

    // 这里需要注意，nums也需要重置，如果把nums指向original，那么original也需要重新clone，否则会被修改
    public int[] reset() {
        nums = original;
        original = original.clone();
        return original;
    }

    /**
     * 洗牌算法
     * 洗牌算法正确性的准则:产生的结果必须有n!种可能，否则就是错误的。
     */
    public int[] shuffle() {
        int length = nums.length;
        //
        for (int i = 0; i < length; ++i) {
            // 从 i 到最后一个随机选一个元素
            int randIndex = randInt(i, length);
            swap(i, randIndex);
        }
        return nums;
    }

    private void swap(int num1, int num2) {
        int temp = nums[num1];
        nums[num1] = nums[num2];
        nums[num2] = temp;
    }

    // 注意这里面的坑，rand.nextInt返回的是0~n之间的任意一个数，包括0，不包括n，n必须大于0
    private int randInt(int start, int end) {
        return rand.nextInt(end - start) + start;
    }
}