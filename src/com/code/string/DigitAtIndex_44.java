package com.code.string;

/**
 * 数字序列中某一位的数字
 */
public class DigitAtIndex_44 {
    public static int findNthDigit(int n) {
        //base digits
        long base = 9;
        int digits = 1;

        while (n > base * digits) {
            n -= base * digits;
            base *= 10;
            digits++;
        }
        //数字索引
        int index = n % digits;
        if (index == 0) {
            index = digits;
        }
        int number = 1;
        for (int i = 1; i < digits; i++) {
            number *= 10;
        }
        number += index == digits ? n / 3 - 1 : n / 3;
        for (int i = index; i < digits; i++) {
            number /= 10;
        }
        return number % 10;
    }
}
