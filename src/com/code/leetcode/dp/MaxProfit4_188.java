package com.code.leetcode.dp;

/**
 * 最多k笔交易，k为任意整数
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/
 *
 * @author 俊语
 * @date 2020/9/15 17:54
 */
public class MaxProfit4_188 {
    public static void main(String[] args) {
        int[] prices = {2, 4, 1};
        System.out.println(maxProfit(2, prices));
    }

    public static int maxProfit(int k, int[] prices) {
        int length = prices.length;
        if (length <= 1) {
            return 0;
        }
        //当k非常大时转为无限次交易
        if (k >= length / 2) {
            int dp0 = 0, dp1 = -prices[0];
            for (int i = 1; i < length; ++i) {
                dp0 = Math.max(dp0, dp1 + prices[i]);
                dp1 = Math.max(dp1, dp0 - prices[i]);
            }
            return Math.max(dp0, dp1);
        }
        //定义二维数组，交易了多少次、当前的买卖状态
        int[][] dp = new int[k + 1][2];
        for (int i = 0; i <= k; ++i) {
            dp[i][0] = 0;
            dp[i][1] = -prices[0];
        }
        for (int i = 1; i < length; ++i) {
            for (int j = k; j > 0; --j) {
                //处理第k次买入
                dp[j - 1][1] = Math.max(dp[j - 1][1], dp[j - 1][0] - prices[i]);
                //处理第k次卖出
                dp[j][0] = Math.max(dp[j][0], dp[j - 1][1] + prices[i]);

            }
        }
        return dp[k][0];
    }
}
