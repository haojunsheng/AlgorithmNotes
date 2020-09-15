package com.code.leetcode.dp;

/**
 * 正则表达式匹配
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 * '.' 匹配任意单个字符, '*' 匹配零个或多个前面的那一个元素
 * <p>
 * 输入: s = "aa", p = "a", 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * <p>
 * 输入: s = "aa", p = "a*", 输出: true
 * 解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 * <p>
 * https://leetcode-cn.com/problems/regular-expression-matching/
 *
 * @author 俊语
 * @date 2020/9/15 11:11
 */
public class IsMatch_10 {
    public static void main(String[] args) {
        String str = "";
        String pattern = "";
        System.out.println(isMatch(str, pattern));
    }

    /**
     * @param str
     * @param pattern
     * @return
     */
    public static boolean isMatch(String str, String pattern) {
        //如果正则串p为空字符串s也为空这匹配成功，如果正则串p为空但是s不是空则说明匹配失败
        if (pattern.isEmpty()) {
            return str.isEmpty();
        }
        // 判断s和p的首字符是否匹配，注意要先判断s不为空,即正常和.的情况
        boolean headMatched = !str.isEmpty() && (str.charAt(0) == pattern.charAt(0) || pattern.charAt(0) == '.');
        // 如果p的第一个元素的下一个元素是*,匹配0个或者多个
        // 匹配0个，例如s：bc、pattern：a*bc，我们就保持s不变，减掉p的"a*"，调用isMatch(str:bc,pattern:bc)。
        // 匹配多个，例如s：aabb、pattern：a*bb，就保持p不变，减掉s的首元素，调用isMatch(str:abb,pattern:a*bb)。
        if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
            return isMatch(str, pattern.substring(2)) ||
                    (headMatched && isMatch(str.substring(1), pattern));
            // 如果s和p的首字符相等
        } else if (headMatched) {
            return isMatch(str.substring(1), pattern.substring(1));
        } else {
            return false;
        }
    }
}
