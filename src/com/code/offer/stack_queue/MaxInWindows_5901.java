package com.code.offer.stack_queue;

import java.util.ArrayDeque;

/**
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。返回滑动窗口中的最大值。
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 */
public class MaxInWindows_5901 {
    ArrayDeque<Integer> deq = new ArrayDeque<Integer>();
    int[] nums;

    /**
     * 双端队列和普通队列最大的不同在于，它允许我们在队列的头尾两端都能在 O(1) 的时间内进行数据的查看、添加和删除。
     * <p>
     * 与队列相似，我们可以利用一个双链表实现双端队列。
     * 双端队列最常用的地方就是实现一个长度动态变化的窗口或者连续区间，而动态窗口这种数据结构在很多题目里都有运用。
     * 可以利用一个双端队列来表示这个窗口。这个双端队列保存当前窗口中最大那个数的下标，
     * 双端队列新的头总是当前窗口中最大的那个数。
     * 同时，有了这个下标，我们可以很快地知道新的窗口是否已经不再包含原来那个最大的数，
     * 如果不再包含，我们就把旧的数从双端队列的头删除。
     * 按照这样的操作，不管窗口的长度是多长，
     * 因为数组里的每个数都分别被压入和弹出双端队列一次，所以我们可以在 O(n)O(n) 的时间里完成任务。
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) {
            return new int[0];
        }
        if (k == 1) {
            return nums;
        }

        // init deque and output
        this.nums = nums;
        int max_idx = 0;
        for (int i = 0; i < k; i++) {
            clean_deque(i, k);
            deq.addLast(i);
            // compute max in nums[:k]
            if (nums[i] > nums[max_idx]) {
                max_idx = i;
            }
        }
        int[] output = new int[n - k + 1];
        output[0] = nums[max_idx];

        // build output
        for (int i = k; i < n; i++) {
            clean_deque(i, k);
            deq.addLast(i);
            output[i - k + 1] = nums[deq.getFirst()];
        }
        return output;
    }

    public void clean_deque(int i, int k) {
        // remove indexes of elements not from sliding window
        if (!deq.isEmpty() && deq.getFirst() == i - k) {
            deq.removeFirst();
        }

        // remove from deq indexes of all elements
        // which are smaller than current element nums[i]
        while (!deq.isEmpty() && nums[i] > nums[deq.getLast()]) {
            deq.removeLast();
        }
    }
}