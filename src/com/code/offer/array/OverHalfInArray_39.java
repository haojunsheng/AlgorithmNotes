package com.code.offer.array;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class OverHalfInArray_39 {
    // 数组的特点
    public int MoreThanHalfNum_Solution(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        if (array.length == 1) {
            return array[0];
        }
        int count = 1;
        int result = array[0];
        for (int i = 1; i < array.length; ++i) {
            if (result != array[i]) {
                count--;
                if (count == 0) {
                    result = array[i];
                    count = 1;
                }
            } else {
                count++;
            }
        }
        // 在此确认是不是真的超过一半
        count = 0;
        for (int i = 0; i < array.length; ++i) {
            if (array[i] == result) {
                count++;
            }
        }
        if (count > array.length / 2) {
            return result;
        } else {
            return 0;
        }
    }

    /**
     * 出现次数超过一半-》如果排序则该数字出现在中间，即n/2，我们把问题转化为求n/2大的数字，即第k大数字
     * 快排的思想
     * 假设你选择的数字p在快排一轮完成后下标是m，那么比p小的数字就有m个，
     * 如果k小于m，那么第k大的数字一定在p的左边，否则在右边
     */
    public int MoreThanHalfNum(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        if (array.length == 1) {
            return array[0];
        }
        int middle = array.length / 2;
        int index = partition(array, 0, array.length - 1);
        while (index != middle) {
            if (index > middle) {
                index = partition(array, 0, index - 1);
            } else {
                index = partition(array, index + 1, array.length - 1);
            }
        }
        int result = array[index];
        int count = 0;
        for (int i = 0; i < array.length; ++i) {
            if (array[i] == result) {
                count++;
            }
        }
        if (count > array.length / 2) {
            return result;
        } else {
            return 0;
        }
    }

    //快排的时候需要用到，双指针法
    public int partition(int A[], int left, int right) {
        int temp = A[left];
        //只要两个数不相遇
        while (left < right) {
            //从右边找小于temp的值
            while (left < right && A[right] > temp) {
                right--;
            }
            //找到则交换
            A[left] = A[right];
            //从左边找大于temp的值
            while (left < right && A[left] <= temp) {
                left++;
            }
            A[right] = A[left];
        }
        A[left] = temp;
        return left;
    }
}
