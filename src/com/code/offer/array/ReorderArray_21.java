package com.code.offer.array;

/**
 * 题目：输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 * <p>
 * 双指针法
 * <p>
 * 我们可以维护两个指针，第一个指针初始化时指向数组的第一个数字，它只向后移动；
 * 第二个指针初始化时指向数组的最后一个数字，它指向前移动。
 * 在两个指针相遇之前，第一个指针总是位于第二个指针的前面。
 * 如果第一个指针的数字是偶数，并且第二个指针指向的数字是奇数，我们就交换两个数字。
 */
public class ReorderArray_21 {

    // 双指针法
    private static void recorderOddEven(int a[]) {
        if (a.length == 0 || a == null) {
            return;
        }
        int i = 0, j = a.length - 1;
        while (i < j) {
            //直到碰见偶数，判断偶数的方法
            while (i < j && (a[i] & 0x1) != 0) {
                i++;
            }
            //直到碰见奇数
            while (i < j && (a[j] & 0x1) == 0) {
                j--;
            }
            if (i < j) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
    }

    public void reOrderArray(int[] a) {
        if (a.length == 0 || a == null) {
            return;
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = a.length - 1; j > i; j--) {
                if (a[j] % 2 == 1 && a[j - 1] % 2 == 0) {
                    int temp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = temp;
                }
            }
        }
    }

    public static void main(String args[]) {
        int a[] = {1, 2, 3, 4, 5, 6, 7};
        test(a);
        int a2[] = {};
        test(a2);
    }

    private static void test(int a[]) {
        recorderOddEven(a);
        for (int i = 0; i < a.length; ++i) {
            System.out.print(a[i]);
        }
    }
}
