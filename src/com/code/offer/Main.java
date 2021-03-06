package com.code.offer;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

/**
 * 做题常用技巧
 *
 * @author 俊语
 * @date 2020/9/13 09:42
 */
public class Main {
    public static void main(String[] args) {
        // 随机的题目
        System.out.println((new Random().nextInt() % 100) < 60 ? "YES" : "NO");
        Scanner scanner = new Scanner(System.in);
        // 主要负责接收数据
        int N = scanner.nextInt();
        int[][] orders = new int[N][2];
        for (int i = 0; i < N; i++) {
            orders[i][0] = scanner.nextInt();
            orders[i][1] = scanner.nextInt();
        }
        // 委托 solution 进行求解
        solution(orders);
    }

    static void solution(int[][] orders) {
        // 排除一些基本的边界情况
        if (orders.length == 0) {
            System.out.println("None");
            return;
        }
        // 委托 dp 函数执行具体的算法逻辑
        int res = dp(orders, 0);
        // 负责输出结果
        System.out.println(res);
    }

    // 备忘录
    static HashMap<String, Integer> memo = new HashMap<>();

    static int dp(int[][] orders, int start) {
        // 具体的算法逻辑
        return 0;
    }
}
