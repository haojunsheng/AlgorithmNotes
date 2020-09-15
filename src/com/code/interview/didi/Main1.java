package com.code.interview.didi;

import java.util.Scanner;

/**
 * @author 俊语
 * @date 2020/9/13 19:39
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String str = scanner.nextLine();
        int leftTemp = 0;
        int temp = n;
        StringBuilder res = new StringBuilder();
        while (temp <= str.length()) {
            res.append(reverse(str.substring(leftTemp, temp)));
            leftTemp = temp;
            temp += n;
        }
        if (temp - n < str.length()) {
            res.append(reverse(str.substring(temp - n, str.length())));
        }
        System.out.println(res);
    }

    private static String reverse(String str) {
        char[] s = str.toCharArray();
        int i = 0, j = str.length() - 1;
        while (i < j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
        return new String(s);
    }
}
