package com.code.interview.xiaomi;

import java.util.Scanner;

/**
 * @author 俊语
 * @date 2020/9/8 19:03
 */
public class Main2 {
    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        Scanner scanner = new Scanner(System.in);
        String queryWord = scanner.nextLine();
        boolean res = false;
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if (queryWord.charAt(0) == board[i][j] && dfs(i, j, 0, queryWord, visited, board)) {
                    res = true;
                }
            }
        }
        System.out.println(res);
    }

    private static boolean dfs(int i, int j, int index, String queryWord, boolean[][] visited, char[][] board) {
        if (index == queryWord.length()) {
            return true;
        }

        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != queryWord.charAt(index) || visited[i][j]) {
            return false;
        }
        visited[i][j] = true;

        if (dfs(i + 1, j, index + 1, queryWord, visited, board)
                || dfs(i - 1, j, index + 1, queryWord, visited, board)
                || dfs(i, j + 1, index + 1, queryWord, visited, board)
                || dfs(i, j - 1, index + 1, queryWord, visited, board)) {
            return true;
        }
        visited[i][j] = false;
        return false;
    }
}
