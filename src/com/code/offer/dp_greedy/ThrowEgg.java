package com.code.offer.dp_greedy;

import java.util.Scanner;

public class ThrowEgg {

    public int dp(int k, int n) {
        // 当鸡蛋数K为1时，显然只能线性扫描所有楼层
        if (k == 1) {
            return n;
        }
        // 当楼层数 N 等于 0 时，显然不需要扔鸡蛋
        if (n == 0) {
            return 0;
        }
        int res = 65535;//给res一个很大的值
        for (int i = 1; i <= n; ++i) {
            res = Math.min(res, 1 + Math.max(
                    dp(k, n - i),
                    dp(k - 1, i - 1)));
        }
        return res;
    }

    // 动态规划+自顶向下+备忘录
    int memo[][];

    public int superEggDrop(int k, int n) {
        memo = new int[k + 1][n + 1];
        return dpMemo(k, n);
    }

    private int dpMemo(int k, int n) {
        // 当鸡蛋数K为1时，显然只能线性扫描所有楼层
        if (k == 1) {
            return n;
        }
        // 当楼层数 N 等于 0 时，显然不需要扔鸡蛋
        if (n == 0) {
            return 0;
        }
        if (memo[k][n] != 0) {
            return memo[k][n];
        }
        int res = 65535;
        for (int i = 1; i <= n; ++i) {
            res = Math.min(res, Math.max(dpMemo(k, n - i), dpMemo(k - 1, i - 1)) + 1);
        }
        memo[k][n] = res;
        return res;
    }

    /**
     * @param k 鸡蛋数
     * @param n 楼层数
     * @return
     */
    public int throwEgg(int k, int n) {
        if (k <= 0 || n <= 0) {
            return -1;
        }
        int dp[][] = new int[k + 1][n + 1];
        for (int i = 1; i <= k; ++i) {
            for (int j = 1; j <= n; ++j) {
                dp[i][j] = j;
            }
        }

        for (int i = 2; i <= k; ++i) {
            for (int m = 1; m <= n; ++m) {
                for (int j = 1; j < m; ++j) {
                    //扔鸡蛋的楼层从1到m枚举一遍，如果当前算出的尝试次数小于上一次算出的尝试次数，则取代上一次的尝试次数。
                    dp[i][m] = Math.min(dp[i][m], 1 + Math.max(dp[i][m - j], dp[i - 1][j - 1]));
                }
            }
        }
        return dp[k][n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        int n = scanner.nextInt();
        ThrowEgg throwEgg = new ThrowEgg();
        System.out.println(throwEgg.throwEgg(k, n));
    }
}