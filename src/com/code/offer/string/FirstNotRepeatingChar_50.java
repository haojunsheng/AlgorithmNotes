package com.code.offer.string;

import java.util.HashMap;

/**
 * 题目描述：第一个只出现一次的字符
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。
 * s = "abaccdeff"
 * 返回 "b"
 * s = ""
 * 返回 " "
 */
public class FirstNotRepeatingChar_50 {
    // 如果只有英文字符
    public static int FirstNotRepeatingChar(String str) {
        if (str.length() <= 0 || str == null) {
            return -1;
        }
        int[] num = new int[256];
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; ++i) {
            num[chars[i]]++;
        }
        for (int i = 0; i < chars.length; ++i) {
            if (num[chars[i]] == 1) {
                return i;
            }
        }
        return -1;
    }

    //
    public char firstUniqChar(String s) {
        HashMap<Character, Boolean> dic = new HashMap<>();
        char[] sc = s.toCharArray();
        for (char c : sc) {
            dic.put(c, !dic.containsKey(c));
        }
        for (char c : sc) {
            if (dic.get(c)) {
                return c;
            }
        }
        return ' ';
    }

    public static void main(String args[]) {
        String test1 = "";//非法输入测试
        System.out.println("test1:" + FirstNotRepeatingChar(test1));
        String test2 = "google";//存在只出现一次的字符
        System.out.println("test2:" + FirstNotRepeatingChar(test2));
        String test3 = "goog";//不存在只出现一次的字符
        System.out.println("test3:" + FirstNotRepeatingChar(test3));
    }
}

