package com.code.offer.dp_greedy;

/**
 * 数字翻译成字符串
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。
 * <p>
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 * https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/
 */
public class TransactionCount_46 {

    public static void main(String[] args) {
        int num = 12258;
        System.out.println(translateNum(num));
    }

    /**
     * @param num
     * @return
     */
    public static int translateNum(int num) {
        String str = String.valueOf(num);
        int length = str.length();
        // dp[i]表示长度为s[i]时的方法数
        // dp[i+1]=dp[i]+m * dp[i-1],当两位表示的字符大于26时,或者前面的字符为0时，g为0。
        int[] dp = new int[length + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 1; i < length; ++i) {
            if (str.charAt(i - 1) == '0' || str.substring(i - 1, i + 1).compareTo("25") > 0) {
                dp[i + 1] = dp[i];
            } else {
                dp[i + 1] = dp[i] + dp[i - 1];
            }
        }
        return dp[length];
    }
}
