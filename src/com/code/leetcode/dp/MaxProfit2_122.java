package com.code.leetcode.dp;

/**
 * 买卖股票的最佳时机 II
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * 即交易次数无限
 * 输入: [7,1,5,3,6,4]，输出: 7
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 *
 * @author 俊语
 * @date 2020/9/15 15:32
 */
public class MaxProfit2_122 {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit2(prices));
    }

    public static int maxProfit(int[] prices) {
        int length = prices.length;
        if (length <= 0) {
            return 0;
        }
        // dp[i][0]表示第i天卖出股票的利润
        // dp[i][1]表示第i天买入股票的利润
        int[][] dp = new int[length][2];
        // base case
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < length; ++i) {
            //今天没有持有股票：昨天已经卖出；昨天持有，今天卖出
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            //今天持有：昨天持有；今天买入
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
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
        for (int i = 1; i < length; ++i) {
            //第i天卖出的最大收益
            dp0 = Math.max(dp0, dp1 + prices[i]);
            //第i天买入的最大收益
            dp1 = Math.max(dp1, dp0 - prices[i]);
        }
        return dp0;
    }
}
