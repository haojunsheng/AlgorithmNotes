package com.code.offer.dp_greedy;

import java.util.Scanner;

// 求两个字符串的 LCS ⻓度
// 输入: str1 = "abcde", str2 = "ace" 输出: 3
//解释: 最⻓公共子序列是 "ace"，它的⻓度是 3
public class LCS {
    public static int longestCommonSubsequence(String s1, String s2) {
        if (s1 == null || s1.length() <= 0 || s2 == null || s2.length() <= 0) {
            return -1;
        }
        int length1 = s1.length();
        int length2 = s2.length();
        // dp[i][j]:对于 s1[1..i] 和 s2[1..j] ， 它们的LCS⻓度是 dp[i][j] 。
        int dp[][] = new int[length1 + 1][length2 + 1];
        //定义一个二维数组 dp 用来存储最长公共子序列的长度，其中 dp[i][j] 表示 S1 的前 i 个字符与 S2 的前 j 个字符最长公共子序列的长度。考虑 S1i 与 S2j 值是否相等，分为两种情况：
        //当 S1i==S2j 时，那么就能在 S1 的前 i-1 个字符与 S2 的前 j-1 个字符最长公共子序列的基础上再加上 S1i 这个值，最长公共子序列长度加 1，即 dp[i][j] = dp[i-1][j-1] + 1。
        //当 S1i != S2j 时，此时最长公共子序列为 S1 的前 i-1 个字符和 S2 的前 j 个字符最长公共子序列，或者 S1 的前 i 个字符和 S2 的前 j-1 个字符最长公共子序列，取它们的最大者，即 dp[i][j] = max{ dp[i-1][j], dp[i][j-1] }。
        for (int i = 1; i <= length1; ++i) {
            for (int j = 1; j <= length2; ++j) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[length1][length2];
    }

    public static void main(String[] args) {
        // 记得输入输出怎么写
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        System.out.println(longestCommonSubsequence(s1,s2));
    }
}
