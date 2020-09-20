package com.code.leetcode.array_string;

import java.util.Arrays;

/**
 * 大数乘法
 * 给定两个以字符串形式表示的非负整数num1和num2，返回num1和num2的乘积，它们的乘积也表示为字符串形式。
 * 示例 1:输入: num1 = "2", num2 = "3"，输出: "6"
 * 示例 2:输入: num1 = "123", num2 = "456"，输出: "56088"
 * https://leetcode-cn.com/problems/multiply-strings
 */
public class BigNumberMultiply_43 {
    public static String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int res[] = new int[m + n];
        Arrays.fill(res, 0);
        // 从个位数开始逐位相乘
        // 如何将乘积叠加到res的正确位置，或者说，如何通过i，j计算res的对应索引呢?
        // num1[i]和num2[j]的乘积对应的就是res[i+j]和res[i+j+1]这两个位置
        for (int i = m - 1; i >= 0; --i) {
            for (int j = n - 1; j >= 0; --j) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                // 乘积在res对应的索引位置
                int p1 = i + j, p2 = i + j + 1;
                // 叠加到 res 上，注意处理索引
                int sum = mul + res[p2];
                res[p2] = sum % 10;
                res[p1] += sum / 10;
            }
        }
        // 结果前缀可能存的0(未使用的位)
        int i = 0;
        while (i < res.length && res[i] == 0) {
            ++i;
        }
        // 将计算结果转化成字符串
        char[] strChar = new char[res.length - i];
        int j = 0;
        for (; i < res.length; ++i) {
            strChar[j++] = (char) (res[i] + '0');
        }
        return strChar.length == 0 ? "0" : String.valueOf(strChar);
    }

    public static void main(String args[]) {
        System.out.println(multiply("23", "35"));
    }
}
