package com.code.leetcode.graph;

import java.util.Arrays;

/**
 * 743. 网络延迟时间
 * 有 N 个网络节点，标记为 1 到 N。给定一个列表 times，表示信号经过有向边的传递时间。
 *  times[i] = (u, v, w)，其中 u 是源节点，v 是目标节点， w 是一个信号从源节点传递到目标节点的时间。
 * 现在，我们从某个节点 K 发出一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回 -1。
 * <p>
 * 输入：times = [[2,1,1],[2,3,1],[3,4,1]], N = 4, K = 2
 * 输出：2
 * https://leetcode-cn.com/problems/network-delay-time/
 */
public class NetworkDelayTime_743 {
    public static void main(String[] args) {
        System.out.println();
    }

    public int networkDelayTime(int[][] times, int N, int K) {
        //初始化邻接矩阵
        int[][] graph = new int[N + 1][N + 1];
        Arrays.fill(graph, -1);
        //遍历times填充邻接矩阵
        for (int[] time : times) {
            graph[time[0]][time[1]] = time[2];
        }
        //存放K到各点的最短路径，最大那个即为结果
        int[] distance = new int[N + 1];
        Arrays.fill(distance, -1);
        //K到自己的距离为0
        distance[K] = 0;
        //判断是否找到K点到N个节点的最短路径
        boolean[] visited = new boolean[N + 1];
        visited[K] = true;
        // 遍历除K以外的N-1个节点
        for (int i = 0; i <= N - 1; ++i) {
            int minDis = Integer.MAX_VALUE;
            int minIndex = 1;
            //遍历所有节点，找到离K最近的节点
            for (int j = 1; j <= N; j++) {
                if (!visited[j] && distance[j] != -1 & distance[j] < minDis) {
                    minDis = distance[j];
                    minIndex = j;
                }
            }
            // 标记最近距离被找到
            //通过刚刚找到的这个节点更新K与其他节点的距离
            for (int j = 1; j <= N; j++) {
                if (graph[minIndex][j] != -1) {
                    if (distance[j] == -1) {
                        distance[j] = distance[minIndex] + graph[minIndex][j];
                    } else {
                        distance[j] = Math.min(distance[j], distance[minIndex] + graph[minIndex][j]);
                    }
                }
            }
        }
        //答案为到各点最短路径的最大值，应该最大的已经到了,其余都能到
        int ans = -1;
        for (int i = 1; i <= N; i++) {
            if (distance[i] == -1) {
                //表示不可达
                return -1;
            }
            ans = Math.max(ans, distance[i]);
        }
        return ans;
    }
}
