package com.code.leetcode.stack_queue;

import java.util.Stack;

/**
 * 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 输入: "()[]{}"
 * 输出: true
 * 输入: "([)]"
 * 输出: false
 * https://leetcode-cn.com/problems/valid-parentheses/
 */
public class IsValid_20 {
    public boolean isValid(String s) {
        if (s == null || s.length() <= 0) {
            return true;
        }
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else if (stack.empty() || c != stack.pop()) {
                return false;
            }
        }
        return stack.empty();
    }
}
