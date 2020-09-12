package com.code.interview.meituan;

import java.util.Scanner;

/**
 * @author 俊语
 * @date 2020/9/6 10:50
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int a[] = new int[n + 1];
        int temp = 1;
        while (temp <= n) {
            a[temp] = scanner.nextInt();
            temp++;
        }
        int b[] = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            int tempMod = 0;
            for (int j = 1; j < i; ++j) {
                tempMod = i % j;
            }
            tempMod ^= (n - i) % 2 == 0 ? 0 : i;
            b[i] = a[i] ^ tempMod;
        }
        int res = b[1];
        for (int i = 2; i <= n; ++i) {
            res ^= b[i];
        }
        System.out.println(res);
    }
}
