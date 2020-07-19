package com.code.leetcode.array_string;

/**
 * 多数元素
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * 时间复杂度O(n)，空间复杂度O(1)
 * https://leetcode-cn.com/problems/majority-element/
 */
public class majorityElement_169 {

    /**
     * 主要元素法
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }
        int major = nums[0], count = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (major != nums[i]) {
                count--;
                if (count == 0) {
                    major = nums[i];
                    count = 1;
                }
            } else {
                count++;
            }
        }
        count = 0;
        for (int num : nums) {
            if (major == num) {
                count++;
            }
        }
        if (count <= nums.length / 2) {
            major = -1;
        }
        return major;
    }

    /**
     * 快排的思想
     * 如果把数组进行排序，那么出现次数超过一半的，肯定会在中间，即n/2处。
     * 如果我们选择的数字p在快排一轮后的下标是m，那么比p小的数字有m个，如果m大于1/2，则在右边；否则右边
     */
    public int majorityElementQuickSort(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int index = pardition(nums, 0, nums.length - 1);
        while (index != nums.length / 2) {
            if (index > nums.length / 2) {
                index = pardition(nums, 0, index - 1);
            } else {
                index = pardition(nums, index + 1, nums.length - 1);
            }
        }
        int major = nums[index];
        int count = 0;
        for (int num : nums) {
            if (major == num) {
                count++;
            }
        }
        if (count <= nums.length / 2) {
            major = -1;
        }
        return major;
    }

    /**
     * 快排的核心算法
     *
     * @param nums
     * @param left
     * @param right
     * @return
     */
    public int pardition(int[] nums, int left, int right) {
        int temp = nums[left];
        while (left < right) {
            while (left < right && nums[right] > temp) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] < temp) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = temp;
        return left;
    }

    public static void main(String[] args) {

    }
}
