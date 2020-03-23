package com.code.interview;

import java.util.*;

/**
 * 阿里巴巴笔试题目
 * 字符的ASCII码递增的，能够吧这些旋律拼接起来组成最长的旋律的长度
 * 比如：aaa
 * bcd
 * bcdef
 * zzz
 * 结果是aaabcdefzzz
 */
public class LongestString {

    private static int dynamicSolver(List<String> melodies) {
        if (melodies == null || melodies.isEmpty()) {
            return -1;
        }
        // dp[i]表示以melodies[i]结尾的最长字符串的长度
        int dp[] = new int[melodies.size()];
        // 初始化dp数组
        for (int i = 0; i < dp.length; ++i) {
            dp[i] = melodies.get(i).length();
        }
        //既然是递增子序列，我们只要找到前面那些结尾比melodies[i]开头小的子序列，
        // 然后把该字符串连接，就可以形成一个新的递增子序列，而且这个新的子序列⻓度加当前字符串的长度。
        for (int i = 0; i < melodies.size(); ++i) {
            for (int j = 0; j < i; ++j) {
                if (melodies.get(i).charAt(0) > melodies.get(j).charAt(melodies.get(j).length() - 1)) {
                    dp[i] = Math.max(dp[i], dp[j] + melodies.get(i).length());
                }
            }
        }
        int res = 0;
        for (int i = 0; i < dp.length; ++i) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        // 记得输入输出怎么写
        Scanner sc = new Scanner(System.in);
        List<String> melodies = new ArrayList<>();
        int n = sc.nextInt();
        for (int i = 0; i <= n; i++) {
            String input = sc.nextLine();
            if (input.length() == 0) {
                continue;
            }
            melodies.add(input);
        }
        melodies.sort(String::compareTo);
        System.out.println(LongestString.dynamicSolver(melodies));
    }
}