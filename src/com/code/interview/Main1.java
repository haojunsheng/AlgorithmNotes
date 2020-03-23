package com.code.interview;

import java.math.BigInteger;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        System.out.println(solu(n));
    }

    public static long fact(long number) {
        if (number <= 1) {
            return 1;
        } else {
            return number * fact(number - 1);
        }
    }

    public static long combin(long n, long m) {
        long temp;
        if (n < m) {
            temp = n;
            n = m;
            m = temp;
        }
        return fact(n) / fact(m) * fact(n - m);
    }

    public static long solu(long n) {
        if (n == 1) {
            return 1;
        }
        long result = 0;
        for (long i = 1; i <= n; ++i) {
            result += combin(n, i) * i;
        }
        return result;
    }
}

//    int n = scanner.nextInt();
//    BigInteger dp[] = new BigInteger[n.add(new BigInteger("1"))];
//    int[] dp = new int[n + 1];
//    int i, j;