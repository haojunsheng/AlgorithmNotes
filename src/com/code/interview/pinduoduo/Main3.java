package com.code.interview.pinduoduo;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 俊语
 * @date 2020/9/26 19:31
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int K = scanner.nextInt();
        while (--K >= 0) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; ++i) {
                arr[i] = scanner.nextInt();
            }
            int[][] uvArr = new int[n - 1][2];
            for (int i = 0; i < n - 1; ++i) {
                for (int j = 0; j < 2; ++j) {
                    uvArr[i][j] = scanner.nextInt();
                }
            }

            System.out.println(-1);
        }
    }
}
