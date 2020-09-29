package com.code.interview.pinduoduo;

import java.util.Scanner;

/**
 * @author 俊语
 * @date 2020/9/26 19:45
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        long[][] dp = new long[n + 1][m + 1];
        for (int i = 0; i <= n; ++i) {
            dp[i][0] = 1;
            dp[i][1] = 1;
        }
        for (int i = 0; i <= m; ++i) {
            dp[0][i] = 1;
            dp[1][i] = 1;
        }

        for (int i = 2; i <= n; ++i) {
            for (int j = 2; j <= m; ++j) {
                dp[i][j] = ((dp[i - 2][j - 2]%1000000007) * (dp[i - 2][2]%1000000007) * (dp[2][j - 2]%1000000007))%1000000007 + dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1];
            }
        }
        System.out.println(dp[n][m]%1000000007);
    }
}
