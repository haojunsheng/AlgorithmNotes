package com.code.offer.sort_basic;

import java.util.Arrays;

public class ShellSort {
    /**
     * 希尔排序
     *
     * @param array
     * @return
     */
    public static int[] ShellSort(int[] array) {
        int len = array.length;
        int temp, gap = len / 2;
        while (gap > 0) {
            for (int i = gap; i < len; i++) {
                temp = array[i];
                int preIndex = i - gap;
                while (preIndex >= 0 && array[preIndex] > temp) {
                    array[preIndex + gap] = array[preIndex];
                    preIndex -= gap;
                }
                array[preIndex + gap] = temp;
            }
            //不断缩小gap，直到1为止
            gap /= 2;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] oldArr = {1, 3, 2, 5, 9, 6};
        long startTime = System.nanoTime();
        int[] newArr = ShellSort.ShellSort(oldArr);
        long endTime = System.nanoTime();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
        System.out.println(Arrays.toString(newArr));
    }
}
