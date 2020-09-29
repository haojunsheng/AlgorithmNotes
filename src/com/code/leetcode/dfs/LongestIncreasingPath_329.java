package com.code.leetcode.dfs;

/**
 * 矩阵中的最长递增路径
 * 给定一个整数矩阵，找出最长递增路径的长度。对于每个单元格，你可以往上，下，左，右四个方向移动。
 * <p>
 * 输入: nums =
 * [
 * [9,9,4],
 * [6,6,8],
 * [2,1,1]
 * ]
 * 输出: 4，解释: 最长递增路径为 [1, 2, 6, 9]。
 * <p>
 * 输入: nums =
 * [
 * [3,4,5],
 * [3,2,6],
 * [2,2,1]
 * ]
 * 输出: 4，解释: 最长递增路径是 [3, 4, 5, 6]。注意不允许在对角线方向上移动。
 * https://leetcode-cn.com/problems/longest-increasing-path-in-a-matrix/
 *
 * @author 俊语
 * @date 2020/9/15 23:40
 */
public class LongestIncreasingPath_329 {
    public static void main(String[] args) {
        LongestIncreasingPath_329 longestIncreasingPath329 = new LongestIncreasingPath_329();
        int[][] matrix = {{9, 9, 4}, {6, 6, 8}, {2, 1, 1}};
        System.out.println(longestIncreasingPath329.longestIncreasingPath(matrix));
    }

    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int[][] memo;

    /**
     * dfs+递归化搜索
     * 用矩阵中的每个点当做dfs的起点，dfs返回四个方向的最大增长路径
     *
     * @param matrix
     * @return
     */
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }

        int result = 0;
        int n = matrix.length, m = matrix[0].length;
        // memo[i][j]表示以matrix[i][j]为起点的最长增长路径
        memo = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int curLen = dfs(matrix, i, j);
                result = Math.max(result, curLen);
            }
        }
        return result;
    }

    /**
     * @param matrix
     * @param x
     * @param y
     * @return
     */
    public int dfs(int[][] matrix, int x, int y) {
        if (memo[x][y] != 0) {
            return memo[x][y];
        }

        // 路径至少为1，因为会包含自己
        int max = 1;
        for (int[] dir : dirs) {
            int dx = x + dir[0];
            int dy = y + dir[1];

            // 越界,下一个点必须大于当前的点
            boolean isValid = dx >= 0 && dx < matrix.length && dy >= 0 && dy < matrix[0].length && matrix[x][y] < matrix[dx][dy];
            if (isValid) {
                // 四个方向选一个最大的
                max = Math.max(max, 1 + dfs(matrix, dx, dy));
            }
        }
        // 记录max
        memo[x][y] = max;
        return max;
    }
}
