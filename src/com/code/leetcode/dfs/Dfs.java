package com.code.leetcode.dfs;

/**
 * @author 俊语
 * @date 2020/9/17 22:42
 */
public class Dfs {
    public static void main(String[] args) {
        System.out.println();
    }

    private boolean dfs(int maze[][], int x, int y, int endx, int endy) {
        if (!isSafe(maze, x, y) || maze[x][y] == -1) {
            return false;
        }
        // 第一步：判断是否找到了B（B[0]是B的横坐标，B[1]是纵坐标）
        if (x == endx && y == endy) {
            return true;
        }
        // 第二步：标记当前的点已经被访问过
        maze[x][y] = -1;
        boolean res;
        res = dfs(maze, x + 1, y, endx, endy) ||
                dfs(maze, x - 1, y, endx, endy) ||
                dfs(maze, x, y + 1, endx, endy) ||
                dfs(maze, x, y - 1, endx, endy);
        // 重新标记成可以走动的路
        maze[x][y] = 0;
        return res;
    }

    boolean isSafe(int maze[][], int i, int j) {
        return i >= 0 && i < maze.length && j >= 0 && j < maze[0].length;
    }
}
