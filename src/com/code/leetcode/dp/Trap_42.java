package com.code.leetcode.dp;

import java.util.Stack;

/**
 * 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 * https://leetcode-cn.com/problems/trapping-rain-water/
 *
 * @author 俊语
 * @date 2020/7/26 11:36
 */
public class Trap_42 {
    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(height));
    }

    /**
     * 动态规划，时间复杂度O(n)，空间复杂度O(n)
     * 位置i的最大水柱高度就是 min(l_max, r_max)
     *
     * @param height
     * @return
     */
    public static int trap(int[] height) {
        int length = height.length;
        if (length <= 0) {
            return 0;
        }
        int sum = 0;
        // 备忘录进行优化
        // maxLeft[i]表示位置i左边最高的柱子高度,不包含自己
        // maxRight[i]表示位置i右边最高的柱子高度
        int[] maxLeft = new int[length];
        int[] maxRight = new int[length];

        for (int i = 1; i < length - 1; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i - 1]);
        }
        for (int i = length - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], height[i + 1]);
        }
        for (int i = 1; i < length - 1; i++) {
            int min = Math.min(maxLeft[i], maxRight[i]);
            if (min > height[i]) {
                sum = sum + (min - height[i]);
            }
        }
        return sum;
    }

    /**
     * 双指针，因为maxLeft[i]和maxRight[i]只用到了一次，所以可以用maxLeft和maxRight来代替
     * 时间复杂度O(n)，空间复杂度O(1)
     *
     * @param height
     * @return
     */
    public static int trap2(int[] height) {
        int sum = 0;
        int max_left = 0;
        int max_right = 0;
        int left = 1;
        int right = height.length - 2; // 加右指针进去
        for (int i = 1; i < height.length - 1; i++) {
            //从左到右更
            if (height[left - 1] < height[right + 1]) {
                max_left = Math.max(max_left, height[left - 1]);
                int min = max_left;
                if (min > height[left]) {
                    sum = sum + (min - height[left]);
                }
                left++;
                //从右到左更
            } else {
                max_right = Math.max(max_right, height[right + 1]);
                int min = max_right;
                if (min > height[right]) {
                    sum = sum + (min - height[right]);
                }
                right--;
            }
        }
        return sum;
    }

    /**
     * 单调栈
     * 时间复杂度O(n)，空间复杂度O(n)。虽然while循环里套了一个 while 循环，但是考虑到每个元素最多访问两次，入栈一次和出栈一次，所以时间复杂度是 O(n)
     *
     * @param height
     * @return
     */
    public int trap3(int[] height) {
        int length = height.length;
        if (length <= 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        int current = 0;
        while (current < height.length) {
            //如果栈不空并且当前指向的高度大于栈顶高度就一直循环
            while (!stack.empty() && height[current] > height[stack.peek()]) {
                //取出要出栈的元素
                int h = height[stack.peek()];
                stack.pop();
                // 栈空就出去
                if (stack.empty()) {
                    break;
                }
                //两堵墙之前的距离
                int distance = current - stack.peek() - 1;
                int min = Math.min(height[stack.peek()], height[current]);
                sum = sum + distance * (min - h);
            }
            //当前指向的墙入栈
            stack.push(current);
            current++;
        }
        return sum;
    }
}
