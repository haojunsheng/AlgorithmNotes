package com.code.leetcode.backtrack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 全排列 II
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * 输入: [1,1,2]
 * 输出:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 *
 * @author 俊语
 * @date 2020/9/17 15:22
 */
public class PermuteUnique_47 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 3};
        PermuteUnique_47 permute_47 = new PermuteUnique_47();
        System.out.println(permute_47.permuteUnique(nums));
    }

    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        //记录路径
        LinkedList<Integer> path = new LinkedList<>();
        int[] visited = new int[nums.length];
        Arrays.sort(nums);
        dfs(nums, path, visited);
        return res;
    }

    /**
     * 选择列表:nums 中不存在于 path 的那些元素
     * 结束条件:nums 中的元素全都在path中出现
     *
     * @param nums
     * @param path 保存路径
     */
    private void dfs(int[] nums, LinkedList<Integer> path, int[] visited) {
        if (path.size() == nums.length) {
            res.add(new LinkedList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            // 已经用过
            if (visited[i] == 1) {
                continue;
            }
            //如果当前节点与他的前一个节点一样，并其他的前一个节点已经被遍历过了，那我们也就不需要了。
            if (i > 0 && nums[i] == nums[i - 1] && visited[i - 1] == 1) {
                break;
            }
            //选择
            path.add(nums[i]);
            visited[i] = 1;
            // 进入下一层决策树
            dfs(nums, path, visited);
            // 撤销选择
            path.removeLast();
            visited[i] = 0;
        }
    }
}
