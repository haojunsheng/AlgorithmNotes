package com.code.interview.vmware;

import java.util.Scanner;

/**
 * @author 俊语
 * @date 2020/9/26 09:35
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        long nowSum = 0;
        while (--n >= 0) {
            nowSum += scanner.nextInt();
        }
        nowSum= Math.abs(nowSum);
        long mod = nowSum % x;
        long res = nowSum/x;
        res = mod != 0 ? res + 1 : res;
        System.out.println(res);
    }
}
