package com.code.leetcode.backtrack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 子集 II，元素可重复
 *
 * 输入: [1,2,2]
 * 输出:
 * [
 * [2],
 * [1],
 * [1,2,2],
 * [2,2],
 * [1,2],
 * []
 * ]
 * https://leetcode-cn.com/problems/subsets-ii/
 * @author 俊语
 * @date 2020/9/17 16:02
 */
public class SubsetsWithDup_90 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        SubsetsWithDup_90 subsets = new SubsetsWithDup_90();
        System.out.println(subsets.subsetsWithDup(nums));
    }

    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums.length <= 0) {
            return res;
        }
        Arrays.sort(nums);
        //记录路径
        LinkedList<Integer> path = new LinkedList<>();
        dfs(nums, 0, path);
        return res;
    }


    private void dfs(int[] nums, int begin, LinkedList<Integer> path) {
        res.add(new LinkedList<>(path));
        for (int i = begin; i < nums.length; ++i) {
            // 剪枝
            if (i > begin && nums[i] == nums[i - 1]) {
                continue;
            }
            //选择
            path.add(nums[i]);
            // 进入下一层决策树,由于i可以重复使用，所以下次索引还是i
            dfs(nums, i + 1, path);
            // 撤销选择
            path.removeLast();
        }
    }
}
