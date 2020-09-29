package com.code.interview.duxiaoman;

import java.util.Scanner;

/**
 * @author 俊语
 * @date 2020/9/20 20:38
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.next();
        String s2 = scanner.next();
        char[] have = new char[26];
        for (char ch : s1.toCharArray()) {
            have[ch-'A']++;
        }
        int res = 0;
        for (char ch : s2.toCharArray()) {
            if (have[ch-'A'] != 0) {
                res++;
                have[ch-'A']--;
            }
        }
        System.out.println(res);
    }
}
