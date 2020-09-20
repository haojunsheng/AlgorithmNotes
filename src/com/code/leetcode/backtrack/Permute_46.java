package com.code.leetcode.backtrack;

import java.util.LinkedList;
import java.util.List;

/**
 * 全排列
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 *
 * @author 俊语
 * @date 2020/9/17 14:08
 */
public class Permute_46 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Permute_46 permute_46 = new Permute_46();
        System.out.println(permute_46.permute(nums));
    }

    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        //记录路径
        LinkedList<Integer> path = new LinkedList<>();
//        dfs(nums, path);
        int[] visited = new int[nums.length];
        dfs2(nums, path, visited);
        return res;
    }

    /**
     * 选择列表:nums 中不存在于 path 的那些元素
     * 结束条件:nums 中的元素全都在path中出现
     *
     * @param nums
     * @param path 保存路径
     */
    private void dfs(int[] nums, LinkedList<Integer> path) {
        if (path.size() == nums.length) {
            res.add(new LinkedList<>(path));
            return;
        }
        for (int i : nums) {
            // 不能重复，注意，这里的时间复杂度为O(n)，可以用一个数组来进行优化
            if (path.contains(i)) {
                continue;
            }
            //选择
            path.add(i);
            // 进入下一层决策树
            dfs(nums, path);
            // 撤销选择
            path.removeLast();
        }
    }

    private void dfs2(int[] nums, LinkedList<Integer> path, int[] visited) {
        if (path.size() == nums.length) {
            res.add(new LinkedList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            // 不能重复，注意，这里的时间复杂度为O(n)，可以用一个数组来进行优化
            if (visited[i] == 1) {
                continue;
            }
            //选择
            path.add(nums[i]);
            visited[i] = 1;
            // 进入下一层决策树
            dfs2(nums, path, visited);
            // 撤销选择
            path.removeLast();
            visited[i] = 0;
        }
    }
}
