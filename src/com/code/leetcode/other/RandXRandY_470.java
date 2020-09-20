//package com.code.leetcode.other;
//
///**
// * 用 Rand7() 实现 Rand10()
// * 已有方法 rand7 可生成 1 到 7 范围内的均匀随机整数，试写一个方法 rand10 生成 1 到 10 范围内的均匀随机整数。
// * <p>
// * 输入: 1，输出: [7]
// * 输入: 2，输出: [8,4]
// * 输入: 3，输出: [8,1,10]
// * https://leetcode-cn.com/problems/implement-rand10-using-rand7/
// *
// * @author 俊语
// * @date 2020/9/20 09:36
// */
//public class RandXRandY_470 {
//    public static void main(String[] args) {
//
//    }
//
//    /**
//     * 1. 已知 rand_N() 可以等概率的生成[1, N]范围的随机数
//     * 那么：(rand_X() - 1) × Y + rand_Y() ==> 可以等概率的生成[1, X * Y]范围的随机数，即实现了 rand_XY()
//     * 2. 只要rand_N()中N是2的倍数，就都可以用来实现rand2()，反之，若N不是2的倍数，则产生的结果不是等概率的。如rand4() % 2 + 1可生成rand2
//     * 3. 如果第2步不是N的倍数，则进行拒绝采样
//     */
//    public int rand10() {
//        // 这个抛弃的太多，41-49都抛弃了
//        while (true) {
//            // 等概率生成[1,49]范围的随机数
//            int num = (rand7() - 1) * 7 + rand7();
//            // 拒绝采样，并返回[1,10]范围的随机数
//            if (num <= 40) return num % 10 + 1;
//        }
//        // 下面是优化版本
//        while (true) {
//            int a = rand7();
//            int b = rand7();
//            // rand 49
//            int num = (a - 1) * 7 + b;
//            // 拒绝采样
//            if (num <= 40) return num % 10 + 1;
//            // rand 9
//            a = num - 40;
//            b = rand7();
//            // rand 63
//            num = (a - 1) * 7 + b;
//            if (num <= 60) return num % 10 + 1;
//            // rand 3
//            a = num - 60;
//            b = rand7();
//            // rand 21
//            num = (a - 1) * 7 + b;
//            if (num <= 20) return num % 10 + 1;
//        }
//    }
//}
