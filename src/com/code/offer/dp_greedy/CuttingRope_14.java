package com.code.offer.dp_greedy;

/**
 * 剪绳子
 * https://leetcode-cn.com/problems/jian-sheng-zi-lcof/
 * 给定一根长度为n的绳子，请把绳子剪成m段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为k[0],k[1],…,k[m]。
 * 请问k[0]* k[1] * … *k[m]可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 */
public class CuttingRope_14 {
    public static int cutRope(int length) {
        if (length <= 1) {
            return 0;
        }
        if (length == 2) {
            return 1;
        }
        if (length == 3) {
            return 2;
        }
        // dp[i]表示绳子长度为i时的参与计算乘积的最大值
        int[] dp = new int[length + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 4; i <= length; ++i) {
            for (int j = 2; j <= i / 2; ++j) {
                dp[i] = Math.max(dp[i], dp[j] * dp[i - j]);
            }
        }
        return dp[length];
    }

    public static void main(String args[]) {
        System.out.println(cutRope(5));
    }
}
