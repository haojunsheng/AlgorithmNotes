package com.code.interview.ape;

import java.util.Random;

/**
 * @author 俊语
 * @date 2020/9/12 20:11
 */
public class Main3 {
    public static void main(String[] args) {
        System.out.println((new Random().nextInt() % 100) < 60 ? "YES" : "NO");
    }
}
