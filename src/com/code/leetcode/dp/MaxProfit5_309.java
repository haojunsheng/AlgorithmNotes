package com.code.leetcode.dp;

/**
 * 买卖股票，含交易冷冻期为1天
 *
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 * @author 俊语
 * @date 2020/9/15 16:18
 */
public class MaxProfit5_309 {
    public static void main(String[] args) {
        int[] prices = {2, 1, 4};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int length = prices.length;
        if (length <= 1) {
            return 0;
        }
        // dp[i][0]表示第i天卖出股票的利润
        // dp[i][1]表示第i天买入股票的利润
        int[][] dp = new int[length][2];
        // base case
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[1][0] = prices[1] > prices[0] ? prices[1] - prices[0] : 0;
        dp[1][1] = Math.max(-prices[0], -prices[1]);
        for (int i = 2; i < length; ++i) {
            //今天没有持有股票：昨天已经卖出；昨天持有，今天卖出
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            //今天持有：昨天持有；今天买入,买入的状态是从i-2进行转移，因为冻结期为1天；
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
        }
        return dp[length - 1][0];
    }

    public static int maxProfit2(int[] prices) {
        int length = prices.length;
        if (length <= 0) {
            return 0;
        }
        // dp[i][0]表示第i天卖出股票的利润
        // dp[i][1]表示第i天买入股票的利润
        int dp0 = 0;
        int dp1 = -prices[0];
        int dp_pre_0 = 0;
        for (int i = 1; i < length; ++i) {
            int temp = dp0;
            //第i天卖出的最大收益
            dp0 = Math.max(dp0, dp1 + prices[i]);
            //第i天买入的最大收益
            dp1 = Math.max(dp1, dp_pre_0 - prices[i]);
            dp_pre_0 = temp;
        }
        return dp0;
    }
}
