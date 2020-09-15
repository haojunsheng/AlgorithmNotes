package com.code.interview.netease;

import java.util.Scanner;

/**
 * @author 俊语
 * @date 2020/9/12 15:53
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] line = scanner.nextLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int k = Integer.parseInt(line[1]);
        int[][] path = new int[n][n];
        String[] str = scanner.nextLine().split(" ");
        for (int i = 0; i < str.length; ++i) {
            path[i + 1][Integer.parseInt(str[i])] = 1;
            path[Integer.parseInt(str[i])][i + 1] = 1;
        }
        boolean[] temp = new boolean[n];
        temp[0] = true;
        int res = Integer.MAX_VALUE - 1;
        res = Math.min(helper(path, temp, 0, n, 1, 0, res) + 1, k + 1);
        System.out.println(res);
    }

    private static int helper(int[][] path, boolean[] temp, int curPos, int n, int count, int cost, int res) {
        if (count == n && path[curPos][0] > 0) {

            res = Math.min(res, cost + path[curPos][0]);
            return res;
        }
        for (int i = 0; i < n; ++i) {
            if (temp[i] == false && path[curPos][i] > 0) {
                temp[i] = true;
                res = helper(path, temp, i, n, count + 1, cost + path[curPos][i], res);
                temp[i] = false;
            }
        }
        return res;
    }
}
