package com.code.leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 分割回文串
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。返回 s 所有可能的分割方案。
 * https://leetcode-cn.com/problems/palindrome-partitioning/
 */
public class PartitionString_131 {
    List<List<String>> result;
    List<String> list;

    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        if (s.isEmpty()) {
            return result;
        }
        list = new ArrayList<>();
        dfs(s, 0);
        return result;
    }

    private void dfs(String s, int pos) {
        if (pos == s.length()) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = pos; i < s.length(); ++i) {
            if (isPal(s, pos, i)) {
                list.add(s.substring(pos, i + 1));
                dfs(s, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }
    // 判断是不是回文串
    public boolean isPal(String s, int low, int high) {
        while (low < high) {
            if (s.charAt(low++) != s.charAt(high--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
