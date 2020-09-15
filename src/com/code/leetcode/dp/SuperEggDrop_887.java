package com.code.leetcode.dp;

/**
 * 887. 鸡蛋掉落
 * 输入：K = 1, N = 2
 * 输出：2
 * 输入：K = 2, N = 6
 * 输出：3
 * 输入：K = 3, N = 14
 * 输出：4
 * https://leetcode-cn.com/problems/super-egg-drop/
 */
public class SuperEggDrop_887 {
    /**
     * 动态规划，超时
     */
    public static int superEggDrop2(int egg, int floor) {
        // 当egg个数为1时，只可以线性扫描
        if (egg == 1) {
            return floor;
        }
        // 当楼层floor等于0时，不需要扔鸡蛋
        if (floor == 0) {
            return 0;
        }
        int res = Integer.MAX_VALUE;
        // 待扫描的楼层
        for (int i = 1; i <= floor; ++i) {
            res = Math.min(res, 1 + Math.max(
                    superEggDrop2(egg - 1, i - 1),//蛋碎
                    superEggDrop2(egg, floor - i)//蛋没碎
            ));
        }
        return res;
    }

    static int[][] memo;

    /**
     * 带缓冲的动态规划,时间复杂度O(KN^2)，超时
     *
     * @param egg
     * @param floor
     * @return
     */
    public static int superEggDrop4(int egg, int floor) {
        memo = new int[egg + 1][floor + 1];
        for (int i = 1; i <= egg; ++i) {
            for (int j = 1; j <= floor; ++j) {
                memo[i][j] = Integer.MAX_VALUE;
            }
        }
        return dpMemo(egg, floor);
    }

    private static int dpMemo(int egg, int floor) {
        // 当egg个数为1时，只可以线性扫描
        if (egg == 1) {
            return floor;
        }
        // 当楼层floor等于0时，不需要扔鸡蛋
        if (floor == 0) {
            return 0;
        }
        if (memo[egg][floor] != Integer.MAX_VALUE) {
            return memo[egg][floor];
        }
        int res = Integer.MAX_VALUE;
        // 待扫描的楼层
        for (int i = 1; i <= floor; ++i) {
            res = Math.min(res, 1 + Math.max(
                    dpMemo(egg - 1, i - 1),//蛋碎
                    dpMemo(egg, floor - i)//蛋没碎
            ));
        }
        memo[egg][floor] = res;
        return res;
    }

    /**
     * 时间复杂度O（kN^2）,k是鸡蛋数，n是楼层数，在leetcode超时
     *
     * @param egg
     * @param floor
     * @return
     */
    public static int superEggDrop(int egg, int floor) {
        if (egg <= 0 || floor <= 0) {
            return 0;
        }
        int[][] dp = new int[egg + 1][floor + 1];
        //base case
        for (int i = 1; i <= egg; ++i) {
            for (int j = 1; j <= floor; ++j) {
                // 最坏的次数
                dp[i][j] = j;
            }
        }
        for (int i = 2; i <= egg; ++i) {
            for (int j = 2; j <= floor; ++j) {
                for (int k = 1; k < j; ++k) {
                    //最坏情况下扔鸡蛋的次数，所以鸡蛋在第i层楼碎没碎，取决于那种情况的结果更大
                    int max = 1 + Math.max(
                            dp[i][j - k],//没碎
                            dp[i - 1][k - 1]);//碎了
                    dp[i][j] = Math.min(dp[i][j], max);
                }
            }
        }
        return dp[egg][floor];
    }

    public static int superEggDrop3(int eggs, int floors) {
        if (eggs <= 0 || floors <= 0) {
            return -1;
        }
        // dp[k][m]表示k个鸡蛋，移动m次可以确定多少楼层
        // dp[k][m]=1 + dp[egg][move - 1] + dp[egg - 1][move - 1]
        // dp[egg - 1][move - 1]:鸡蛋碎了（向下搜索），k-1个鸡蛋在move-1步可以搜索的楼层数，dp[egg - 1][move - 1]
        // dp[egg][move - 1]:鸡蛋没碎(向上搜索)，k个鸡蛋在move-1步可以搜索的楼层数，dp[egg - 1][move - 1]
        // 最后加上本层楼
        // 时间复杂度O(klgN),空间复杂度O(NK)
        int dp[][] = new int[eggs + 1][floors + 1];
        int move = 0;
        while (dp[eggs][move] < floors) {
            move++;
            for (int egg = 1; egg <= eggs; ++egg) {
                dp[egg][move] = 1 + dp[egg][move - 1] + dp[egg - 1][move - 1];
            }
        }
        return move;
    }

    public static void main(String[] args) {
        System.out.println(superEggDrop(2, 6));
    }
}
