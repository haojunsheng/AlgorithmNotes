package com.code.interview.baidu;

/**
 * 相邻元素差的绝对值都是1，在这样的数组中找目标元素
 *
 * @author 俊语
 * @date 2020/9/3 18:46
 */
public class Main {
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 5, 6, 7, 8, 9, 10, 9};
        int target = 9;
        System.out.println(findNumberInArray(arr, target));
    }

    /**
     * 最笨的方法是扫描一遍O(n)
     * 我们知道nextIndex=target-arr[0],因为相邻元素差的绝对值都是1，那么arr[nextIndex]必然小于target
     */
    private static int findNumberInArray(int[] arr, int target) {
        int nextIndex = Math.abs(target - arr[0]);
        while (nextIndex < arr.length) {
            if (arr[nextIndex] == target) {
                return nextIndex;
            }
            nextIndex += Math.abs(target - arr[nextIndex]);
        }
        return -1;
    }
}
