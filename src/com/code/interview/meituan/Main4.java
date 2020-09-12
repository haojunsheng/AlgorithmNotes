package com.code.interview.meituan;

import java.util.Scanner;

/**
 * @author 俊语
 * @date 2020/9/6 10:40
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int a[] = new int[n];
            int tempN = 0;
            while (tempN < n) {
                a[tempN] = scanner.nextInt();
            }
            System.out.println("YES");
        }
    }
}
