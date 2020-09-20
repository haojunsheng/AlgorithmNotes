package com.code.leetcode.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 打开转盘锁
 * 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。
 * 每个拨轮可以自由旋转：例如把 '9' 变为  '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
 * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
 * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
 * 字符串 target 代表可以解锁的数字，你需要给出最小的旋转次数，如果无论如何不能解锁，返回 -1。
 * <p>
 * 1. 输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
 * 输出：6
 * 解释：
 * 可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
 * 注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，
 * 因为当拨动到 "0102" 时这个锁就会被锁定。
 * 2. 输入: deadends = ["8888"], target = "0009"
 * 输出：1
 * 解释：
 * 把最后一位反向旋转一次即可 "0000" -> "0009"。
 * 3. 输入: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
 * 输出：-1
 * 解释：无法旋转到目标数字且不被锁定。
 * 4. 输入: deadends = ["0000"], target = "8888"
 * 输出：-1
 * https://leetcode-cn.com/problems/open-the-lock/
 */
public class OpenLock_752 {
    public static void main(String[] args) {
        String[] dead = {"0201", "0101", "0102", "1212", "2002"};
        String target = "0202";
        OpenLock_752 openLock_752=new OpenLock_752();
        System.out.println(openLock_752.bfs(dead,target));
    }

    public int bfs(String[] deadends, String target) {
        if (deadends == null || target == null) {
            return -1;
        }
        // 记录死亡密码
        Set<String> deadSet = new HashSet<>();
        for (String s : deadends) {
            deadSet.add(s);
        }
        // 记录已经穷举过的密码,防止重复访问
        Set<String> visited = new HashSet<>();
        // 从起点开始进行广度搜索
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        visited.add("0000");
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                String cur = queue.poll();
                // 判断是否遇到非法数字
                if (deadSet.contains(cur)) {
                    continue;
                }
                // 判断是否到达终点
                if (cur.equals(target)) {
                    return step;
                }
                // 开始拨动
                for (int j = 0; j < 4; ++j) {
                    String up = plusOne(cur, j);
                    // 之前没遇到过
                    if (!visited.contains(up)) {
                        visited.add(up);
                        queue.offer(up);
                    }
                    String down = minusOne(cur, j);
                    if (!visited.contains(down)) {
                        visited.add(down);
                        queue.offer(down);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    /**
     * 双向 BFS 优化
     * 传统的 BFS 框架就是从起点开始向四周扩散，遇到终点时停止；
     * 而双向 BFS 则是从起点和终点同时开始扩散，当两边有交集的时候停止。
     * 双向 BFS 也有局限，因为你必须知道终点在哪里。
     */
    int openLockDouble(String[] deadends, String target) {
        Set<String> deads = new HashSet<>();
        for (String s : deadends) {
            deads.add(s);
        }
        // 用集合不用队列，可以快速判断元素是否存在
        Set<String> q1 = new HashSet<>();
        Set<String> q2 = new HashSet<>();
        Set<String> visited = new HashSet<>();

        int step = 0;
        q1.add("0000");
        q2.add(target);

        while (!q1.isEmpty() && !q2.isEmpty()) {
            // 哈希集合在遍历的过程中不能修改，用 temp 存储扩散结果
            Set<String> temp = new HashSet<>();
            /* 将 q1 中的所有节点向周围扩散 */
            for (String cur : q1) {
                /* 判断是否到达终点 */
                if (deads.contains(cur)) {
                    continue;
                }
                if (q2.contains(cur)) {
                    return step;
                }
                visited.add(cur);

                /* 将一个节点的未遍历相邻节点加入集合 */
                for (int j = 0; j < 4; j++) {
                    String up = plusOne(cur, j);
                    if (!visited.contains(up)) {
                        temp.add(up);
                    }
                    String down = minusOne(cur, j);
                    if (!visited.contains(down)) {
                        temp.add(down);
                    }
                }
            }
            /* 在这里增加步数 */
            step++;
            // temp 相当于 q1
            // 这里交换 q1 q2，下一轮 while 就是扩散 q2
            q1 = q2;
            q2 = temp;
        }
        return -1;
    }

    /**
     * 将 s[j] 向上拨动一次
     */
    String plusOne(String s, int j) {
        char[] ch = s.toCharArray();
        if (ch[j] == '9') {
            ch[j] = '0';
        } else {
            ch[j] += 1;
        }
        return new String(ch);
    }

    /**
     * 将 s[i] 向下拨动一次
     */
    String minusOne(String s, int j) {
        char[] ch = s.toCharArray();
        if (ch[j] == '0') {
            ch[j] = '9';
        } else {
            ch[j] -= 1;
        }
        return new String(ch);
    }
}