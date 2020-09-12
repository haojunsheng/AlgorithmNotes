package com.code.offer.string;

import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 数字序列中某一位的数字，数字以0123456789101112131415…的格式序列化到一个字符序列中。
 * 在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。请写一个函数，求任意第n位对应的数字。
 * 输入：n = 3，输出：3
 * 输入：n = 11，输出：0
 */
public class DigitAtIndex_44 {
    /**
     * 对于第 n 位对应的数字，我们令这个数字对应的数为target，然后分三步进行。
     * 1. 首先找到这个数字对应的数是几位数，用digits表示；
     * 2. 然后确定这个对应的数的数值target；
     * 3. 最后确定返回值是 target 中的哪个数字。
     * 举个栗子：
     * 比如输入的 n 是 365：
     * 经过第一步计算我们可以得到第365个数字表示的数是三位数，n=365−9−90×2=176，digtis = 3。这时 n=176 表示目标数字是三位数中的第 176个数字。
     * 我们设目标数字所在的数为 number，计算得到number=100+176/3=158，idx 是目标数字在 number 中的索引，如果 idx = 0，表示目标数字是 number 中的最后一个数字。
     * 根据步骤2，我们可以计算得到 idx = n % digits = 176 % 3 = 2，说明目标数字应该是 number = 158 中的第二个数字，即输出为 5。
     */
    public static int findNthDigit(int n) {
        long base = 9;
        int digits = 1;
        // 1. 首先找到这个数字对应的数是几位数
        while (n > base * digits) {
            n -= base * digits;
            base *= 10;
            digits++;
        }

        // 数字索引，n现在表示digits位数的第n个数字
        // index是目标数字在number中的索引，如果index=0，表示目标数字是number中的最后一个数字。
        int index = n % digits;
        if (index == 0) {
            index = digits;
        }
        // 2. number表示第几个数
        int number = 1;
        for (int i = 1; i < digits; i++) {
            number *= 10;
        }
        number += (index == digits) ? n / digits - 1 : n / digits;
        // 3. number的第几个数
        for (int i = index; i < digits; i++) {
            number /= 10;
        }
        return number % 10;
    }
}