package com.code.sort;

import java.util.Arrays;

public class InsertSort {
    /**
     * 插入排序
     *
     * @param array
     * @return
     */
    public static int[] insertionSort(int[] array) {
        if (array == null || array.length == 0) {
            return array;
        }
        int current;
        for (int i = 0; i < array.length - 1; i++) {
            // 先取出待插入数据保存，因为向后移位过程中会把覆盖掉待插入数
            current = array[i + 1];
            int preIndex = i;
            // 如果是比待插入数据大，就后移
            while (preIndex >= 0 && current < array[preIndex]) {
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }
            // 找到比待插入数据小的位置，将待插入数据插入
            array[preIndex + 1] = current;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] oldArr = {1, 3, 2, 5, 9, 6};
        long startTime = System.nanoTime();
        int[] newArr = InsertSort.insertionSort(oldArr);
        long endTime = System.nanoTime();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
        System.out.println(Arrays.toString(newArr));
    }
}
