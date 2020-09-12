package com.code.interview.alibaba;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * 输入n,m两个整数代表n行m列
 * 下面输入n行字符串，每个字符串都包含m个字符（只含有'.','#','E','S'）
 * 其中S代表起点，E代表终点，#代表无法通过
 * 从起点出发，可向左，向右，向上，向下移动一步
 * 也可按如下中心对称移动，也只算移动一步，最多只可以使用5次
 * X（i,j）→ X‘（n+1-i,m+1-j）
 * 求从起点到终点最少需要移动几步？
 * <p>
 * 输入：
 * 4 4
 * #S..
 * E#..
 * #...
 * ....
 * 输出
 * 4
 * 说明：先中心对称到达（4，3），然后向上一步，向右一步，中心对称到达终点
 * <p>
 * dp[i][j][k]：对于位置i,j，用了k次飞行器时，达到这个位置最小需要的步数。
 * 用队列来进行访问：
 * 1. 首先把起点坐标放入队列
 * 2. 每一次访问队头元素，观察其1步可以到达的（上、下、左、右、中心对称位）的坐标：
 * 如果该坐标当前记录的某一种飞行器使用次数k下的值>当前值+1，则更新该值，把这一坐标加入队列
 * （注意，上、下、左、右是同k值比较，中心对称位需要使用一次飞行器，所以是k+1和K比较）
 * 3. 队列清空，更新完成
 * 给出终点目前记录的步数，即为结果
 */
public class Maze_323 {
    static int[][] forward = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    static class Node {
        int node_x;
        int node_y;

        Node(int x, int y) {
            node_x = x;
            node_y = y;
        }
    }

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        int m = reader.nextInt();
        reader.nextLine();
        char[][] strChar = new char[n][m];

        int end_x = -1;
        int end_y = -1;
        LinkedList<Node> queue = new LinkedList<>();

        int[][][] dp = new int[n][m][6];  //  代dp[i][j][k]代表到达[i][j]位置，用了k个飞行器时（不一定要都用，是有k个飞行器的条件），最少经过的步数

        //  给dp中的每个值附一个初值
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < 6; k++) {
                    dp[i][j][k] = m * n + 1;  //  注意，不可以赋值为Integer.MAX_VALUE,加减之后会出现负值
                }
            }
        }

        for (int i = 0; i < n; i++) {
            String temp = reader.nextLine();
            for (int j = 0; j < m; j++) {
                if (temp.charAt(j) == 'S') {
                    Node node = new Node(i, j);
                    for (int k = 0; k < 6; k++) {
                        dp[i][j][k] = 0;
                    }
                    queue.add(node);
                } else if (temp.charAt(j) == 'E') {
                    end_x = i;
                    end_y = j;
                }
                strChar[i][j] = temp.charAt(j);
            }
        }

        //  广度优先搜索，寻找到达终点经过的最少的步数
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int x = node.node_x;
            int y = node.node_y;
            //  上下左右走，相同k更新
            for (int i = 0; i < 4; i++) {
                int temp_x = x + forward[i][0];
                int temp_y = y + forward[i][1];
                if (temp_x >= 0 && temp_x < n && temp_y >= 0 && temp_y < m && strChar[temp_x][temp_y] != '#') {
                    boolean flag = false;
                    for (int k = 0; k < 6; k++) {
                        if (dp[temp_x][temp_y][k] > dp[x][y][k] + 1) {
                            dp[temp_x][temp_y][k] = dp[x][y][k] + 1;
                            flag = true;
                        }
                    }
                    //  相当于每一个节点的步数重新做了更新，都要重新考虑一遍此节点
                    if (flag) {
                        queue.add(new Node(temp_x, temp_y));
                    }
                }
            }
            //  跳跃更新
            if (strChar[n - x - 1][m - y - 1] != '#') {

                boolean flag = false;
                for (int k = 0; k < 5; k++) {
                    if (dp[n - x - 1][m - y - 1][k + 1] > dp[x][y][k] + 1) {
                        dp[n - x - 1][m - y - 1][k + 1] = dp[x][y][k] + 1;
                        flag = true;
                    }
                }
                if (flag) {
                    queue.add(new Node(n - x - 1, n - y - 1));
                }
            }

        }
        if (dp[end_x][end_y][5] != n * m + 1) {
            System.out.println(dp[end_x][end_y][5]);
        } else {
            System.out.println(-1);
        }
    }
}
