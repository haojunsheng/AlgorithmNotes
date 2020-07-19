package com.code.offer.sort_basic;

public class QuickSort {
    /**
     * 快速排序方法
     *
     * @param array
     * @param start
     * @param end
     * @return
     */
    public static int[] quickSort(int[] array, int start, int end) {
        if (array.length < 1 || start < 0 || end >= array.length || start > end) {
            return null;
        }
        int index = partition(array, start, end);
        if (index > start) {
            quickSort(array, start, index - 1);
        }
        if (index < end) {
            quickSort(array, index + 1, end);
        }
        return array;
    }

    /**
     * 快速排序算法——partition
     *
     * @param arr
     * @param left
     * @param right
     * @return
     */
    public static int partition(int arr[], int left, int right) {
        int temp = arr[left];
        while (left < right) {
            while (left < right && arr[right] > temp) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= temp) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = temp;
        return left;
    }

    /**
     * 交换数组内两个元素
     *
     * @param array
     * @param i
     * @param j
     */
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
