package com.code.offer.stack_queue;

import java.util.ArrayDeque;

/**
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。返回滑动窗口中的最大值。
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 */
public class MaxInWindows_5901 {
    /**
     * 双端队列和普通队列最大的不同在于，它允许我们在队列的头尾两端都能在 O(1) 的时间内进行数据的查看、添加和删除。
     * 与队列相似，我们可以利用一个双链表实现双端队列。
     * 双端队列最常用的地方就是实现一个长度动态变化的窗口或者连续区间，而动态窗口这种数据结构在很多题目里都有运用。
     * 可以利用一个双端队列来表示这个窗口。
     * 这个双端队列保存当前窗口中最大那个数的下标，双端队列新的头总是当前窗口中最大的那个数。
     * 同时，有了这个下标，我们可以很快地知道新的窗口是否已经不再包含原来那个最大的数，
     * 如果不再包含，我们就把旧的数从双端队列的头删除。
     * 因为nums里的每个数都分别被压入和弹出双端队列一次，所以我们可以在 O(n)的时间里完成任务。
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0 || k == 1) {
            return nums;
        }
        MonotonicQueue window = new MonotonicQueue();
        int[] res = new int[n - k + 1];
        for (int i = 0; i < n; i++) {
            //先填满窗口的前 k - 1
            if (i < k - 1) {
                window.push(nums[i]);
                // 窗口向前滑动,nums[i - k + 1] 就是窗口最后的元素
            } else {
                window.push(nums[i]);
                res[i - k + 1] = window.max();
                window.pop(nums[i - k + 1]);
            }
        }
        return res;
    }

    /**
     * 单调队列,单调递减
     */
    class MonotonicQueue {
        // 双端队列
        ArrayDeque<Integer> data = new ArrayDeque<>();

        // 在队尾添加元素 n,把前面比新元素小的元素都删掉：
        public void push(int n) {
            while (!data.isEmpty() && data.getLast() < n) {
                data.removeLast();
            }
            data.addLast(n);
        }

        // 返回当前队列中的最大值
        public int max() {
            return data.getFirst();
        }

        // 队头元素如果是 n，删除它
        public void pop(int n) {
            if (!data.isEmpty() && data.getFirst() == n) {
                data.removeFirst();
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {7, 2, 4};
        MaxInWindows_5901 max = new MaxInWindows_5901();
        System.out.println(max.maxSlidingWindow(arr, 2));
    }
}