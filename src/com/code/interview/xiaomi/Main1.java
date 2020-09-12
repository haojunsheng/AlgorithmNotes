package com.code.interview.xiaomi;

import java.util.Scanner;

/**
 * @author 俊语
 * @date 2020/9/8 17:44
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder res = new StringBuilder();
        // arr[0]=true，表示包含数字，arr[1]=true，表示包含符号，arr[2]=true，表示大写字母，arr[3]=true，表示小写字母
        boolean[] arr = new boolean[4];
        while (scanner.hasNext()) {
            String password = scanner.next();
            if (password.length() < 8 || password.length() > 120) {
                res.append(1 + "\n");
                continue;
            }
            char[] passChar = password.toCharArray();
            for (char ch : passChar) {
                if (Character.isDigit(ch)) {
                    arr[0] = true;
                } else if (Character.isUpperCase(ch)) {
                    arr[2] = true;
                } else if (Character.isLowerCase(ch)) {
                    arr[3] = true;
                } else if (ch < 128) {
                    arr[1] = true;
                }
            }
            int i = 0;
            for (i = 0; i < arr.length; ++i) {
                if (arr[i] == false) {
                    res.append(2 + "\n");
                    break;
                }
            }
            if (i == 4) {
                res.append(0 + "\n");
            }
            System.out.print(res);
        }
    }
}
