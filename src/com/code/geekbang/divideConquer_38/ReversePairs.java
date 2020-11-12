package com.code.geekbang.divideConquer_38;

/**
 * @author 俊语
 * @date 2020/11/7 21:28
 */
public class ReversePairs {
    private int num = 0;

    public int count(int[] a) {
        num = 0;
        mergeSortCounting(a, 0, a.length - 1);
        return num;
    }

    private void mergeSortCounting(int[] a, int p, int r) {
        if (p >= r) {
            return;
        }
        int q = (p + r) / 2;
        mergeSortCounting(a, p, q);
        mergeSortCounting(a, q + 1, r);
        merge(a, p, q, r);
    }

    private void merge(int[] a, int p, int q, int r) {
        int i = p, j = q + 1, k = 0;
        int[] tmp = new int[r - p + 1];
        while (i <= q && j <= r) {
            if (a[i] <= a[j]) {
                tmp[k++] = a[i++];
            } else {
                // 统计 p-q 之间，比a[j]大的元素个数
                num += (q - i + 1);
                tmp[k++] = a[j++];
            }
        }
        while (i <= q) {
            tmp[k++] = a[i++];
        }
        while (j <= r) {
            tmp[k++] = a[j++];
        }
        for (i = 0; i <= r - p; ++i) {
            a[p + i] = tmp[i];
        }
    }

    public static void main(String[] args) {
        ReversePairs reversePairs = new ReversePairs();
        int[] a = {2, 4, 3, 1, 5, 6};
        System.out.println(reversePairs.count(a));
    }
}
