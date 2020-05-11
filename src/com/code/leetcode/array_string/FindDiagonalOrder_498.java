package com.code.leetcode.array_string;

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
    /**
     * 1. 每一趟对角线中元素的坐标（x, y）相加的和是递增的。
     * 第一趟：1 的坐标(0, 0)。x + y == 0。
     * 第二趟：2 的坐标(1, 0)，4 的坐标(0, 1)。x + y == 1。
     * 第三趟：7 的坐标(0, 2), 5 的坐标(1, 1)，3 的坐标(2, 0)。第三趟 x + y == 2。
     * 第四趟：……
     * <p>
     * 2. 每一趟都是 x 或 y 其中一个从大到小（每次-1），另一个从小到大（每次+1）。
     * 第二趟：2 的坐标(1, 0)，4 的坐标(0, 1)。x 每次-1，y 每次+1。
     * 第三趟：7 的坐标(0, 2), 5 的坐标(1, 1)，3 的坐标(2, 0)。x 每次 +1，y 每次 -1。
     * <p>
     * 3. 确定初始值。例如这一趟是 x 从大到小， x 尽量取最大，当初始值超过 x 的上限时，不足的部分加到 y 上面。
     * 第二趟：2 的坐标(1, 0)，4 的坐标(0, 1)。x + y == 1，x 初始值取 1，y 取 0。
     * 第四趟：6 的坐标(2, 1)，8 的坐标(1, 2)。x + y == 3，x 初始值取 2，剩下的加到 y上，y 取 1。
     * <p>
     * 4. 确定结束值。例如这一趟是 x 从大到小，这一趟结束的判断是， x 减到 0 或者 y 加到上限。
     * 第二趟：2 的坐标(1, 0)，4 的坐标(0, 1)。x 减到 0 为止。
     * 第四趟：6 的坐标(2, 1)，8 的坐标(1, 2)。x 虽然才减到 1，但是 y 已经加到上限了。
     * <p>
     * 5. 这一趟是 x 从大到小，那么下一趟是 y 从大到小，循环进行。 并且方向相反时，逻辑处理是一样的，除了x，y和他们各自的上限值是相反的。
     * x 从大到小，第二趟：2 的坐标(1, 0)，4 的坐标(0, 1)。x + y == 1，x 初始值取 1，y 取 0。结束值 x 减到 0 为止。
     * x 从小到大，第三趟：7 的坐标(0, 2)，5 的坐标(1, 1)，3 的坐标(2, 0)。x + y == 2，y 初始值取 2，x 取 0。结束值 y 减到 0 为止。
     */
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length <= 0) {
            return new int[]{};
        }
        String s="d";
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] result = new int[rows * cols];
        // nums是每趟的索引和，每趟索引会加1
        int index = 0, nums = 0;
        while (nums < rows + cols - 1) {
            // 奇数趟，我们需要注意到矩阵不一定是正方形
            int x1 = (nums < rows) ? nums : (rows - 1);
            int y1 = nums - x1;
            while (x1 >= 0 && y1 < cols) {
                result[index++] = matrix[x1][y1];
                x1--;
                y1++;
            }
            nums++;
            if (nums >= rows + cols - 1) {
                break;
            }
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