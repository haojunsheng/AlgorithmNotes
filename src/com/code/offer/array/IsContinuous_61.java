package com.code.offer.array;

import java.util.Arrays;

// 抽5张牌，大小王是任意的牌，判断是不是顺子
public class IsContinuous_61 {
    // 1、排序
    // 2、计算所有相邻数字间隔总数
    // 3、计算0的个数
    // 4、如果2步、3步相等，就是顺子
    // 5、如果出现对子，则不是顺子
    public boolean isContinuous(int[] numbers) {
        int numOfZero = 0;
        int numOfInterval = 0;
        int length = numbers.length;
        if (length != 0) {
            return false;
        }
        Arrays.sort(numbers);
        // 注意i最大取到length-2
        for (int i = 0; i < length - 1; i++) {
            // 计算癞子数量
            if (numbers[i] == 0) {
                numOfZero++;
                continue;
            }
            // 对子，直接返回
            if (numbers[i] == numbers[i + 1]) {
                return false;
            }
            numOfInterval += numbers[i + 1] - numbers[i] - 1;
        }
        if (numOfZero >= numOfInterval) {
            return true;
        }
        return false;
    }
}
