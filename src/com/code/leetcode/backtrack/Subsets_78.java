package com.code.leetcode.backtrack;

import java.util.LinkedList;
import java.util.List;

/**
 * 子集
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 * [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 * https://leetcode-cn.com/problems/subsets/
 *
 * @author 俊语
 * @date 2020/9/17 15:36
 */
public class Subsets_78 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Subsets_78 subsets_78 = new Subsets_78();
        System.out.println(subsets_78.subsets(nums));
    }

    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        if (nums.length <= 0) {
            return res;
        }
        //记录路径
        LinkedList<Integer> path = new LinkedList<>();
        dfs(nums, 0, path);
        return res;
    }

    private void dfs(int[] nums, int begin, LinkedList<Integer> path) {
        res.add(new LinkedList<>(path));
        for (int i = begin; i < nums.length; ++i) {
            //选择
            path.add(nums[i]);
            // 进入下一层决策树,由于i可以重复使用，所以下次索引还是i
            dfs(nums, i + 1, path);
            // 撤销选择
            path.removeLast();
        }
    }
}
