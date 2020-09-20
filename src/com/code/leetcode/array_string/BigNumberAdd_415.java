package com.code.leetcode.array_string;

/**
 * 字符串相加
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 * https://leetcode-cn.com/problems/add-strings/
 *
 * @author 俊语
 * @date 2020/9/18 12:34
 */
public class BigNumberAdd_415 {

    public static void main(String[] args) {
        String num1 = "123", nums2 = "456";
        System.out.println(addStrings(num1, nums2));
    }

    public static String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
        while (i >= 0 || j >= 0) {
            int n1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int n2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            int tmp = n1 + n2 + carry;
            carry = tmp / 10;
            res.append(tmp % 10);
            i--;
            j--;
        }
        if (carry == 1) {
            res.append(1);
        }
        return res.reverse().toString();
    }
}
