package com.code.interview.tencent;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author 俊语
 * @date 2020/8/23 18:55
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        int n = scanner.nextInt();
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < k; ++i) {
            list.add(scanner.nextInt());
        }

        if (k < n) {
            printList(list);
        }
        list.remove(n - 1);
        printList(list);
    }

    private static void printList(ArrayList<Integer> list) {
        System.out.print(list.get(0));
        for (int i = 1; i < list.size(); ++i) {
            System.out.print(" " + list.get(i));
        }
    }
}
