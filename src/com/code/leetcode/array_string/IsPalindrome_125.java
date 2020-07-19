package com.code.leetcode.array_string;

/**
 * 验证回文串
 * https://leetcode-cn.com/problems/valid-palindrome/
 */
public class IsPalindrome_125 {
    public static boolean isPalindrome(String s) {
        if (s.isEmpty()) {
            return true;
        }
        s = s.toLowerCase();
        StringBuilder stringBuilder = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch >= '0' && ch <= '9' || (ch >= 'a' && ch <= 'z')) {
                stringBuilder.append(ch);
            }
        }
        int i = 0, j = stringBuilder.length() - 1;
        while (i <= j) {
            if (stringBuilder.charAt(i++) != stringBuilder.charAt(j--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car"));
    }
}
