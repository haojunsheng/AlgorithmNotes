package com.code.leetcode.map;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * 两个列表的最小索引总和
 * 假设Andy和Doris想在晚餐时选择一家餐厅，并且他们都有一个表示最喜爱餐厅的列表，每个餐厅的名字用字符串表示。
 * 你需要帮助他们用最少的索引和找出他们共同喜爱的餐厅。 如果答案不止一个，则输出所有答案并且不考虑顺序。
 * 示例 1:
 * 输入:
 * ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 * ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
 * 输出: ["Shogun"]
 * 解释: 他们唯一共同喜爱的餐厅是“Shogun”。
 * 示例 2:
 * 输入:
 * ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 * ["KFC", "Shogun", "Burger King"]
 * 输出: ["Shogun"]
 * 解释: 他们共同喜爱且具有最小索引和的餐厅是“Shogun”，它有最小的索引和1(0+1)。
 */
public class FindRestaurant_599 {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        // 存放结果
        List<String> res = new LinkedList<>();
        // 记录最小值
        int minNum = Integer.MAX_VALUE;
        // 初始化hashmap
        for (int i = 0; i < list1.length; ++i) {
            hashMap.put(list1[i], i);
        }
        // 遍历list2，如果list2[j]在hashmap中存在，则判断，大于最小值，跳过；等于最小值，加入结果；小于最小值，则更新。
        for (int j = 0; j < list2.length; ++j) {
            Integer i = hashMap.get(list2[j]);
            // 更新minSum
            if (i != null) {
                if (i + j < minNum) {
                    minNum = i + j;
                    res.clear();
                }
                if (i + j == minNum) {
                    res.add(list2[j]);
                }
            }
        }
        return res.toArray(new String[res.size()]);
    }
}