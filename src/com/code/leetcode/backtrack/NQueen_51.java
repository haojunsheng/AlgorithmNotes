package com.code.leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个 N×N 的棋盘，让你放置 N 个 皇后，使得它们不能互相攻击。
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * 皇后可以攻击同一行、同一列、左上左下右上右下四个方向的任意单位。
 * <p>
 * 输入：4
 * 输出：[
 * [".Q..",  // 解法 1
 * "...Q",
 * "Q...",
 * "..Q."],
 * <p>
 * ["..Q.",  // 解法 2
 * "Q...",
 * "...Q",
 * ".Q.."]
 * ]
 * https://leetcode-cn.com/problems/n-queens/
 */

public class NQueen_51 {
    List<List<String>> res = new ArrayList<>();

    List<List<String>> solveNQueens(int n) {
        // 默认0表示空，1表示皇后
        int[][] board = new int[n][n];
        dfs(board, 0);
        return res;
    }

    /**
     * 路径:board 中小于 row 的那些行都已经成功放置了皇后
     * 选择列表:第 row 行的所有列都是放置皇后的选择
     * 结束条件:row 超过 board 的最后一行
     *
     * @param board
     * @param row
     */
    private void dfs(int[][] board, int row) {
        if (row == board.length) {
            res.add(transfer(board, board.length));
            return;
        }
        int cols = board[0].length;
        for (int col = 0; col < cols; ++col) {
            if (isValid(board, row, col)) {
                //做选择
                board[row][col] = 1;
                //递归
                dfs(board, row + 1);
                // 撤销选择
                board[row][col] = 0;
            }

        }
    }

    /**
     * 遍历当前列上是否已经有皇后；遍历当前左上至右下对角线上是否已经有皇后；
     * 遍历当前右上至左下对角线上是否已经有皇后;这些遍历只需要检测小于当前的行，因为大于当前的行还没有填写到一定没有皇后。
     *
     * @param board
     * @param row
     * @param col
     * @return
     */
    private boolean isValid(int[][] board, int row, int col) {
        // 检查列上是否有皇后
        for (int i = 0; i < row; ++i) {
            if (board[i][col] == 1) {
                return false;
            }
        }
        //检查左上至右下对角线有无皇后
        for (int i = col - 1; i >= 0; i--) {
            if (i + row - col < 0) {
                break;
            }
            if (board[i + row - col][i] == 1) {
                return false;
            }
        }
        //检查右上至左下对角线有无皇后
        for (int i = col + 1; i < board.length; i++) {
            if (row + col - i < 0) {
                break;
            }
            if (board[row + col - i][i] == 1) {
                return false;
            }
        }
        return true;
    }

    /**
     * 将int类型棋盘转换成输出格式
     */
    private ArrayList<String> transfer(int[][] board, int n) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder temp = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) {
                    temp.append('.');
                } else {
                    temp.append('Q');
                }
            }
            list.add(temp.toString());
        }
        return list;
    }
}