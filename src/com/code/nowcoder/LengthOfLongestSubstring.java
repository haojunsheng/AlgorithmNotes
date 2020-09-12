package com.code.nowcoder;

import java.util.HashMap;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的最长子串的长度。
 */
public class LengthOfLongestSubstring {

    public int minWindow(String s) {
        int left = 0, right = 0;
        HashMap<Character, Integer> window = new HashMap<>();
        int res = 0;
        while (right < s.length()) {
            char c1 = s.charAt(right);
            window.put(c1, window.get(c1) + 1);
            right++;
            // 如果 window 中出现重复字符
            // 开始移动 left 缩小窗口
            while (window.get(c1) > 1) {
                char c2 = s.charAt(left);
                // 移除window
                window.put(c2, window.get(c2) - 1);
                left++;
            }
            // 需要注意的是，因为我们要求的是最⻓子串，
            // 所以需要在每次移动right增大窗口时更新res，
            // 而不是像之前的题目在移动left缩小窗口时更新res。
            res = Math.max(res, right - left);
        }
        return res;
    }

    public static void main(String args[]) {

    }
}
