package com.code.interview;

import java.util.Scanner;

/**
 * 阿里
 * 1-10 10种牌，每种牌4张，可以单张，对子，或者5张的顺子，问最少几次打完
 */
public class PlayGame {
    private static int goBackSolver(int[] arr, int num) {
        int sum = 0;
        if (num <= 5 && arr[num] >= 1 && arr[num + 1] >= 1 && arr[num + 2] >= 1 && arr[num + 3] >= 1 && arr[num + 4] >= 1) {
            arr[num]--;
            arr[num + 1]--;
            arr[num + 2]--;
            arr[num + 3]--;
            arr[num + 4]--;
            sum++;
        }
        if (num <= 7 && arr[num] >= 2 && arr[num + 1] >= 2 && arr[num + 2] >= 2) {
            arr[num] -= 2;
            arr[num + 1] -= 2;
            arr[num + 2] -= 2;
            sum++;
        }
        if (arr[num] >= 2) {
            arr[num] -= 2;
            sum++;
        }
        if (arr[num] == 1) {
            arr[num]--;
            sum++;
        }
        if (num <= 8) {
            sum = sum + goBackSolver(arr, num + 1);
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(PlayGame.goBackSolver(arr, 0));
    }
}