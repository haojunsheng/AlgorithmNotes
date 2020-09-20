package com.code.interview.jd;

import java.util.Scanner;

/**
 * @author 俊语
 * @date 2020/9/17 20:10
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int group = scanner.nextInt();
        while (--group >= 0) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[][] arr = new int[n][m];
            int startX = 0, startY = 0, endX = 0, endY = 0;
            for (int i = 0; i < n; ++i) {
                String str = scanner.next();
                for (int j = 0; j < m; ++j) {
                    if (str.charAt(j) == '.') {
                        arr[i][j] = 0;
                    } else if (str.charAt(j) == '#') {
                        arr[i][j] = -1;
                    } else if (str.charAt(j) == 'S') {
                        startX = i;
                        startY = j;
                    } else if (str.charAt(j) == 'E') {
                        endX = i;
                        endY = j;
                    }
                }
            }
            System.out.println(dfs(arr, startX, startY, endX, endY));
        }
    }

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static boolean dfs(int[][] maze, int x, int y, int endX, int endY) {
        if (endX == x && endY == y) {
            return true;
        }

        maze[x][y] = -1;
        for (int d = 0; d < 4; d++) {
            int i = x + dx[d], j = y + dy[d];
            if (isSafe(maze, i, j) && dfs(maze, i, j, endX, endY)) {
                return true;
            }
        }
        maze[x][y] = 0;
        return false;
    }

    private static boolean isSafe(int[][] maze, int i, int j) {
        if (i >= 0 && i < maze.length && j >= 0 && j < maze[0].length && maze[i][j] != -1) {
            return true;
        }
        return false;
    }
}
