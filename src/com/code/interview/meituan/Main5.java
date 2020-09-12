package com.code.interview.meituan;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author 俊语
 * @date 2020/9/6 11:20
 */
public class Main5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int a[] = new int[m];
        HashMap<Integer, Boolean> hashMap = new HashMap<>();
        for (int i = 0; i < m; ++i) {
            a[i] = scanner.nextInt();
            hashMap.put(a[i], false);
        }
        for (int j = m - 1; j >= 0; --j) {
            if (hashMap.get(a[j]) == false) {
                System.out.println(a[j]);
                hashMap.put(a[j], true);
            }
        }
    }
}
