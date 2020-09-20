package com.code.offer.goback;

/**
 * 机器人运动范围
 * 地上有一个m行和n列的方格。
 * 一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。
 * 请问该机器人能够达到多少个格子？
 */
public class RobotMove_13 {

    /**
     * 回溯算法
     * 返回机器人能到达的格子数
     *
     * @param threshold 阈值
     * @param rows      矩阵行数
     * @param cols      矩阵列数
     * @return
     */
    public int movingCount(int threshold, int rows, int cols) {
        //参数校验
        if (threshold < 0 || rows <= 0 || cols <= 0) {
            return 0;
        }

        //初始化访问标识数组
        boolean[] visited = new boolean[rows * cols];
        for (int i = 0; i < rows * cols; i++) {
            visited[i] = false;
        }

        int count = dfs(threshold, rows, cols, 0, 0, visited);
        return count;
    }


    // 判断从第row行、第col列出发可以到达的格子数为 1+ 四个方向
    public int dfs(int threshold, int rows, int cols, int row, int col, boolean[] visited) {
        int count = 0;
        if (check(threshold, rows, cols, row, col, visited)) {
            // 做选择
            visited[row * cols + col] = true;
            // 加入路径
            count = 1 + dfs(threshold, rows, cols, row - 1, col, visited)
                    + dfs(threshold, rows, cols, row, col - 1, visited)
                    + dfs(threshold, rows, cols, row + 1, col, visited)
                    + dfs(threshold, rows, cols, row, col + 1, visited);
        }
        return count;
    }

    // 检查机器人能否到达该格子
    public boolean check(int threshold, int rows, int cols, int row, int col, boolean[] visited) {
        if (row >= 0 && row < rows && col >= 0 && col < cols
                && getDigitSum(row) + getDigitSum(col) <= threshold
                && !visited[row * cols + col]) {
            return true;
        }
        return false;
    }

    // 求一个数的各位数和
    public int getDigitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        RobotMove_13 robot = new RobotMove_13();
        int count = robot.movingCount(4, 3, 3);
        System.out.println(count);
    }
}