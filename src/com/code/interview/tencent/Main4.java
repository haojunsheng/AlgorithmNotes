package com.code.interview.tencent;

import java.util.Scanner;

/**
 * @author 俊语
 * @date 2020/8/23 21:36
 */
public class Main4 {
    static int[] arr = new int[5001];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 1; i <= n; ++i) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(helper(1, n, 0));
    }

    private static int helper(int left, int right, int curHeight) {
        if (left > right) {
            return 0;
        }
        int min = Integer.MAX_VALUE, index = -1;
        // 竖着刷
        int verSum = 0;

        for (int i = left; i <= right; ++i) {
            if (arr[i] < min) {
                min = arr[i];
                index = i;
            }
            if (arr[i] > curHeight) {
                verSum++;
            }
        }
        // 横着刷
        int horNum = min - curHeight;
        int nextHeight = min;
        int resLeft = helper(left, index - 1, nextHeight);
        int resRight = helper(index + 1, right, nextHeight);
        int res = Math.min(verSum, resLeft + resRight + horNum);
        return res;
    }
}
