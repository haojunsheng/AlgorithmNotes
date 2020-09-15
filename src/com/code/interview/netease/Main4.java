package com.code.interview.netease;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 俊语
 * @date 2020/9/12 16:04
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] boy = new int[10001];
        int[] girl = new int[10001];
        String[] str = scanner.nextLine().split(" ");
        for (int i = 0; i < str.length; ++i) {
            boy[i] = Integer.valueOf(str[i]);
        }
        String[] str2 = scanner.nextLine().split(" ");
        for (int i = 0; i < str2.length; ++i) {
            girl[i] = Integer.valueOf(str[i]);
        }
        int n = scanner.nextInt();
        int[][] map = new int[boy.length][girl.length];
        for (int i = 0; i < n; ++i) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            map[a][b] = 1;
        }
        System.out.println(getMaxNum(map));
    }

    private static int getMaxNum(int[][] map) {
        int count = 0;
        int[] link = new int[map[0].length];
        Arrays.fill(link, -1);
        for (int i = 0; i < map.length; ++i) {
            boolean[] used = new boolean[map[0].length];
            if (dfs(map, used, link, i)) {
                count++;
            }
        }
        return count;
    }

    private static boolean dfs(int[][] map, boolean[] used, int[] link, int start) {
        for (int i = 0; i < map[0].length; ++i) {
            if (used[i] == false && map[start][i] == 1) {
                used[i] = true;
                if (link[i] == -1 || dfs(map, used, link, link[i])) {
                    link[i] = start;
                    return true;
                }
            }
        }
        return false;
    }
}
