package com.code.interview.alibaba;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * 阿里笔试题目
 * n个人，选举任意数量的人组成队伍，在从选举中的人选出一名队长，求不同的方案数对10^9+7取模的结果
 * 输入n,1<=n<=10^9
 * 输出一个数字表示答案
 * 例子：输入2，输出4，4种方案分别是(1'),(2'),(1',2),(1,2')
 * 这个问题还是挺复杂的，考察了大数问题，无论是开辟数组还是递归都是不可能AC的
 * 考察了下面的公式
 * Sn = C(N, 0) * 0 + C(N, 1) * 1 + C(N, 2) * 2 + ... + C(N, N) * N，1式
 * Sn = C(N, N) * N +  C(N, N - 1) * (N - 1) + C(N, N - 2) * (N - 2) + ... + C(N, 1) * 1 + C(N, 0) * 0，2式
 * 由于C(N, i) 与C(N, N - i)相等，将1式和2式对应项可以相加，得
 * Sn + Sn = 2Sn = C(N, 0) * N + C(N, 1) * N + ... + C(N, N) * N = N(C(N, 0) + C(N, 1) + ... + C(N, N)) = N * 2^(N)
 * 于是,
 * Sn = N * 2^(N - 1)
 * 也可以：第i个人当队长时，剩下（n-1）个人可选择入队或不入队，每人两种选择，共计2^（N-1）种，所以N*2^（N-1）
 */
public class ElectionCaptain_323 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.next();
        BigInteger in = BigInteger.valueOf(Long.parseLong(n));
        BigInteger num = scheme(in);//种数
        BigInteger x = BigInteger.valueOf(10).pow(9).add(BigInteger.valueOf(7));
        System.out.println(num.mod(x));
    }

    private static BigInteger scheme(BigInteger n) {
        return n.multiply(BigInteger.valueOf(2).pow(n.intValue() - 1));
    }
}
