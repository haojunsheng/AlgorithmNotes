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

    /**
     * DFS + Memoization
     * <p>
     * Traverse all points in matrix, use every point as starting point to do dfs traversal. DFS function returns max increasing
     * path after comparing four max return distance from four directions.
     *
     * @param cache: cache[i][j] represents longest increasing path starts from point matrix[i][j]
     * @param prev: previous value used by DFS traversal, to compare whether current value is greater than previous value
     */
    final int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }

        int result = 0;
        int n = matrix.length, m = matrix[0].length;
        int[][] cache = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int curLen = dfs(matrix, cache, i, j, matrix[i][j]);
                result = Math.max(result, curLen);
            }
        }
        return result;
    }

    public int dfs(int[][] matrix, int[][] cache, int x, int y, int curPoint) {
        if (cache[x][y] != 0) {
            return cache[x][y];
        }

        // initialize max distance as 1 since the path includes starting point itself
        int max = 1;
        for (int[] dir : dirs) {
            int dx = x + dir[0];
            int dy = y + dir[1];

            // if next point is out of bound or next point current point is greater than or equal to next point
            if (dx < 0 || dx > matrix.length - 1 || dy < 0 || dy > matrix[0].length - 1 || curPoint >= matrix[dx][dy]) {
                continue;
            }

            // if next point is a valid point, add curLen by 1 and continue DFS traversal
            int curLen = 1 + dfs(matrix, cache, dx, dy, matrix[dx][dy]);
            max = Math.max(max, curLen);
        }
        // update max increasing path value starting from current point in cache
        cache[x][y] = max;
        return max;
    }
}
