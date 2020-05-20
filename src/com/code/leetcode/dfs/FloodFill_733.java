package com.code.leetcode.dfs;

/**
 * 图像渲染
 */
public class FloodFill_733 {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) {
            return image;
        }
        dfs(image, sr, sc, image[sr][sc], newColor);
        return image;
    }

    private void dfs(int[][] image, int x, int y, int oldColor, int newColor) {
        if (valid(image, x, y, oldColor)) {
            return;
        }
        image[x][y] = newColor;
        dfs(image, x - 1, y, oldColor, newColor);
        dfs(image, x + 1, y, oldColor, newColor);
        dfs(image, x, y - 1, oldColor, newColor);
        dfs(image, x, y + 1, oldColor, newColor);
    }

    private boolean valid(int[][] image, int x, int y, int oldColor) {
        if (x < 0 || x >= image.length || y < 0 || y >= image[0].length || image[x][y] != oldColor) {
            return true;
        }
        return false;
    }
}