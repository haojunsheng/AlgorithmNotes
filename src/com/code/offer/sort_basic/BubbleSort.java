package com.code.offer.sort_basic;

import java.util.Arrays;

public class BubbleSort {
    /**
     * 冒泡排序,每次把最大的放在最后边
     *
     * @param array
     * @return
     */
    public static int[] bubbleSort(int[] array) {
        if (array == null || array.length == 0) {
            return array;
        }
        //算法的优化，如果该标志位为true，则说明已经有序，不需要继续排序
        boolean flag = false;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                flag = true;
                if (array[j] > array[j + 1]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                    flag = false;
                }
            }
            // 有序，直接返回
            if (flag == true) {
                break;
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[] oldArr = {1, 3, 2, 5, 9, 6};
        long startTime = System.nanoTime();
        int[] newArr = BubbleSort.bubbleSort(oldArr);
        long endTime = System.nanoTime();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
        System.out.println(Arrays.toString(newArr));
    }
}
