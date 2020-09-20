package com.code.leetcode.other;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 实现一个基本的计算器来计算一个简单的字符串表达式的值。
 * 字符串表达式可以包含左括号 ( ，右括号 )，加号 + ，减号 -，非负整数和空格  。
 * 示例 1，输入: "1 + 1"，输出: 2
 * 示例 2:输入: " 2-1 + 2 "，输出: 3
 * 示例 3:输入: "(1+(4+5+2)-3)+(6+8)"，输出: 23
 * leetcode 224:有加法减法和括号，https://leetcode-cn.com/problems/basic-calculator/
 * leetcode 227:有加减乘除，https://leetcode-cn.com/problems/basic-calculator-ii/
 * leetcode 772:加减乘除和括号
 */
public class Calculate1_224 {
    public static void main(String[] args) {
        Calculate1_224 calculate1_224 = new Calculate1_224();
        String s = "(1+(4+5+2)-3)+(6+8)";
        System.out.println(calculate1_224.calculate(s));
    }

    int index = 0;

    public int calculate(String s) {
        return dfs(s);
    }

    private int dfs(String s) {
        Deque<Integer> stack = new LinkedList<>();
        int num = 0;
        char op = '+';
        for (; index < s.length(); ++index) {
            char ch = s.charAt(index);
            // 遇到左括号，括号的处理是较为麻烦的，我们需要特殊处理
            // 遇到左括号，进行递归运算,calculate(3*(4-5/2)-6) = 3 * calculate(4-5/2) - 6
            if (ch == '(') {
                ++index;
                num = dfs(s);
            }
            // 字符串转整数，(ch - '0') 的这个括号不能省略，否则可能造成整型溢出。
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            }
            // 当前字符为+-*/的时候，把之前的数字入栈，或者index走到了末尾，把当前数字入栈，方便进行后续的计算
            // 这里同时也处理了空格
            if ((!Character.isDigit(ch) && ch != ' ') || index == s.length() - 1) {
                switch (op) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        int pre = stack.pop();
                        stack.push(pre * num);
                        break;
                    case '/':
                        pre = stack.pop();
                        stack.push(pre / num);
                        break;
                }
                // 更新符号，数字清零
                num = 0;
                op = ch;
            }
            //
            if (ch == ')') {
                break;
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }
}
