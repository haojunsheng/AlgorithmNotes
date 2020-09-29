package com.code.interview.vmware;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 俊语
 * @date 2020/9/26 08:40
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        long mod = scanner.nextLong();
        long[] arrn = new long[n];
        long[] arrm = new long[m];
        for (int i = 0; i < n; ++i) {
            arrn[i] = scanner.nextLong();
        }
        for (int i = 0; i < m; ++i) {
            arrm[i] = scanner.nextLong();
        }
        Arrays.sort(arrn);
        Arrays.sort(arrm);
        long res = Long.MAX_VALUE;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                res=Math.min(res,(arrn[i]+arrm[j])%mod);
            }
        }
        System.out.println(res);
    }
}
