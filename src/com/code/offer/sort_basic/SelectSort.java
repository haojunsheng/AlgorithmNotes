package com.code.offer.sort_basic;

import java.util.Arrays;

/**
 * @author anapodoton
 */
public class SelectSort {
    /**
     * 选择排序
     *
     * @param array
     * @return
     */
    public static int[] selectionSort(int[] array) {
        if (array == null || array.length == 0) {
            return array;
        }
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i; j < array.length; j++) {
                //找到最小的数
                if (array[j] < array[minIndex]) {
                    //将最小数的索引保存
                    minIndex = j;
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] oldArr = {1, 3, 2, 5, 9, 6};
        long startTime = System.nanoTime();
        int[] newArr = SelectSort.selectionSort(oldArr);
        long endTime = System.nanoTime();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
        System.out.println(Arrays.toString(newArr));
    }
}
