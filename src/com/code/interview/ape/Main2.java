package com.code.interview.ape;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author 俊语
 * @date 2020/9/12 20:06
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T > 0) {
            String str = scanner.nextLine();
            helper(str);
            T--;
        }
    }

    private static void helper(String str) {
        String[] arr = str.split(" ");
        String regex = "[0-9]*";
        boolean temp = false;
        int fuhao = 0;
        int num = 0;
        Stack<Integer> stack = new Stack();
        for (int i = arr.length - 1; i >= 0; --i) {
            if (arr[i].matches(regex)) {

            }
        }
        System.out.println("invalid");
    }
}
