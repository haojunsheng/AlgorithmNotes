package com.code.leetcode.dp;

import java.util.Arrays;

/**
 * 零钱兑换
 * https://leetcode-cn.com/problems/coin-change/
 * <p>
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 * 如果没有任何一种硬币组合能组成总金额，返回 -1。
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 *
 * @author 俊语
 * @date 2020/9/13 11:25
 */
public class CoinChange_322 {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println(coinChange(coins, amount));
    }

    /**
     * 核心是定义状态，不变的量可以充当状态，所以是当前的目标金额是 n ，至少需要 dp(n) 个硬币凑出该金额。
     * 下一步的核心是状态的转换：从coins中选择一个，和dp(n)进行比较，选择一个较小的；
     * 然后是basecase,目标金额为 0 时，所需硬币数量为 0，这里基本就做出来了，求；最小值，所以数组初始化为一个较大的数；
     *
     * @param coins
     * @param amount
     * @return
     */
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i < dp.length; ++i) {
            for (int coin : coins) {
                if (i - coin < 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return (dp[amount] == amount + 1 ? -1 : dp[amount]);
    }
}
