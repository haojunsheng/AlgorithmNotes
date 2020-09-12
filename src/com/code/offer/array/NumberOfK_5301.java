package com.code.offer.array;

/**
 * 数字在排序数组中出现的次数
 * 由于数组有序，所以使用二分查找方法定位k的第一次出现位置和最后一次出现位置
 */
public class NumberOfK_5301 {

    public int GetNumberOfK(int[] array, int k) {
        return helper(array, k) - helper(array, k - 1);
    }

    /**
     * 查找最右边的target
     */
    private int helper(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (nums[m] <= target) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        return i;
    }

    int cnt = 0;

    /**
     * 递归解决
     */
    private void helper(int[] nums, int target, int low, int high) {
        if (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                cnt++;
                helper(nums, target, low, mid - 1);
                helper(nums, target, mid + 1, high);
            } else if (nums[mid] > target) {
                helper(nums, target, low, mid - 1);
            } else {
                helper(nums, target, mid + 1, high);
            }
        }
    }

    public static void main(String[] args) {
        NumberOfK_5301 numberOfK5301 = new NumberOfK_5301();
        int[] array1 = {1, 2, 3, 3, 3, 3, 4, 5};
        //numberOfK5301.test(numberOfK5301,array1,6);
        int[] array2 = {3, 3, 3, 3, 4, 5};
        numberOfK5301.test(numberOfK5301, array2, 3);
    }

    public void test(NumberOfK_5301 numberOfK5301, int[] array, int k) {
        System.out.println(numberOfK5301.GetNumberOfK(array, k));
    }
}
