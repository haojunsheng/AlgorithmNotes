package com.code.leetcode.stack;

import java.util.Stack;

/**
 * 字符串解码
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 * <p>
 * s = "3[a]2[bc]", 返回 "aaabcbc".
 * s = "3[a2[c]]", 返回 "accaccacc".
 * s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
 */
public class DecodeString_394 {
    public String decodeString(String s) {
        if (s == null || s.length() <= 0) {
            return s;
        }
        // 记录字符串出现的次数
        Stack<Integer> countStack = new Stack<>();
        // 存字符串
        Stack<StringBuilder> strStack = new Stack<>();
        StringBuilder cur = new StringBuilder();

        int k = 0;
        for (char ch : s.toCharArray()) {
            // 计算k
            if (Character.isDigit(ch)) {
                k = k * 10 + ch - '0';
                // 遇到左[,则入栈，更新k和cur
            } else if (ch == '[') {
                countStack.push(k);
                strStack.push(cur);
                cur = new StringBuilder();
                k = 0;
                // 遇到右],从栈中弹出cur和k，开始拼接cur
            } else if (ch == ']') {
                StringBuilder tmp = cur;
                cur = strStack.pop();
                for (k = countStack.pop(); k > 0; --k) {
                    cur.append(tmp);
                }
                // 遇到英文字符，更新cur
            } else {
                cur.append(ch);
            }
        }
        return cur.toString();
    }
}