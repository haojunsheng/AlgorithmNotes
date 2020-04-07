package com.code.leetcode.recursive;

/**
 * 第K个语法符号
 * 在第一行我们写上一个0。接下来的每一行，将前一行中的0替换为01，1替换为10。
 * 给定行数 N 和序数 K，返回第 N 行中第 K个字符。（K从1开始）
 * <p>
 * 输入: N = 1, K = 1
 * 输出: 0
 * 输入: N = 2, K = 1
 * 输出: 0
 * 输入: N = 2, K = 2
 * 输出: 1
 * 输入: N = 4, K = 5
 * 输出: 1
 * 解释:
 * 第一行: 0
 * 第二行: 01
 * 第三行: 0110
 * 第四行: 01101001
 * <p>
 * <p>
 * 注意:
 * N 的范围 [1, 30].
 * K 的范围 [1, 2^(N-1)].
 */
public class kthGrammar_779 {
    /**
     * 可以看出，如果K小于等于所在行的一半，也就是2^N-2，那么直接去上一行找，也就是下面的helper(N-1, K, flag);
     * 反之，要从后半部分找，而后半部分，正是01翻转后的前一行，也就是helper(N-1, K - half, 1-flag)。
     * 这里 flag 是0或1，来回翻转。
     *
     * @param N
     * @param K
     * @return
     */
    public int kthGrammar(int N, int K) {
        return kthGrammarHelper(N, K, 0);
    }

    private int kthGrammarHelper(int N, int K, int flag) {
        if (N == 1) {
            return flag;
        }
        int half = (1 << (N - 2));
        if (K <= half) {
            return kthGrammarHelper(N - 1, K, flag);
        } else {
            return kthGrammarHelper(N - 1, K - half, 1 - flag);
        }
    }
}
