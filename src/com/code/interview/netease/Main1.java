package com.code.interview.netease;

import java.util.Scanner;

/**
 * @author 俊语
 * @date 2020/9/12 15:06
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[][] node = new int[m + 1][3];
        for (int i = 1; i <= n; ++i) {
            int temp1 = scanner.nextInt();
            int child = scanner.next().equals("left") ? 1 : 2;
            int temp2 = scanner.nextInt();
            node[temp1][child] = temp2;
            node[temp2][0] = temp1;
        }
        int count = 0;
        for (int i = 1; i <= m; ++i) {
            if (node[i][1] == 0 && node[i][2] == 0) {
                int parent = node[i][0];
                int left = node[parent][1];
                int right = node[parent][2];
                if (node[left][1] == 0 && node[left][2] == 0&& node[right][1] == 0&& node[right][2] == 0) {
                    count++;
                }
            }
        }
        System.out.println(count / 2);
    }
}
