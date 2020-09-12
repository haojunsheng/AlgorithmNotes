package com.code.interview.tencent;

import java.util.Scanner;

/**
 * @author 俊语
 * @date 2020/8/23 20:36
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int k = scanner.nextInt();
        int[] arr = new int[26];
        for (char ch : s.toCharArray()) {
            arr[ch - 97] += 1;
        }
        System.out.println(printRes(arr, k));
    }

    //index 表示第几个字符
    private static StringBuilder printRes(int[] arr, int k) {
        int cur = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < arr.length; ++i) {
            while (arr[i] != 0 && cur < k) {
                arr[i]--;
                cur++;
                stringBuilder.append((char) ('a' + i));
            }
            if (cur == k) {
                break;
            }
        }
        return stringBuilder;
    }
}
