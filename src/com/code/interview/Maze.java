package com.code.interview;

import java.math.BigInteger;
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
public class Maze {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int dp[][][] = new int[n][m][6];
        // 初始化一个较大值
        for(int i=0;i<n;++i){
            for (int j=0;j<m;++j){
                for(int k=0;k<6;++k){
                    dp[i][j][k]=Integer.MAX_VALUE;
                }
            }
        }
    }

}
