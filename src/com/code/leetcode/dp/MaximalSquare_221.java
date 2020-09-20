package com.code.leetcode.dp;

/**
 * 最大正方形
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 * 输入:
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * 输出: 4
 * https://leetcode-cn.com/problems/maximal-square/
 *
 * @author 俊语
 * @date 2020/9/20 09:52
 */
public class MaximalSquare_221 {
    public static void main(String[] args) {
        char[][] matrix = {{'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}};
        System.out.println(maximalSquare(matrix));
    }

    /**
     * @param matrix
     * @return
     */
    public static int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return 0;
        }

        int height = matrix.length;
        int width = matrix[0].length;
        int maxSide = 0;

        // dp[i][j]以matrix[i][j]为右下角的正方形的最大边长
        int[][] dp = new int[height + 1][width + 1];

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                if (matrix[row][col] == '1') {
                    // 由最短的所决定
                    dp[row + 1][col + 1] = Math.min(Math.min(dp[row + 1][col], dp[row][col + 1]), dp[row][col]) + 1;
                    maxSide = Math.max(maxSide, dp[row + 1][col + 1]);
                }
            }
        }
        return maxSide * maxSide;
    }
}
