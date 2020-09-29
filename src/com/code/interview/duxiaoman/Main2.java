package com.code.interview.duxiaoman;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author 俊语
 * @date 2020/9/20 20:45
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- >= 0) {
            Node node = null;
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            char[][] maze = new char[n][m];
            for (int i = 0; i < n; ++i) {
                String temp = scanner.nextLine();
                for (int j = 0; j < m; ++i) {
                    maze[i][j] = temp.charAt(j);
                    if (maze[i][j] == '@') {
                        node = new Node(i, j);
                    }
                }
            }

            boolean[][] visited = new boolean[n][m];
            int[][] move = new int[4][2];
            move[0][0] = 0;
            move[0][1] = 1;
            move[1][0] = 0;
            move[1][1] = -1;
            move[2][0] = 1;
            move[2][1] = 0;
            move[3][0] = -1;
            move[3][1] = 0;
            int minStep = 0;
            PriorityQueue<Integer> list = new PriorityQueue<>();
            dfs(node, maze, visited, list, minStep, move);
            if (list.size() > 0) {
                System.out.println(list.poll());
            } else {
                System.out.println(-1);
            }
        }
    }

    private static void dfs(Node node, char[][] maze, boolean[][] visited, PriorityQueue<Integer> list, int minStep, int[][] move) {
        if (node.x <= 0 || node.x >= maze.length - 1 || node.y <= 0 || node.y >= maze[0].length - 1) {
            list.add(minStep);
            return;
        }
        for (int i = 0; i < 4; ++i) {
            node.x = node.x + move[i][0];
            node.y = node.y + move[i][1];
            if (node.x >= 0 && node.x < maze.length && node.y >= 0 && node.y < maze[0].length && !visited[node.x][node.y]) {
                visited[node.x][node.y] = true;
                if (maze[node.x][node.y] == '*') {
                    dfs(node, maze, visited, list, minStep + 1, move);
                } else if (maze[node.x][node.y] == '.') {
                    dfs(node, maze, visited, list, minStep, move);
                }

                visited[node.x][node.y] = false;
            }
            node.x -= move[i][0];
            node.y -= move[i][1];
        }
    }

    static class Node {
        int x = 0;
        int y = 0;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
