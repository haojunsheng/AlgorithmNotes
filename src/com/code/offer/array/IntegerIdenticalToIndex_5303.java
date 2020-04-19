package com.code.offer.array;

/**
 * 假设一个单调递增的数组里的每个元素都是整数并且是唯一的。
 * 请编程实现一个函数找出数组中任意一个数值等于其下标的元素。
 * <p>
 * 例如，在数组[-3, -1, 1, 3, 5]中，数字3和它的下标相等。
 * 输入：[-3, -1, 1, 3, 5]
 * 输出：3
 * 注意:如果不存在，则返回-1。
 */
public class IntegerIdenticalToIndex_5303 {
    // 二分查找
    public int getNumberSameAsIndex(int[] array) {
        if (array == null || array.length == 0) {
            return -1;
        }

        int start = 0;
        int end = array.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (array[mid] == mid) {
                return mid;
            }
            if (array[mid] > mid) {
                end = mid - 1;
            }
            if (array[mid] < mid) {
                start = mid + 1;
            }
        }
        return -1;
    }
}