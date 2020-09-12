package com.code.leetcode.dp;

import java.util.Scanner;

/**
 * 0-1背包问题
 * 给你一个可装载重量为`W`的背包和`N`个物品，每个物品有重量和价值两个属性。
 * 其中第`i`个物品的重量为`wt[i]`，价值为`val[i]`，现在让你用这个背包装物品，最多能装的价值是多少？
 *
 * @author 俊语
 * @date 2020/9/10 20:57
 */
public class ZeroOnePack {
    public int zeroOnePack(int W, int N, int[] wt, int[] val) {
        int[][] dp = new int[N + 1][W + 1];

        for (int i = 1; i <= N; ++i) {
            for (int j = 1; j <= W; ++j) {
                if (j - wt[i - 1] <= 0) {
                    // 只可以选择不装
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j],//不装
                            dp[i - 1][j - wt[i - 1]] + val[i - 1]);//如果装入第i个，剩余重量j-wt[i-1]限制下能装的最大价值
                }
            }
        }
        return dp[N][W];
    }

    public static void main(String[] args) {
        ZeroOnePack zeroOnePack = new ZeroOnePack();
        Scanner scanner = new Scanner(System.in);
        int V = scanner.nextInt();
        int N = scanner.nextInt();
        int[] wt = new int[N];
        int[] val = new int[N];
        for (int i = 0; i < N; ++i) {
            wt[i] = scanner.nextInt();
            val[i] = scanner.nextInt();
        }

//        wt[0] = 3;
//        wt[1] = 2;
//        wt[2] = 4;
//        val[0] = 5;
//        val[1] = 4;
//        val[2] = 2;
        System.out.println(zeroOnePack.zeroOnePack(V, N, wt, val));
    }
}
