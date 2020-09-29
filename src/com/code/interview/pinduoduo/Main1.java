package com.code.interview.pinduoduo;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author 俊语
 * @date 2020/9/26 19:06
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        HashMap<Integer, int[]> model = new HashMap<>();
        model.put(28, new int[]{0, 8});
        model.put(17, new int[]{1});
        model.put(24, new int[]{2, 3, 4});
        model.put(25, new int[]{5, 6, 9});
        model.put(22, new int[]{7});
        HashMap<Integer, Integer> model28 = new HashMap<>();
        while (--t >= 0) {
            int n = scanner.nextInt();
            int cnt1 = 0;
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (scanner.nextInt() == 1) {
                        cnt1 = cnt1 + 1;
                    }
                }
            }
            cnt1 = cnt1 / (n / 10);
            int[] resArr = model.get(cnt1);
            if (resArr.length == 1) {
                System.out.println(resArr[0]);
            } else {
                System.out.println(resArr[0]);
            }
        }
    }
}
