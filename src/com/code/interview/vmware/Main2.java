package com.code.interview.vmware;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author 俊语
 * @date 2020/9/26 08:59
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        long[] arr = new long[n + 1];
        while (--m >= 0) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            int v = scanner.nextInt();
            solution(arr, l, r, v);
        }
        for (int i = 1; i <= n; ++i) {
            System.out.print(arr[i] + " ");
        }
    }

    private static void solution(long[] arr, int l, int r, int v) {
        for (int i = l; i <= r; ++i) {
            long temp = helper(i, l, v);
            arr[i] = (arr[i] % 998244353 + temp) % 998244353;
        }
    }

    private static long helper(int i, int l, int v) {
        return combi(i - l + v, v);
    }

    private static long combi(int n, int k) {
        long a = 1, b = 1;
        if (k > n / 2) {
            k = n - k;
        }
        for (int i = 1; i <= k; ++i) {
            a = (a * (n + 1 - i)) % 998244353;
            b = (b * i) % 998244353;
        }
        return a / b;
    }
}
