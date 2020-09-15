package com.code.interview.ape;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author 俊语
 * @date 2020/9/12 19:37
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer> zihuan = new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();
        int[] input = new int[n];
        for (int i = 0; i < n; ++i) {
            input[i] = scanner.nextInt();
        }
        int i = 0, j = n / 2;
        for (int k = 0; k < n; ++k) {
            if (k % 2 == 0) {
                zihuan.set(k, j);
                j++;
            } else {
                zihuan.set(k, i);
                i++;
            }
            res.set(k, k);
        }
    }

    private static void shuttle(ArrayList<Integer> arrayList, int n, int m) {
        ArrayList<Integer> temp1 = new ArrayList<>();
        ArrayList<Integer> temp2 = new ArrayList<>();

        for (int i = 0; i < n / 2; ++i) {
            temp1.add(arrayList.get(i));
            temp2.add(arrayList.get(i + n / 2));
        }
        arrayList.clear();
        for (int i = 0; i < n / 2; ++i) {
            arrayList.add(temp2.get(i));
            arrayList.add(temp1.get(i));
        }
        if (m <= 0) {
            for (int i = 0; i < arrayList.size(); ++i) {
                System.out.print(arrayList.get(i) + " ");
            }
        }
    }
}
