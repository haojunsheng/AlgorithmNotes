package com.code.leetcode.array;

/**
 * 对角线遍历
 * 给定一个含有 M x N 个元素的矩阵（M 行，N 列），请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示。
 * 输入:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * <p>
 * 输出:  [1,2,4,7,5,3,6,8,9]
 */
public class FindDiagonalOrder_498 {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length <= 0) {
            return new int[]{};
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] result = new int[rows * cols];
        // 索引，遍历多少趟
        int index = 0, nums = 0;
        while (nums < rows + cols - 1) {
            // 奇数趟
            int x1 = (nums < rows) ? nums : (rows - 1);
            int y1 = nums - x1;
            while (x1 >= 0 && y1 < cols) {
                result[index++] = matrix[x1][y1];
                x1--;
                y1++;
            }
            nums++;
            if (nums >= rows + cols - 1) break;
            // 偶数趟
            int y2 = (nums < cols) ? nums : (cols - 1);
            int x2 = nums - y2;
            while (y2 >= 0 && x2 < rows) {
                result[index++] = matrix[x2][y2];
                x2++;
                y2--;
            }
            nums++;
        }
        return result;
    }
}
