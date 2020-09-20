package com.code.leetcode.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 俊语
 * @date 2020/9/17 23:06
 */
public class Bfs {
    public static void main(String[] args) {

    }

    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, -1, 0, 1};

    private void bfs(int[][] maze, int x, int y, int endx, int endy) {
        // 创建一个队列queue，将起始点A加入队列中
        Queue<Integer[]> queue = new LinkedList<>();
        queue.add(new Integer[]{x, y});

        // 只要队列不为空就一直循环下去
        while (!queue.isEmpty()) {
            // 从队列的头取出当前点
            Integer[] pos = queue.poll();
            x = pos[0];
            y = pos[1];

            // 从四个方向进行BFS
            for (int d = 0; d < 4; d++) {
                int i = x + dx[d], j = y + dy[d];

                if (isSafe(maze, i, j) && maze[i][j] != -1) {
                    // 记录步数（标记访问过）
                    maze[i][j] = maze[x][y] + 1;
                    // 然后添加到队列中
                    queue.add(new Integer[]{i, j});
                    // 如果发现了目的地就返回
                    if (i == endx && j == endy) {
                        return;
                    }
                }
            }
        }

    }

    boolean isSafe(int maze[][], int i, int j) {
        return i >= 0 && i < maze.length && j >= 0 && j < maze[0].length;
    }
}
