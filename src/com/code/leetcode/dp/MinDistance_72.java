package com.code.leetcode.dp;

/**
 * 编辑距离
 * https://leetcode-cn.com/problems/edit-distance/
 * 输入：word1 = "horse", word2 = "ros"
 * 输出：3
 * 解释：
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 *
 * @author 俊语
 * @date 2020/9/13 14:35
 */
public class MinDistance_72 {
    public static void main(String[] args) {
        String word1 = "horse", word2 = "ros";
        System.out.println(minDistance(word1, word2));
    }

    /**
     * @param word1
     * @param word2
     * @return
     */
    public static int minDistance(String word1, String word2) {
        int length1 = word1.length(), length2 = word2.length();
        if (length1 <= 0) {
            return length2;
        }
        if (length2 <= 0) {
            return length1;
        }
        int[][] dp = new int[length1 + 1][length2 + 1];
        // base case
        for (int i = 1; i <= length1; ++i) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= length2; ++i) {
            dp[0][i] = i;
        }
        // 递推关系式
        for (int i = 1; i <= length1; ++i) {
            for (int j = 1; j <= length2; ++j) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // 分别是替换，插入和删除三种情况
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                }
            }
        }
        return dp[length1][length2];
    }
}
