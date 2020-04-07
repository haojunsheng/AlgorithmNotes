package com.code.offer.array;

/**
 * 面试题42：连续子数组的最大和
 * 题目：输入一个整型数组，数组里有正数也有负数。数组中一个或连续的多个整
 * 数组成一个子数组。求所有子数组的和的最大值。要求时间复杂度为O(n)。
 */
public class GreatestSumOfSubarrays_42 {
    /**
     * 算法时间复杂度O（n）
     * 用total记录累计值，maxSum记录和最大
     * 基于思想：对于一个数A，若是A的左边累计数非负，那么加上A能使得值不小于A，认为累计值对
     * 整体和是有贡献的。如果前几项累计值负数，则认为有害于总和，total记录当前值。
     * 此时 若和大于maxSum 则用maxSum记录下来
     */
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array.length == 0 || array == null) {
            return 0;
        }
        int max = array[0];
        int total = array[0];
        for (int i = 1; i < array.length; ++i) {
            //加上当前元素比之前结果大
            if (total >= 0) {
                total += array[i];
            } else {//如果前几项累计值负数，则认为有害于总和，total记录当前值。
                total = array[i];
            }
            if (total > max) {
                max = total;
            }
        }
        return max;
    }

    /**
     * 使用动态规划
     * F（i）：以array[i]为末尾元素的子数组的和的最大值，子数组的元素的相对位置不变
     * F（i）=max（F（i-1）+array[i] ， array[i]）
     * res：所有子数组的和的最大值
     * res=max（res，F（i））
     * <p>
     * 如数组[6, -3, -2, 7, -15, 1, 2, 2]
     * 初始状态：
     * F（0）=6
     * res=6
     * i=1：
     * F（1）=max（F（0）-3，-3）=max（6-3，3）=3
     * res=max（F（1），res）=max（3，6）=6
     * i=2：
     * F（2）=max（F（1）-2，-2）=max（3-2，-2）=1
     * res=max（F（2），res）=max（1，6）=6
     * i=3：
     * F（3）=max（F（2）+7，7）=max（1+7，7）=8
     * res=max（F（2），res）=max（8，6）=8
     * i=4：
     * F（4）=max（F（3）-15，-15）=max（8-15，-15）=-7
     * res=max（F（4），res）=max（-7，8）=8
     * 以此类推
     * 最终res的值为8
     *
     * @param array
     * @return
     */
    public int FindGreatestSumOfSubArrayDp(int[] array) {
        int res = array[0]; //记录当前所有子数组的和的最大值
        int max = array[0];   //包含array[i]的连续数组最大值
        for (int i = 1; i < array.length; i++) {
            max = Math.max(max + array[i], array[i]);
            res = Math.max(max, res);
        }
        return res;
    }
}
