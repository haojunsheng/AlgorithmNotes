package com.code.recursive_cycle;

/**
 * 输入一个整数n，求从1到n这n个整数的十进制表示中1出现的次数。
 * 例如输入12，从1到12这些整数中包含1的数字有1，10，11和12，1一共出现了5次。
 */
public class Numberof1Between1AndN_43 {
    public int NumberOf1Between1AndN_Solution(int n) {
        if (n < 1) {
            return 0;
        }
        int count = 0;
        // base means 1,10,100,即个位数，十位数和百位数上的1
        int base = 1;
        // base位上的1出现的轮数
        int round = n;
        while (round > 0) {
            // 10进制中的每一位
            int weight = round % 10;
            round /= 10;
            count += round * base;
            // weight=1,
            if (weight == 1) {
                count += (n % base) + 1;
            } else if (weight > 1) {
                //
                count += base;
            }
            base *= 10;
        }
        return count;
    }
}
