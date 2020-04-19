package com.code.offer.array;

/**
 * 0～n-1中缺失的数字
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
 * 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 * 输入: [0,1,2,3,4,5,6,7,9]
 * 输出: 8
 */
public class MissingNumber_5302 {
    /**
     * 排序数组中的搜索问题，首先想到 二分法 解决
     */
    public int getMissingNumber(int[] array) {
        int length = array.length;
        if (array == null || length == 0) {
            return -1;
        }
        int left = 0;
        int right = length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (array[middle] != middle) {
                // middle不相等，但是middle - 1相等，说明就是middle
                if (middle == 0 || array[middle - 1] == middle - 1) {
                    return middle;
                }
                right = middle - 1;
            } else {//肯定在右边
                left = middle + 1;
            }
        }
        if (left == length) {
            return length;
        }
        return -1;
    }
}