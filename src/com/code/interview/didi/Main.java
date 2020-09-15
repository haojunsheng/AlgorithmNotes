package com.code.interview.didi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author 俊语
 * @date 2020/9/13 20:22
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- >= 0) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int k = scanner.nextInt();
            int[][] arr = new int[n + 1][n + 1];
            for (int i = 0; i < m; ++i) {
                int temp1 = scanner.nextInt();
                int temp2 = scanner.nextInt();
                int temp3 = scanner.nextInt();
                arr[temp1][temp2] = temp3;
            }
            for (int i = 0; i <= n; ++i) {
                arr[i][i] = -1;
            }
            List<Integer> list = new ArrayList<>();
            list.add(0);
            int begin = 0, end = 0, weight;
            int[] parent = new int[arr.length];
            Arrays.fill(parent, -1);
            while (list.size() < arr.length) {
                weight = Integer.MAX_VALUE;
                for (int row : list) {
                    for (int i = 0; i < arr.length; ++i) {
                        if (!list.contains(i)) {
                            if (i >= row + 1) {
                                if (arr[row][i] < 0 && arr[row][i] < weight) {
                                    begin = row;
                                    end = i;
                                    weight = arr[i][row];
                                }
                            } else if (i <= row - 1) {
                                if (arr[i][row] > 0 && arr[i][row] < weight) {
                                    begin = row;
                                    end = i;
                                    weight = arr[i][row];
                                }
                            }
                        }
                    }
                }
                list.add(end);
                parent[end] = begin;
            }
            System.out.println(Arrays.toString(parent));
        }
    }
}
