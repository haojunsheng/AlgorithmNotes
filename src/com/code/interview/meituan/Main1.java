package com.code.interview.meituan;

import java.util.Scanner;

/**
 * @author 俊语
 * @date 2020/9/6 10:09
 */
public class Main1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[] res = new int[100002];
        int n = scanner.nextInt();
        int p = scanner.nextInt();
        int q = scanner.nextInt();
        int pTemp = p;
        while (pTemp-- >= 1) {
            res[scanner.nextInt()] = 1;
        }
        int qTemp = q;
        while (qTemp-- >= 1) {
            int temp = scanner.nextInt();
            if (res[temp] == 1) {
                res[temp] = 3;
            } else {
                res[temp] = 2;
            }
        }
        int pRes = 0, qRes = 0, pqRes = 0;
        for (int i = 1; i < res.length; ++i) {
            if (res[i] == 1) {
                pRes++;
            } else if (res[i] == 2) {
                qRes++;
            } else if (res[i] == 3) {
                pqRes++;
            }
        }
        System.out.println(pRes + " " + qRes + " " + pqRes);
    }
}
