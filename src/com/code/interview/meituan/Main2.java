package com.code.interview.meituan;

import java.util.Scanner;

/**
 * @author 俊语
 * @date 2020/9/6 10:28
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        char[] ch = s.toCharArray();
        int big = 0, small = 0;
        for (int i = 0; i < ch.length; ++i) {
            if (ch[i] >= 'A' && ch[i] <= 'Z') {
                big++;
            } else if (ch[i] >= 'a' & ch[i] <= 'z') {
                small++;
            }
        }
        int res = Math.abs(big - small) / 2;
        System.out.println(res);
    }
}
