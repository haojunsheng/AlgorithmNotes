package com.code.offer.string;

/**
 * 正则表达式匹配
 * 给你一个字符串 str 和一个字符规律 pattern，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 * '.' 匹配任意单个字符,'*' 匹配零个或多个前面的那一个元素，所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 * 说明:
 * str 可能为空，且只包含从 a-z 的小写字母。
 * pattern 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 * 1. 输入:
 * str = "aa"
 * pattern = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 2. 输入:
 * str = "aa"
 * pattern = "a*"
 * 输出: true
 * 解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 * 3. 输入:
 * str = "ab"
 * pattern = ".*"
 * 输出: true
 * 解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 */
public class RegularMatch_19 {
    /**
     * 动态规划
     * dp[i][j] 表示 str 的前 i 个是否能被 pattern 的前 j 个匹配
     * 首先想的时候从已经求出了 dp[i-1][j-1] 入手，再加上已知 str[i]、pattern[j]，要想的问题就是怎么去求 dp[i][j]。
     * 已知 dp[i-1][j-1] 意思就是前面子串都匹配上了，不知道新的一位的情况。
     * 那就分情况考虑，所以对于新的一位 pattern[j] str[i] 的值不同，要分情况讨论：
     * 考虑最简单的 pattern[j] == str[i] : dp[i][j] = dp[i-1][j-1]
     * 然后从 pattern[j] 可能的情况来考虑，让 pattern[j]=各种能等于的东西。
     * pattern[j] == "." : dp[i][j] = dp[i-1][j-1]
     * pattern[j] ==" * ":
     */
    public boolean isMatch(String str, String pattern) {
        if (str == null || pattern == null) {
            return false;
        }
        boolean[][] dp = new boolean[str.length() + 1][pattern.length() + 1];
        dp[0][0] = true;
        //dp[i][j] 表示 str 的前 i 个是否能被 pattern 的前 j 个匹配
        for (int i = 0; i < pattern.length(); i++) {
            if (pattern.charAt(i) == '*' && dp[0][i - 1]) {
                dp[0][i + 1] = true;
            }
        }
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < pattern.length(); j++) {
                if (pattern.charAt(j) == '.' || pattern.charAt(j) == str.charAt(i)) {
                    dp[i + 1][j + 1] = dp[i][j];
                }
                if (pattern.charAt(j) == '*') {
                    //如果前一个元素不匹配 且不为任意元素
                    if (pattern.charAt(j - 1) != str.charAt(i) && pattern.charAt(j - 1) != '.') {
                        dp[i + 1][j + 1] = dp[i + 1][j - 1];
                    } else {
                        /*
                        dp[i][j] = dp[i-1][j] // 多个字符匹配的情况
                        or dp[i][j] = dp[i][j-1] // 单个字符匹配的情况
                        or dp[i][j] = dp[i][j-2] // 没有匹配的情况
                         */
                        dp[i + 1][j + 1] = (dp[i + 1][j] || dp[i][j + 1] || dp[i + 1][j - 1]);
                    }
                }
            }
        }
        return dp[str.length()][pattern.length()];
    }

    /**
     * 回溯法
     */
    public boolean match(String str, String pattern) {
        //如果正则串p为空字符串s也为空则匹配成功，如果正则串p为空但是s不是空则说明匹配失败
        if (pattern.isEmpty()) {
            return str.isEmpty();
        }
        // 判断s和p的首字符是否匹配，注意要先判断s不为空,即正常和.的情况
        boolean headMatched = !str.isEmpty() && (str.charAt(0) == pattern.charAt(0) || pattern.charAt(0) == '.');
        // 如果p的第一个元素的下一个元素是*,匹配0个或者多个
        // 匹配0个，例如s：bc、pattern：a*bc，我们就保持s不变，减掉p的"a*"，调用isMatch(str:bc,pattern:bc)。
        // 匹配多个，例如s：aabb、pattern：a*bb，就保持p不变，减掉s的首元素，调用isMatch(str:abb,pattern:a*bb)。
        if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
            return match(str, pattern.substring(2)) ||
                    (headMatched && match(str.substring(1), pattern));
            // 如果s和p的首字符相等
        } else if (headMatched) {
            return match(str.substring(1), pattern.substring(1));
        } else {
            return false;
        }
    }
}