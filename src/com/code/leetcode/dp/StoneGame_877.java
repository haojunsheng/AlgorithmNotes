package com.code.leetcode.dp;

/**
 * 石子游戏
 * 输入：[5,3,4,5]
 * 输出：true
 * 解释：
 * 亚历克斯先开始，只能拿前 5 颗或后 5 颗石子 。
 * 假设他取了前 5 颗，这一行就变成了 [3,4,5] 。
 * 如果李拿走前 3 颗，那么剩下的是 [4,5]，亚历克斯拿走后 5 颗赢得 10 分。
 * 如果李拿走后 5 颗，那么剩下的是 [3,4]，亚历克斯拿走后 4 颗赢得 9 分。
 * 这表明，取前 5 颗石子对亚历克斯来说是一个胜利的举动，所以我们返回 true 。
 *
 * <p>
 * https://leetcode-cn.com/problems/stone-game/
 *
 * @author 俊语
 * @date 2020/9/15 18:14
 */
public class StoneGame_877 {
    public static void main(String[] args) {
        int[] piles = {5, 3, 4, 5};
        System.out.println(stoneGame(piles));
    }

    public static boolean stoneGame(int[] piles) {
        int length = piles.length;
        // dp[i][j][0]表示[i,j]范围内，先手的最大得分
        // dp[i][j][1]表示[i,j]范围内，后手的最大得分
        // dp[i][j].fir = max(选择最左边的石头堆 , 选择最右边的石头堆)
        // 作为先手，面对 piles[i...j] 时，有两种选择:要么我选择最左边的那一堆石头，然后面对 piles[i+1...j];此时轮到对方，相当于我变成了后手;
        int[][][] dp = new int[length][length][2];
        // base case
        for (int i = 0; i < length; ++i) {
            dp[i][i][0] = piles[i];
            dp[i][i][1] = 0;
        }
        //注意最后的结果是右上角,要斜着遍历
        for (int i = length - 2; i >= 0; --i) {
            for (int j = i + 1; j < length; ++j) {
                //先手选择左边或者右边
                // 选择最左边的那一堆石头，然后面对 piles[i+1...j]
                int left = piles[i] + dp[i + 1][j][1];
                // 选择最右边的那一堆石头，然后面对 piles[i...j-1]
                int right = piles[j] + dp[i][j - 1][1];

                // 先手选左边
                if (left > right) {
                    dp[i][j][0] = left;
                    // 如果先手选择了最左边那堆，给我剩下了 piles[i+1...j],此时轮到我，我变成了先手;
                    dp[i][j][1] = dp[i + 1][j][0];
                } else {
                    dp[i][j][0] = right;
                    dp[i][j][1] = dp[i][j - 1][0];
                }
            }
        }
        return dp[0][length - 1][0] > dp[0][length - 1][1];
    }
}
