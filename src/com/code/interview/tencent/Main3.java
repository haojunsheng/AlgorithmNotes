package com.code.interview.tencent;

import java.util.Scanner;

/**
 * @author 俊语
 * @date 2020/8/23 21:04
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; ++i) {
            long n = scanner.nextLong();
            System.out.println(getRes(n));
        }
    }

    private static long getRes(long n) {
        long res = 0;
        for (long i = 1; i < n / 2; ++i) {
            long temp = helperSum(i) + helperSum(n - i);
            res = Math.max(res, temp);
        }
        return res;
    }

    private static long helperSum(long a) {
        long ans = 0;
        while (a != 0) {
            ans += a % 10;
            a = a / 10;
        }
        return ans;
    }
}
