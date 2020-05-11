package com.code.leetcode.array_string;

/**
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。输入为非空字符串且只包含数字1和0。
 * 示例 1:
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * <p>
 * 示例 2:
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 */
public class AddBinary_67 {
    // 整体思路是将两个字符串较短的用0补齐，使得两个字符串长度一致，然后从末尾进行遍历计算，得到最终结果。
    public String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder();
        //进位
        int ca = 0;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int sum = ca;
            sum += (i >= 0 ? a.charAt(i) - '0' : 0);
            sum += (j >= 0 ? b.charAt(j) - '0' : 0);
            ans.append(sum % 2);
            ca = sum / 2;
        }
        ans.append(ca == 1 ? "1" : "");
        return ans.reverse().toString();
    }
}