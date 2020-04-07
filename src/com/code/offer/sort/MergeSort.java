package com.code.offer.sort;

public class MergeSort {
    /**
     * 归并排序
     *
     * @param array
     * @return
     */
    public static int[] mergeSort(int[] array, int left, int right) {
        if (left >= right) {
            return array;
        }
        int mid = (left + right) / 2;
        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);
        merge(array, left, mid, right);
        return array;
    }

    /**
     * 归并排序——将两段排序好的数组结合成一个排序数组
     */
    private static void merge(int[] arr, int low, int mid, int high) {
        //temp数组用于暂存合并的结果
        int[] temp = new int[high - low + 1];
        //左半边的指针
        int i = low;
        //右半边的指针
        int j = mid + 1;
        //合并后数组的指针
        int k = 0;

        //将记录由小到大地放进temp数组
        for (; i <= mid && j <= high; k++) {
            if (arr[i] < arr[j]) {
                temp[k] = arr[i++];
            } else {
                temp[k] = arr[j++];
            }
        }

        //接下来两个while循环是为了将剩余的（比另一边多出来的个数）放到temp数组中
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= high) {
            temp[k++] = arr[j++];
        }

        //将temp数组中的元素写入到待排数组中
        for (int l = 0; l < temp.length; l++) {
            arr[low + l] = temp[l];
        }
    }
}
