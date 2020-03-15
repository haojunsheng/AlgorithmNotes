package com.code.array;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * <p>
 * 解决思路：循环次数 + 每一圈(左到右，上到下，右到左，下到上)
 */
public class PrintMatrix_29 {
    private static ArrayList<Integer> printMatrixClockwisely(int nums[][], int rows, int columns) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (nums == null || rows <= 0 || columns <= 0) {
            return result;
        }
        int start = 0;

        //结束条件，左上角的横纵坐标相等
        while (start * 2 < rows && start * 2 < columns) {
            //打印每一圈
            printMatrixInCircle(nums, rows, columns, start, result);
            start++;
        }
        return result;
    }

    private static void printMatrixInCircle(int[][] nums, int rows, int columns, int start, ArrayList<Integer> result) {
        int endx = columns - 1 - start;
        int endy = rows - 1 - start;
        //从左到右打印
        for (int i = start; i <= endx; ++i) {
            result.add(nums[start][i]);
        }
        //从上向下打印
        if (endy > start) {
            for (int i = start + 1; i <= endy; ++i) {
                result.add(nums[i][endx]);
            }
        }
        //从右向左打印
        if (endy > start && endx > start) {
            for (int i = endx - 1; i >= start; --i) {
                result.add(nums[endy][i]);
            }
        }
        //从下向上打印
        if (endy - 1 > start && endx > start) {
            for (int i = endy - 1; i >= start + 1; --i) {
                result.add(nums[i][start]);
            }
        }
    }

    /**
     * 阿里面试题目
     * 输入n，输出n*n矩阵。
     * <p>
     * 输入3，输出：
     * <p>
     * 123
     * <p>
     * 894
     * <p>
     * 765
     *
     * @param n
     */
    public static void printMatrixN(int n) {
        if (n <= 0) {
            return;
        }
        int result[][] = new int[n][n];
        int start = 0;
        int cnt = 1;
        while (start * 2 < n) {
            printMatrixInNCircle(n, start, cnt, result);
            start++;
        }
    }

    private static void printMatrixInNCircle(int n, int start, int cnt, int[][] result) {
        int end = n - 1 - start;
        //从左到右
        for (int i = start; i <= end; ++i) {
            result[start][i] = cnt++;
        }
        //从上到下
        if (end > start) {
            for (int i = start + 1; i <= end; ++i) {
                result[i][end] = cnt++;
            }
        }
        //从右到左
        if (end > start) {
            for (int i = end - 1; end >= start; --i) {
                result[end][i] = cnt++;
            }
        }
        //从下向上
        if (end - 1 > start) {
            for (int i = end - 1; i >= start + 1; --i) {
                result[i][start] = cnt++;
            }
        }
    }

    public static void main(String args[]) {
        int a[][] = {{1}, {2}, {3}, {4}, {5}};
        ArrayList<Integer> arrayList = printMatrixClockwisely(a, 5, 1);
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.print(arrayList.get(i));
        }
    }
}
