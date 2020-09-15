package com.code.interview.netease;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 俊语
 * @date 2020/9/12 15:31
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        if (str.isEmpty()) {
            System.out.println(0);
        }
        int[] dp = new int[1 << 6];
        Arrays.fill(dp, -1);
        int res = 0, state = 0;
        dp[0] = 0;
        for (int i = 0; i < str.length(); ++i) {
            char ch = str.charAt(i);
            switch (ch) {
                case 'a':
                    state ^= (1 << 0);
                    break;
                case 'b':
                    state ^= (1 << 1);
                    break;
                case 'c':
                    state ^= (1 << 2);
                    break;
                case 'x':
                    state ^= (1 << 3);
                    break;
                case 'y':
                    state ^= (1 << 4);
                    break;
                case 'z':
                    state ^= (1 << 5);
                    break;
            }
            if (dp[state] >= 0) {
                res = Math.max(res, i + 1 - dp[state]);
            } else {
                dp[state] = i + 1;
            }
        }
        System.out.println(res);
    }
}
