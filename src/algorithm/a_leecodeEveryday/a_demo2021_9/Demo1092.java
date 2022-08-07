package algorithm.a_leecodeEveryday.a_demo2021_9;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Demo1092 {
    //1091. 二进制矩阵中的最短路径
    //记忆化

    static int[] dx = {0,1,-1,0,1,-1,1,-1};
    static int[] dy = {1,0,0,-1,1,-1,-1,1};
     //int res = Integer.MAX_VALUE, temp = 0;

    public static void main(String[] args) {
    }
        //bfs
    public int shortestPathBinaryMatrix(int[][] grid) {
        boolean[][] used = new boolean[grid.length][grid[0].length];;
        int[][] path = new int[grid.length][grid[0].length];
        Queue<int[]> queue = new LinkedList<>();
        if(grid[0][0] == 0){
            queue.offer(new int[]{0, 0});
            path[0][0] = 1;
        }
        while(!queue.isEmpty()){
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];
            if(grid[x][y] == 0 && x==grid.length-1 && y==grid.length-1)return path[x][y];
            for (int i = 0; i < 8; i++) {
                if(x+dx[i]<0 || x+dx[i]==grid.length || y+dy[i] < 0 || y+dy[i] == grid.length ||
                        grid[x+dx[i]][y+dy[i]] == 1 || path[x+dx[i]][y+dy[i]] != 0)continue;
                path[x+dx[i]][y+dy[i]] = path[x][y]+1;
                queue.offer(new int[]{x+dx[i],y+dy[i]});
            }
        }
        return -1;
    }
}
