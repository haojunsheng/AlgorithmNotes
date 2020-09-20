package com.code.leetcode.dp;

/**
 * 四键键盘
 *
 * @author 俊语
 * @date 2020/9/17 09:21
 */
public class Keyboard_651 {
    public static void main(String[] args) {
        int N = 7;
        System.out.println(maxA(N));
    }

    /**
     * 最优按键序列一定只有两种情况：
     * 1. 要么一直按 A :A,A,...A(当N比较小时)。
     * 2. 当 N 比较大时，后期 C-V 的收获肯定很大。这种情况下整个操作序列大致是:开头连按几个 A ，然后 C-A C-C 组合再接若干 C-V ，然后再 C-A C-C 接着若干 C-V ，循环下去。
     *
     * @param N
     * @return
     */
    public static int maxA(int N) {
        // dp[i]表示i次操作后最多的A
        int[] dp = new int[N + 1];
        if (N <= 0) {
            return 0;
        }
        if (N <= 3) {
            return N;
        }
        for (int i = 1; i <= N; i++) {
            dp[i] = dp[i - 1] + 1;
            for (int j = 2; j < i; j++) {
                // 按A
                //全选 & 复制 dp[j-2]，连续粘贴 i - j 次,/ 屏幕上共 dp[j - 2] * (i - j + 1) 个 A
                dp[i] = Math.max(dp[i], dp[j - 2] * (i - j + 1));
            }
        }
        return dp[N];
    }
}
