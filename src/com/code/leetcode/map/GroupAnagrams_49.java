package com.code.leetcode.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 字母异位词分组
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * 示例:
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 */
public class GroupAnagrams_49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length <= 0) {
            return new ArrayList<>();
        }
        // 把每个英文字母的出现的次数作为键，每个符合要求的字符串作为值
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            // 统计每个字符出现的次数
            char[] temp = new char[26];
            for (char ch : str.toCharArray()) {
                temp[ch - 'a']++;
            }
            String keyStr = String.valueOf(temp);
            if (!map.containsKey(keyStr)) {
                map.put(keyStr, new ArrayList<>());
            }
            map.get(keyStr).add(str);
        }
        return new ArrayList<>(map.values());
    }
}