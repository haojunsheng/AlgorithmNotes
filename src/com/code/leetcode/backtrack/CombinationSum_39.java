package com.code.leetcode.backtrack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 组合总和
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。candidates 中的数字可以无限制重复被选取。
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为：
 * [
 * [7],
 * [2,2,3]
 * ]
 * <p>
 * 输入：candidates = [2,3,5], target = 8,
 * 所求解集为：
 * [
 * [2,2,2,2],
 * [2,3,3],
 * [3,5]
 * ]
 *
 * @author 俊语
 * @date 2020/9/17 14:35
 */
public class CombinationSum_39 {
    public static void main(String[] args) {
        int[] candidates = {8, 7, 4, 3};
        int target = 11;
        CombinationSum_39 combinationSum39 = new CombinationSum_39();
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
            if (target < nums[i]) {
                break;
            }
            //选择
            path.add(nums[i]);
            // 进入下一层决策树,由于i可以重复使用，所以下次索引还是i
            dfs(nums, i, path, target - nums[i]);
            // 撤销选择
            path.removeLast();
        }
    }
}
