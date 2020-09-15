package com.code.leetcode.dp;

/**
 * 打家劫舍2
 * 所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * <p>
 * 输入: [2,3,2]，输出: 3
 * 解释: 你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 * <p>
 * 输入: [1,2,3,1]，输出: 4
 * 解释: 你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。偷窃到的最高金额 = 1 + 3 = 4 。
 * <p>
 * https://leetcode-cn.com/problems/house-robber-ii/
 *
 * @author 俊语
 * @date 2020/9/15 12:01
 */
public class Rob2_213 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(rob(nums));
    }

    /**
     * 把环形的拆成2个，一个是不偷第一个房子，一个是不偷最后一个房子，然后取二者的较大值
     *
     * @param nums
     * @return
     */
    public static int rob(int[] nums) {
        int length = nums.length;
        if (length <= 0) {
            return 0;
        }
        if (length == 1) {
            return nums[0];
        }
        return Math.max(robRange(nums, 0, length - 1), robRange(nums, 1, length));
    }

    public static int robRange(int[] nums, int start, int end) {
        int dp_i_1 = 0, dp_i_2 = 0;
        int dp_i = 0;
        for (int i = start; i < end; ++i) {
            dp_i = Math.max(dp_i_1, dp_i_2 + nums[i]);
            dp_i_2 = dp_i_1;
            dp_i_1 = dp_i;
        }
        return dp_i;
    }
}
