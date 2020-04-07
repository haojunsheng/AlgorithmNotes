package com.code.offer.dp_greedy;

import java.util.Scanner;

/**
 * 给2个字符串s1和s2，将s1转成s2最少的转换次数，可以插入，删除，替换，跳过
 */
public class EditDistance {

    // 动态规划，自顶向下
    public int minDistanceTop(String s1, String s2) {
        int length1 = s1.length();
        int length2 = s2.length();
        if (length1 <= 0 || s1 == null || length2 <= 0 || s2 == null) {
            return -1;
        }
        return dp(s1, s2, length1 - 1, length2 - 1);
    }

    public int dp(String s1, String s2, int i, int j) {
        if (i == -1) {
            return j + 1;
        }
        if (j == -1) {
            return i + 1;
        }
        if (s1.charAt(i) == s2.charAt(j)) {
            return dp(s1, s2, i - 1, j - 1);
        } else {
            return 1 + min(dp(s1, s2, i - 1, j - 1), dp(s1, s2, i, j - 1), dp(s1, s2, i - 1, j));
        }
    }

    // 动态规划+自顶向下+备忘录
    int memo[][];

    public int minDistanceTopMemo(String s1, String s2) {
        int length1 = s1.length();
        int length2 = s2.length();
        if (length1 <= 0 || s1 == null || length2 <= 0 || s2 == null) {
            return -1;
        }
        memo = new int[length1][length2];
        return dpMemo(s1, s2, length1 - 1, length2 - 1);
    }

    public int dpMemo(String s1, String s2, int i, int j) {
        if (i == -1) {
            return j + 1;
        }
        if (j == -1) {
            return i + 1;
        }
        if (memo[i][j] != 0) {
            return memo[i][j];
        }
        if (s1.charAt(i) == s2.charAt(j)) {
            memo[i][j] = dp(s1, s2, i - 1, j - 1);
        } else {
            memo[i][j] = 1 + min(dp(s1, s2, i - 1, j - 1), dp(s1, s2, i, j - 1), dp(s1, s2, i - 1, j));
        }
        return memo[i][j];
    }

    // 动态规划，自底向上
    public int minDistance(String s1, String s2) {
        int length1 = s1.length();
        int length2 = s2.length();
        if (length1 <= 0 || s1 == null || length2 <= 0 || s2 == null) {
            return -1;
        }
        // dp[i][j]表示s1[i]和s2[j]之间的最小编辑距离
        // 找状态转移
        int dp[][] = new int[length1 + 1][length2 + 1];
        for (int i = 1; i <= length1; ++i) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= length2; ++j) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= length1; ++i) {
            for (int j = 1; j <= length2; ++j) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]);
                }
            }
        }
        // 储存着整个 s1 和 s2 的最小编辑距离
        return dp[length1][length2];
    }

    private int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    public static void main(String[] args) {
        EditDistance editDistance = new EditDistance();
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        System.out.println(editDistance.minDistanceTopMemo(s1, s2));
    }
}
