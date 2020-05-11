package com.code.leetcode.array_string;

/**
 * 旋转图像
 * 给定一个 n × n 的二维矩阵表示一个图像。将图像顺时针旋转 90 度。
 * <p>
 * 示例 1:
 * 给定 matrix =
 * [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]
 * ],
 * 原地旋转输入矩阵，使其变为:
 * [
 * [7,4,1],
 * [8,5,2],
 * [9,6,3]
 * ]
 * 示例 2:
 * 给定 matrix =
 * [
 * [ 5, 1, 9,11],
 * [ 2, 4, 8,10],
 * [13, 3, 6, 7],
 * [15,14,12,16]
 * ],
 * 原地旋转输入矩阵，使其变为:
 * [
 * [15,13, 2, 5],
 * [14, 3, 4, 1],
 * [12, 6, 8, 9],
 * [16, 7,10,11]
 * ]
 */
public class Rotate_48 {
    public void rotate(int[][] matrix) {
        int length = matrix.length;
        if (matrix == null || matrix.length != matrix[0].length) {
            return;
        }
        //转置整个矩阵
        for (int i = 0; i < length; ++i) {
            for (int j = i; j < length; ++j) {
                int temp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
        // 反转每一行
        for (int i = 0; i < length; ++i) {
            for (int j = 0; j < length / 2; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][length - j - 1];
                matrix[i][length - j - 1] = temp;
            }
        }
    }
}