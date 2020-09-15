package com.code.leetcode.dp;

/**
 * 买卖股票的最佳时机
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 *
 * @author 俊语
 * @date 2020/9/15 15:02
 */
public class MaxProfit1_121 {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
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
            //第i天卖出的最大收益
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            //第i天买入的最大收益
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[length - 1][0];
    }

    /**
     * 第i个元素只和前面的元素有关，所以进行优化
     *
     * @param prices
     * @return
     */
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
            dp1 = Math.max(dp1, -prices[i]);
        }
        return dp0;
    }
}
