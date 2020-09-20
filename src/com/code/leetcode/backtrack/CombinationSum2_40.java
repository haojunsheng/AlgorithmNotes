package com.code.leetcode.backtrack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 组合总和2
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。candidates 中的数字只可以用一次。
 *
 * @author 俊语
 * @date 2020/9/17 14:35
 */
public class CombinationSum2_40 {
    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        CombinationSum2_40 combinationSum39 = new CombinationSum2_40();
        System.out.println(combinationSum39.combinationSum(candidates, target));
    }

    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (target <= 0 || candidates.length <= 0) {
            return res;
        }
        //记录路径
        LinkedList<Integer> path = new LinkedList<>();
        //排序完，方便进行剪支
        Arrays.sort(candidates);
        dfs(candidates, 0, path, target);
        return res;
    }

    private void dfs(int[] nums, int begin, LinkedList<Integer> path, int target) {
        if (target < 0) {
            return;
        }
        // 结束条件
        if (target == 0) {
            res.add(new LinkedList<>(path));
            return;
        }
        for (int i = begin; i < nums.length; ++i) {
            // 剪支
            if (target < nums[i]) {
                break;
            }
            // 同一层相同数值的结点，从第 2 个开始，候选数更少，结果一定发生重复，因此跳过，用 continue
            if (i > begin && nums[i] == nums[i - 1]) {
                continue;
            }
            //选择
            path.add(nums[i]);
            // 进入下一层决策树,由于i可以重复使用，所以下次索引还是i
            dfs(nums, i + 1, path, target - nums[i]);
            // 撤销选择
            path.removeLast();
        }
    }
}
