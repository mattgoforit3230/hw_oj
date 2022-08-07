package algorithm.huawei.interview;

import java.util.Arrays;
import java.util.Scanner;

/**
 * [最小传输时延]
 * dijkstra
 * 某通信网络中有N个网络结点，用1到N进行标识。网络通过一个有向无环图表示，
 * 其中图的边的 值表示结点之间的消息传递时延。 现给定相连节点之间的时延列表times[i]={u，v，w}，
 * 其中u表示源结点，v表示目的结点，w表示 u和v之间的消息传递时延。 请计算给定源结点到目的结点的
 * 最小传输时延，如果目的结点不可达，返回-1。
 * 注:
 * 1. N的取值范围为[1，100];
 * 2. 时延列表times的⻓度不超过6000，且 1 <= u,v <= N，0 <= w <= 100;
 *
 * 输入描述
 * 1. 输入的第一行为两个正整数，分别表示网络结点的个数N，以及时延列表的⻓度M，用空格分 隔;
 * 2. 接下来的M行为两个结点间的时延列表[u v w];
 * 3. 输入的最后一行为两个正整数，分别表示源结点和目的结点。
 *
 3 3
 1 2 11
 2 3 13
 1 3 50
 1 3
 => 24
 */
public class Interview25H {
    public static void main(String[] args) {
        int INF = Integer.MAX_VALUE >> 1;
        Scanner scanner = new Scanner(System.in);
        String[] nm = scanner.nextLine().trim().split("\\s+");
        int N = Integer.parseInt(nm[0]),M = Integer.parseInt(nm[1]);
        int[][] grid = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(grid[i],INF);
        }
        for (int i = 0; i < M; i++) {
            String[] split = scanner.nextLine().trim().split("\\s+");
            int a = Integer.parseInt(split[0]);
            int b = Integer.parseInt(split[1]);
            int c = Integer.parseInt(split[2]);
            grid[a-1][b-1] = c;
        }
        String[] split1 = scanner.nextLine().trim().split("\\s+");
        int start = Integer.parseInt(split1[0])-1;
        int end = Integer.parseInt(split1[1])-1;
        boolean[] isUsed = new boolean[N];
        int[] dist = new int[N];
        Arrays.fill(dist,INF);
        dist[start] = 0;
        for (int i = 0; i < N; i++) {
            int cur = -1;
            for (int j = 0; j < N; j++) {
                if(!isUsed[j] && (cur ==-1 || dist[j] < dist[cur]))cur = j;
            }
            isUsed[cur] = true;
            for (int j = 0; j < N; j++) {
                dist[j] = Math.min(dist[j],dist[cur] + grid[cur][j]);
            }
        }
        if(dist[end] == INF) System.out.println(-1);
        else System.out.println(dist[end] );
    }
}
