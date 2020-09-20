package com.code.leetcode.array_string;

import java.util.ArrayList;

/**
 * 392. 判断子序列
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * s = "abc", t = "ahbgdc",返回 true.
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。
 * （例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 * https://leetcode-cn.com/problems/is-subsequence/
 *
 * @author 俊语
 * @date 2020/9/18 15:06
 */
public class IsSubsequence_392 {
    public static void main(String[] args) {
        System.out.println();
    }

    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == s.length();
    }

    public boolean isSubsequence2(String s, String t) {
        int m = s.length(), n = t.length();
        ArrayList<Integer>[] index = new ArrayList[256];
        // 对t进行预处理
        for (int i = 0; i < n; i++) {
            char ch = t.charAt(i);
            if (index[ch] == null) {
                index[ch] = new ArrayList<>();
            }
            index[ch].add(i);
        }

        // 串 t 上的指针
        int j = 0;
        // 借助 index 查找 s[i]
        for (int i = 0; i < m; i++) {
            char c = s.charAt(i);
            // 整个 t 压根儿没有字符 c
            if (index[c] == null) {
                return false;
            }
            int pos = left_bound(index[c], j);
            // 二分搜索区间中没有找到字符 c
            if (pos == index[c].size()) {
                return false;
            }
            // 向前移动指针 j
            j = index[c].get(pos) + 1;
        }
        return true;
    }

    private int left_bound(ArrayList<Integer> arr, int tar) {
        int lo = 0, hi = arr.size();
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (tar > arr.get(mid)) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
    /**
     * 上面问题的更进一步，如果给你一系列字符串 s1,s2,... 和字符串 t，你需要判定每个串 s 是否是 t 的子序列（可以假定 s 较短，t 很长）。
     * 如果还按照上面的思路，时间复杂度是O(n^2)
     * 下面通过二分查找降低到O(nlgn)
     *
     * @param sn
     * @param t
     * @return
     */
//    boolean[] isSubsequence(String[] sn, String t) {
//
//    }

}
