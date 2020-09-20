package com.code.offer.goback;

import java.util.*;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 */
public class StringPermutation_38 {
    public ArrayList<String> Permutation(String str) {
        List<String> resultList = new ArrayList<String>();
        if (str.length() == 0) {
            return (ArrayList) resultList;
        }
        //递归的初始值为（str数组，空的list，初始下标0）
        dfs(str.toCharArray(), resultList, 0);
        Collections.sort(resultList);
        return (ArrayList) resultList;
    }

    /**
     * @param ch
     * @param list
     * @param index
     */
    private void dfs(char[] ch, List<String> list, int index) {
        //这是递归的终止条件，就是index下标已经移到char数组的末尾的时候，考虑添加这一组字符串进入结果集中
        if (index == ch.length - 1) {
            //判断一下是否重复
            if (!list.contains(new String(ch))) {
                list.add(new String(ch));
                return;
            }
        } else {
            for (int j = index; j < ch.length; j++) {
                // 做选择
                swap(ch, index, j);
                // 下一层决策树
                dfs(ch, list, index + 1);
                // 取消选择
                swap(ch, index, j);
            }
        }
    }

    //交换数组的两个下标的元素
    private void swap(char[] str, int i, int j) {
        if (i != j) {
            char t = str[i];
            str[i] = str[j];
            str[j] = t;
        }
    }
}
