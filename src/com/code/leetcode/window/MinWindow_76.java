package com.code.leetcode.window;

import java.util.HashMap;

/**
 * 最小覆盖子串
 * 给一个字符串S，一个子串T,在S中找出包含T所有字母的最小子串
 * 如S：ADOBECODEBANC, T：ABC
 * 输出：BANC
 * 如果不存在，输出""，如果存在，保证唯一
 * https://leetcode-cn.com/problems/minimum-window-substring/
 */
public class MinWindow_76 {
    /**
     * 时间复杂度是O(M + N),两个while循环最多执行2M次
     * 因为while执行的次数就是双指针left和right走的总路程
     * @param s
     * @param t
     * @return
     */
    public static String minWindow(String s, String t) {
        // 记录最短子串的开始位置和⻓度
        int start = 0, minLen = Integer.MAX_VALUE;
        int left = 0, right = 0;
        // needs记录字符串t中包含的字符及出现次数
        // window记录当前「窗口」中包含的字符及出现的次数
        HashMap<Character, Integer> window = new HashMap<>();
        HashMap<Character, Integer> needs = new HashMap<>();

        // 初始化
        for (char ch : t.toCharArray()) {
            needs.put(ch, needs.getOrDefault(ch, 0) + 1);
        }

        // 记录window中已经有多少字符符合要求了
        int match = 0;
        while (right < s.length()) {
            char c1 = s.charAt(right);
            // needs包含c1
            if (needs.containsKey(c1)) {
                int temp = window.getOrDefault(c1, 0) + 1;
                window.put(c1, temp);
                // 字符 c1 的出现次数符合要求了
                if (window.get(c1).equals(needs.get(c1))) {
                    match++;
                }
            }
            right++;
            // 如果符合要求，移动left缩小窗口,window中的字符串已符合needs的要求了
            while (match == needs.size()) {
                if (right - left < minLen) {
                    // 更新最小子串的位置和⻓度
                    start = left;
                    minLen = right - left;
                }
                char c2 = s.charAt(left);
                if (needs.containsKey(c2)) {
                    // 移除window
                    window.put(c2, window.get(c2) - 1);
                    if (window.get(c2) < needs.get(c2)) {
                        // 字符 c2 出现次数不再符合要求
                        match--;
                    }
                }
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }

    public static void main(String args[]) {
        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println(minWindow(s, t));
    }
}
