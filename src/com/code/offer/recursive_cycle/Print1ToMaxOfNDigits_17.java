package com.code.offer.recursive_cycle;

/**
 * 打印从1到最大的n位数：使用数组表示大数
 * 题目描述：
 * 输入数字n,按顺序打印出从1到最大的n位十进制数，比如输入3,则打印出1,2,3一直到最大的3位数即999
 * <p>
 * 模拟大数的运算
 */

public class Print1ToMaxOfNDigits_17 {
    /**
     * 输入数字n，按顺序打印出从1最大的n位十进制数。比如输入3，则打印出1、2、3 一直到最大的3位数即999。
     * @param n 数字的最大位数
     */
    public static void printOneToNthDigits(int n) {
        // 输入值必须大于0
        if (n < 1) {
            return;
        }
        // 创建一个长度为n的数组
        int[] number = new int[n];
        // 为数组元素赋初始值
        for (int i = 0; i < number.length; i++) {
            number[i] = 0;
        }
        // 求结果，如果最高位没有进位就一直进行处理，模拟大数加法
        while (addOne(number) == 0) {
            printArray(number);
        }
    }

    /**
     * 对number表示的数组的最低位加1
     * number中的每个数都不能超过9不能小于0，每个位置模拟一个数位
     * @param number 待加数组
     * @return 判断最高位是否有进位，如果有进位就返回1，否则返回0
     */
    public static int addOne(int[] number) {
        // 保存进位值，因为每次最低位加1
        int carry = 1;
        // 最低位的位置的后一位
        int index = number.length;
        do {
            // 指向上一个处理位置
            index--;
            // 处理位置的值加上进位的值
            number[index] += carry;
            // 求处理位置的进位
            carry = number[index] / 10;
            // 求处理位置的值
            number[index] %= 10;
        } while (carry != 0 && index > 0);
        // 如果index=0说明已经 处理了最高位，carry>0说明最高位有进位，返回1
        if (carry > 0 && index == 0) {
            return 1;
        }
        // 无进位返回0
        return 0;
    }

    /**
     * 输入数字n，按顺序打印出从1最大的n位十进制数。
     * 比如输入3，则打印出1、2、3 一直到最大的3位数即999。
     * 核心思想：n位所有10进制数其实就是n个从0到9的全排列。
     *
     * @param n 数字的最大位数
     */
    public static void printOneToNthDigitsRecursely(int n) {
        if (n <= 0) {
            return;
        }
        // 创建一个数组用于打存放值
        int[] number = new int[n];
        printOneToNthDigitsRecursely(0, number);
    }

    /**
     * @param index  当前处理的是第个元素，从0开始计数
     * @param number 存放结果的数组
     */
    public static void printOneToNthDigitsRecursely(int index, int[] number) {
        // 说明所有的数据排列选择已经处理完了
        if (index >= number.length) {
            // 可以输出数组的值
            printArray(number);
            return;
        }
        for (int i = 0; i <= 9; i++) {
            number[index] = i;
            printOneToNthDigitsRecursely(index + 1, number);
        }
    }

    /**
     * 输入数组的元素，从左到右，从第一个非0值到开始输出到最后的元素。
     *
     * @param arr 要输出的数组
     */
    public static void printArray(int[] arr) {
        // 找第一个非0的元素
        int index = 0;
        while (index < arr.length && arr[index] == 0) {
            index++;
        }
        // 从第一个非0值到开始输出到最后的元素。
        for (int i = index; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        // 条件成立说明数组中有非零元素，所以需要换行
        if (index < arr.length) {
            System.out.println();
        }
    }

    public static void main(String[] args) {
        printOneToNthDigits(3);
    }
}
