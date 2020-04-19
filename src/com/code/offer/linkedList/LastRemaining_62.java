package com.code.offer.linkedList;

import java.util.LinkedList;

/**
 * 圆圈中最后剩下的数字,著名的约瑟夫环问题
 * 0,1,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 * <p>
 * 输入: n = 5, m = 3
 * 输出: 3
 * 输入: n = 10, m = 17
 * 输出: 2
 */
public class LastRemaining_62 {
    // 使用LinkedList来模拟，时间复杂度O(n^2)
    public int LastRemaining_Solution(int n, int m) {
        LinkedList<Integer> linkList = new LinkedList<Integer>();
        for (int i = 0; i < n; ++i) {
            linkList.add(i);
        }
        int bt = 0;
        while (linkList.size() > 1) {
            bt = (bt + m - 1) % linkList.size();
            linkList.remove(bt);
        }
        return linkList.size() == 1 ? linkList.get(0) : -1;
    }

    /**
     * 数学公式
     * 第一轮是 [0, 1, 2, 3, 4] ，所以是 [0, 1, 2, 3, 4] 这个数组的多个复制。这一轮 2 删除了。
     * 第二轮开始时，从 3 开始，所以是 [3, 4, 0, 1] 这个数组的多个复制。这一轮 0 删除了。
     * 第三轮开始时，从 1 开始，所以是 [1, 3, 4] 这个数组的多个复制。这一轮 4 删除了。
     * 第四轮开始时，还是从 1 开始，所以是 [1, 3] 这个数组的多个复制。这一轮 1 删除了。
     * 最后剩下的数字是 3。
     * 图中的绿色的线指的是新的一轮的开头是怎么指定的，每次都是固定地向前移位 m 个位置。
     * 然后我们从最后剩下的 3 倒着看，我们可以反向推出这个数字在之前每个轮次的位置。
     * 最后剩下的 3 的下标是 0。
     * 第四轮反推，补上 m 个位置，然后模上当时的数组大小 2，位置是(0 + 3) % 2 = 1。
     * 第三轮反推，补上 m 个位置，然后模上当时的数组大小 3，位置是(1 + 3) % 3 = 1。
     * 第二轮反推，补上 m 个位置，然后模上当时的数组大小 4，位置是(1 + 3) % 4 = 0。
     * 第一轮反推，补上 m 个位置，然后模上当时的数组大小 5，位置是(0 + 3) % 5 = 3。
     * 所以最终剩下的数字的下标就是3。因为数组是从0开始的，所以最终的答案就是3。
     * 总结一下反推的过程，就是 (当前index + m) % 上一轮剩余数字的个数。
     */
    public int lastRemaining(int n, int m) {
        int ans = 0;
        // 最后一轮剩下2个人，所以从2开始反推
        for (int i = 2; i <= n; i++) {
            ans = (ans + m) % i;
        }
        return ans;
    }
}
