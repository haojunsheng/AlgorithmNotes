package com.code.newcoder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 找到字符串中所有字母异位词
 * <p>
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 * 字母异位词指字母相同，但排列不同的字符串。
 * <p>
 * 输入：
 * s: "cbaebabacd" p: "abc"
 * <p>
 * 输出:
 * [0, 6]
 * <p>
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
 */
public class HeterotopicInString {

    /**
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int left = 0, right = 0;
        HashMap<Character, Integer> window = new HashMap<>();
        HashMap<Character, Integer> needs = new HashMap<>();
        for (int i = 0; i < p.length(); ++i) {
            needs.put(p.charAt(i), needs.get(p.charAt(i)) + 1);
        }
        // 记录window中已经有多少字符符合要求了
        int match = 0;
        while (right < s.length()) {
            char c1 = s.charAt(right);
            // needs包含c1
            if (needs.get(c1) != 0) {
                window.put(c1, window.get(c1) + 1);
                // 字符 c1 的出现次数符合要求了
                if (window.get(c1).equals(needs.get(c1))) {
                    match++;
                }
            }
            right++;
            // 如果 window 的大小合适
            // 就把起始索引 left 加入结果
            while (match == needs.size()) {
                if (right - left < p.length()) {
                    res.add(left);
                }
                char c2 = s.charAt(left);
                if (needs.get(c2) != 0) {
                    // 移除window
                    window.put(c2, window.get(c2) - 1);
                    if (!window.get(c1).equals(needs.get(c1))) {
                        // 字符 c2 出现次数不再符合要求
                        match--;
                    }
                }
                left++;
            }
        }
        return res;
    }

    public static void main(String args[]) {

    }
}
