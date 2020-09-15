package com.code.leetcode.dp;

/**
 * 包含交易手续费
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
 * @author 俊语
 * @date 2020/9/15 17:22
 */
public class MaxProfit6_714 {
    public static void main(String[] args) {
        int[] prices = {1, 3, 2, 8, 4, 9};
        System.out.println(maxProfit(prices, 2));
    }

    public static int maxProfit(int[] prices, int fee) {
        int length = prices.length;
        if (length <= 0) {
            return 0;
        }
        // dp[i][0]表示第i天卖出股票的利润
        // dp[i][1]表示第i天买入股票的利润
        int[][] dp = new int[length][2];
        // base case
        dp[0][0] = 0;
        dp[0][1] = -prices[0] - fee;
        for (int i = 1; i < length; ++i) {
            //今天没有持有股票：昨天已经卖出；昨天持有，今天卖出
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            //今天持有：昨天持有；今天买入
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i] - fee);
        }
        return dp[length - 1][0];
    }

    public static int maxProfit2(int[] prices, int fee) {
        int length = prices.length;
        if (length <= 0) {
            return 0;
        }
        // dp[i][0]表示第i天卖出股票的利润
        // dp[i][1]表示第i天买入股票的利润
        int dp0 = 0;
        int dp1 = -prices[0];
        for (int i = 1; i < length; ++i) {
            //第i天卖出的最大收益
            dp0 = Math.max(dp0, dp1 + prices[i]);
            //第i天买入的最大收益
            dp1 = Math.max(dp1, dp0 - prices[i] - fee);
        }
        return dp0;
    }
}
