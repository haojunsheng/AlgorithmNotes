package com.code.offer.dp_greedy;

/**
 * 礼物的最大价值
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
 * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
 * 给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 * <p>
 * f(i,j)表示到达(i,j)时能拿到礼物总和的最大值
 * 递推公式f(i,j)=max{f(i-1,j),f(i,j-1)}+gift(i,j)
 * https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof/
 */
public class MaxValue_47 {
    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(maxValue(grid));
    }

    /**
     * @param grid
     * @return
     */
    public static int maxValue(int[][] grid) {
        if (grid.length <= 0) {
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        // dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
        int[][] dp = new int[rows][cols];
        // base case
        dp[0][0] = grid[0][0];
        for (int i = 1; i < rows; ++i) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < cols; ++i) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < rows; ++i) {
            for (int j = 1; j < cols; ++j) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[rows - 1][cols - 1];
    }
}