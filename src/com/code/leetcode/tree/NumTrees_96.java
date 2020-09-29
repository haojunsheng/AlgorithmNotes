package com.code.leetcode.tree;

import java.math.BigInteger;

/**
 * 96. 不同的二叉搜索树
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 * 输入: 3
 * 输出: 5
 * https://leetcode-cn.com/problems/unique-binary-search-trees/
 *
 * @author 俊语
 * @date 2020/9/19 20:45
 */
public class NumTrees_96 {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(numTrees(n));
    }

    /**
     * 假设n个节点存在二叉排序树的个数是G(n)，令f(i)为以i为根的二叉搜索树的个数，则G(n)=f(1)+f(2)+f(3)+f(4)+...+f(n)
     * 当 i 为根节点时，其左子树节点个数为 i-1 个，右子树节点为 n-i，则f(i) = G(i-1)*G(n-i)
     * 所以卡特兰数：G(n)=G(0)∗G(n−1)+G(1)∗G(n−2)+...+G(n−1)∗G(0)
     *
     * @param n
     * @return
     */
    public static int numTrees(int n) {
        int[] dp = new int[n + 1];
        // 空树
        dp[0] = 1;
        // 只有一个节点
        dp[1] = 1;

        for (int i = 2; i < n + 1; i++) {
            for (int j = 1; j < i + 1; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }

    /**
     * 卡特兰数公式
     * res=2*(2*n-1)*res/(n+1)=res*(4*n-2)/n+1
     *
     * @param n
     * @return
     */
    public static BigInteger numTrees2(int n) {
        BigInteger res = BigInteger.valueOf(1);
        BigInteger one = BigInteger.valueOf(1);
        BigInteger two = BigInteger.valueOf(2);
        BigInteger four = BigInteger.valueOf(4);
        for (int i = 2; i <= n; ++i) {
            BigInteger bigIntegerI = BigInteger.valueOf(i);
            res = res.multiply(four.multiply(bigIntegerI).subtract(two)).divide(bigIntegerI.add(one));
        }
        System.out.println(res);
        return res;
    }
}
