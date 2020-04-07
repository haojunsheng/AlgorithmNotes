package com.code.offer.tree;

/**
 * 题目描述：
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是返回true，否则返回false。假设输入的数组的任意两个数字互不相同。
 * <p>
 * 分析：
 * 已知条件：后序序列最后一个值为root；二叉搜索树左子树值都比root小，右子树值都比root大。
 * 1、确定root；
 * 2、遍历序列（除去root结点），找到第一个大于root的位置，则该位置左边为左子树，右边为右子树；
 * 3、遍历右子树，若发现有小于root的值，则直接返回false；
 * 4、分别判断左子树和右子树是否仍是二叉搜索树（即递归步骤1、2、3）。
 */

public class SquenceOfBST_33 {
    // 递归版本
    public static boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence.length == 0) {
            return false;
        }
        if (sequence.length == 1) {
            return true;
        }
        return judge(sequence, 0, sequence.length - 1);
    }

    /**
     * 后序序列最后一个值为root；二叉搜索树左子树值都比root小，右子树值都比root大。
     *
     * @param sequence
     * @param start
     * @param end
     * @return
     */
    private static boolean judge(int[] sequence, int start, int end) {
        if (start >= end) {
            return true;
        }
        //第一个大于根节点的元素作为右子树
        int index = start;
        while (sequence[index] < sequence[end]) {
            index++;
        }
        // 判断右子树是不是全部大于根节点
        // 及时进行剪支
        for (int j = index; j < end; ++j) {
            if (sequence[j] < sequence[end]) {
                return false;
            }
        }
        // 递归处理左右子树
        return judge(sequence, start, index - 1) && judge(sequence, index, end - 1);
    }

    // 非递归版本
    // 对于一个二叉搜索树来说，根节点的左子树每个节点的值肯定小于右子树每个节点的值，
    // 所以可以不断的去去掉序列的最后一个值，并且把剩下的部分分成小于最后一个值和大于最后一个值的两部分，
    // 只要能分出来那就说明符合二叉搜索树的定义，否则就不符合。
    public static boolean VerifySquenceOfBST2(int[] sequence) {
        if (sequence.length == 0) {
            return false;
        }
        if (sequence.length == 1) {
            return true;
        }
        int start = 0, root = sequence.length - 1;
        while (root != 0) {
            // 找小于root的值
            while (sequence[start] < sequence[root]) {
                start++;
            }
            // 所有大于root的值
            while (sequence[start] > sequence[root]) {
                start++;
            }
            // 如果还有元素，则说明不是二叉搜索树
            if (start < root) {
                return false;
            }
            root--;
            start = 0;
        }
        return true;
    }

    public static void main(String args[]) {
        int a[] = {};
        System.out.println(VerifySquenceOfBST(a));
        int a1[] = {1};
        System.out.println(VerifySquenceOfBST(a1));
        int a2[] = {5, 7, 6, 10, 9, 11, 8};
        System.out.println(VerifySquenceOfBST(a2));
        int a3[] = {5, 7, 6, 10, 8, 11, 9};
        System.out.println(VerifySquenceOfBST(a3));
    }
}

