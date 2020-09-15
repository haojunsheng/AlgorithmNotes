package com.code.leetcode.dp;

/**
 * 最长回文子序列
 * 给定一个字符串 s ，找到其中最长的回文子序列，并返回该序列的长度。可以假设 s 的最大长度为 1000 。
 * "bbbab" -》4
 * https://leetcode-cn.com/problems/longest-palindromic-subsequence/
 *
 * @author 俊语
 * @date 2020/9/13 13:28
 */
public class LongestPalindromeSubseq_516 {
    public static void main(String[] args) {
        String s = "bbbab";
        System.out.println(longestPalindromeSubseq(s));
    }

    /**
     * 在子串s[i..j]中，最⻓回文子序列的⻓度为dp[i][j],区间规划
     *
     * @param s
     * @return
     */
    public static int longestPalindromeSubseq(String s) {
        int length = s.length();
        if (length <= 0) {
            return 0;
        }
        int[][] dp = new int[length][length];
        // 初始化
        for (int i = 0; i < length; ++i) {
            dp[i][i] = 1;
        }
        for (int i = length - 1; i >= 0; --i) {
            for (int j = i + 1; j < length; ++j) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][length - 1];
    }
}
