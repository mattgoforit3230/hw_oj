package algorithm.huawei.interview;

import java.util.Scanner;

/**
 * 发广播/服务器广播 [ 200 / 困难 ]
 * 孤岛问题
 * 某地有N个广播站，站点之间有些有连接，有些没有。
 * 有连接的站点在接受到广播后会互相发 送。
 * 给定一个N*N的二维数组matrix,数组的元素都是字符’0’或者’1’。
 * matrix[i][j]=‘1’,则代表i和j站点 之间有连接，matrix[i][j] = '0’代表没连接，
 * 现在要发一条广播，问初始最少给几个广播站发送，才能保证所有的广播站都收到消息。
 *
 * 并查集
 */
public class Interview43H {
    static int size = 0;
    static int[] parent;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine().trim();
        String[] split = str.split(",");
        int n = split.length;
        parent = new int[n];
        for(int i = 0;i < n;i++){
            parent[i] = i;
        }
        size = n;
        int[][] grid = new int[n][n];
        for(int i = 0;i < n;i++){
            for (int j = 0; j < n; j++) {
                grid[i][j] = split[i].charAt(j)-'0';
                if(grid[i][j] == 1 && i != j){
                    union(i,j);
                }
            }
        }
        System.out.println(size);
    }
    public static int find(int i){
        if(parent[i]!=i){
            parent[i] = find(parent[i]);
        }
        return parent[i];
    }
    public static void union(int i, int j){
        int root_i = find(i);
        int root_j = find(j);
        if(root_i != root_j){
            parent[root_i] = root_j;
            size--;
        }
    }
}
