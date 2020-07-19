package com.code.leetcode.dp;

/**
 * 887. 鸡蛋掉落
 * https://leetcode-cn.com/problems/super-egg-drop/
 */
public class SuperEggDrop_887 {
    /**
     * 动态规划
     *
     * @param egg
     * @param floor
     * @return
     */
    public static int dp(int egg, int floor) {
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
                    dp(egg - 1, i - 1),//蛋碎
                    dp(egg, floor - i)//蛋没碎
            ));
        }
        return res;
    }

    static int[][] memo;

    /**
     * 带缓冲的动态规划,时间复杂度O(KN^2)
     *
     * @param egg
     * @param floor
     * @return
     */
    public static int superEggDrop(int egg, int floor) {
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

    // 自底向上，还是超时，妈的
    public static int superEggDrop2(int eggs, int floors) {
        if (eggs <= 0 || floors <= 0) {
            return -1;
        }
        int dp[][] = new int[eggs + 1][floors + 1];
        // 初始化dp数组
        for (int i = 1; i <= eggs; ++i) {
            for (int j = 1; j <= floors; ++j) {
                dp[i][j] = j;
            }
        }
        for (int i = 2; i <= eggs; ++i) {
            for (int j = 1; j <= floors; ++j) {
                // 处理i个鸡蛋，j层楼情况
                for (int k = 1; k <= j; ++k) {
                    dp[i][j] = Math.min(dp[i][j], 1 + Math.max(dp[i][j - k], dp[i - 1][k - 1]));
                }
            }
        }
        return dp[eggs][floors];
    }

    /**
     * Drop eggs is a very classical problem.
     * Some people may come up with idea O(KN^2)
     * where dp[K][N] = 1 + max(dp[K - 1][i - 1], dp[K][N - i]) for i in 1...N.
     * However this idea is very brute force, for the reason that you check all possiblity.
     * <p>
     * So I consider this problem in a different way:
     * dp[M][K]means that, given K eggs and M moves,
     * what is the maximum number of floor that we can check.
     * <p>
     * The dp equation is:
     * dp[m][k] = dp[m - 1][k - 1] + dp[m - 1][k] + 1,
     * which means we take 1 move to a floor,
     * if egg breaks, then we can check dp[m - 1][k - 1] floors.
     * if egg doesn't breaks, then we can check dp[m - 1][k] floors.
     * <p>
     * dp[m][k] is the number of combinations and it increase exponentially to N
     * <p>
     * <p>
     * Complexity
     * For time, O(NK) decalre the space, O(KlogN) running,
     * For space, O(NK).
     *
     * @param eggs
     * @param floors
     * @return
     */
    public static int superEggDrop3(int eggs, int floors) {
        if (eggs <= 0 || floors <= 0) {
            return -1;
        }
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
