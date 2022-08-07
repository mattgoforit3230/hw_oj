package algorithm.huawei.interview;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 【编程题目 |200分】最⻓广播效应
 * 某通信网络中有N个网络结点，用1到N进行标识。
 * 网络中的结点互联互通，且结点之间的消息传递有时延，相连结点的时延均为一个时间单位。
 * 现给定网络结点的连接关系link[i]={u，v}，其中u和v表示网络结点。
 * 当指定一个结点向其他结点进行广播，所有被广播结点收到消息后都会在原路径上回复一条[响应消息]，请计算发送结点至少需要等待几个时间单位才能收到所有被广播结点的响应消息
 * 1. N的取值范围为[1，100];
 * 2. 连接关系link的⻓度不超过3000，且1 <= u,v <= N;
 * 3. 网络中任意结点间均是可达的;
 *
 5 7
 2 1
 1 4
 2 4
 2 3
 3 4
 3 5
 4 5
 2
 => 4
 */
public class Interview57H {
    //dijkstra
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine().trim();
        String[] split = str.split("\\s+");
        int N = Integer.parseInt(split[0]), T = Integer.parseInt(split[1]);
        int[][] matrix = new int[T][2];
        for (int i = 0; i < T; i++) {
            String[] split1 = scanner.nextLine().trim().split("\\s+");
            matrix[i][0] = Integer.parseInt(split1[0]);
            matrix[i][1] = Integer.parseInt(split1[1]);
        }
        int[][] grid = new int[N+1][N+1];
        for (int i = 1; i <= N; i++)Arrays.fill(grid[i],3000);
        for (int i = 0; i < T; i++) {
            grid[matrix[i][0]][matrix[i][1]] = 1;
        }
        int start = scanner.nextInt();
        int[] dist = new int[N+1];
        Arrays.fill(dist,3000);
        boolean[] isUsed = new boolean[N+1];
        dist[start] = 0;
        for (int i = 1; i <= N; i++) {
            int cur = -1;
            for (int j = 1; j <= N; j++) {
                //找下一个最小值的点
                if(!isUsed[j] && (cur == -1 || dist[cur] > dist[j]))cur = j;
            }
            isUsed[cur] = true;
            for (int j = 1; j <= N; j++) {
                dist[j] = Math.min(dist[j],dist[cur] + grid[cur][j]);
            }
        }
        int res = 0;
        for (int i = 1; i <= N; i++) {
            res = Math.max(dist[i],res);
        }
        System.out.println(res<<1);
    }
}
