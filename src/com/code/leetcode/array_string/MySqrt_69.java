package com.code.leetcode.array_string;

import java.text.DecimalFormat;

/**
 * x的平方根,x精确到m位小数
 * tag:二分查找/牛顿迭代法/
 *
 * @author 俊语
 * @date 2020/9/23 22:54
 */
public class MySqrt_69 {
    public static void main(String[] args) {
        System.out.println();
    }

    /**
     * 二分查找
     *
     * @param n
     * @param precision 精度
     * @return
     */
    public String mySqrt(int n, double precision) {
        double start = 0;
        double end = (double) n;
        double lastMid = end;
        double mid = (start + end) / 2.0;
        while (Math.abs(lastMid - mid) > precision) {
            if (mid * mid > n) {
                end = mid;
            } else {
                start = mid;
            }
            lastMid = mid;
            mid = (start + end) / 2.0;
        }
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(mid);
    }

    // 牛顿迭代法,x=1/2(x+n/x)
    public Double mySqrt2(int n, double precision) {
        double val = n; //最终
        double last; //保存上一个计算的值
        do {
            last = val;
            val = (val + n / val) / 2;
        } while (Math.abs(val - last) > precision);
        return val;
    }
}
