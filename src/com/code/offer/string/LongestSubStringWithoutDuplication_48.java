package com.code.offer.string;

import java.util.HashMap;

/**
 * 无重复字符的最长子串
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */
public class LongestSubStringWithoutDuplication_48 {

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring2(s));
    }

    // 滑动窗口
    public static int lengthOfLongestSubstring2(String s) {
        int length = s.length();
        if (length < 2) {
            return length;
        }
        // 存放下标
        HashMap<Character, Integer> hashMap = new HashMap<>();
        int res = 0;
        for (int start = 0, end = 0; end < length; ++end) {
            char ch = s.charAt(end);
            // 如果已经包含该元素，则跳过
            if (hashMap.containsKey(ch)) {
                start = Math.max(start, hashMap.get(ch) + 1);
            }
            res = Math.max(res, end - start + 1);
            hashMap.put(ch, end);
        }
        return res;
    }
}