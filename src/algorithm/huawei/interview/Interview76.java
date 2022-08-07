package algorithm.huawei.interview;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 单词搜索
 *  找到它是一个小游戏，你需要在一个矩阵中找到给定的单词。
 *  假设给定单词 HELLOWORD，在矩阵中只要能找到 H->E->L->L->O->W->O->R->L->D连成 的单词，就算通过。
 * 注意区分英文字母大小写，并且您只能上下左右行走，不能走回头路。
 *
 *输入：
 *  输入第 1 行包含两个整数 n、m (0 < n,m < 21) 分别表示 n 行 m 列的矩阵，
 *  第 2 行是⻓度不超过100的单词 W (在整个矩阵中给定单词 W 只会出现一次)，
 *  从第 3 行到第 n+2 行是指包含大小写英文字母的⻓度为 m 的字符串矩阵。
 *输出
 *  如果能在矩阵中连成给定的单词，则输出给定单词首字母在矩阵中的位置(第几行 第几列)，
 *  否则输出“NO”
 *
 5 5
 HELLOWORLD
 CPUCY
 EKLQH
 CHELL
 LROWO
 DGRBC
 */
public class Interview76 {
    static boolean flag = false;
    static int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    static int n,m;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine().trim();
        String[] split = str.split("\\s+");
        n = Integer.parseInt(split[0]);
        m = Integer.parseInt(split[1]);
        String W = scanner.nextLine().trim();
        char[][] grid = new char[n][m];
        for (int i = 0; i < n; i++) {
            String s = scanner.nextLine().trim();
            for (int j = 0; j < m; j++) {
                grid[i][j] = s.charAt(j);
            }
        }
        int[] res = new int[2];
        boolean[][] isUsed = new boolean[n][m];
        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                if(grid[i][j] == W.charAt(0)){
                    dfs(grid,i,j,W,0,isUsed);
                    if(flag){
                        res[0] = i+1;
                        res[1] = j+1;
                    }
                }
            }
        }
        if(!flag) System.out.println("NO");
        else System.out.println(res[0] + " "+res[1]);
    }

    private static void dfs(char[][] grid, int i, int j,
                            String word, int cur, boolean[][] isUsed) {
        if(cur >= word.length())return;
        if(i < 0 || i == grid.length || j < 0 || j == grid[0].length)return;
        if(grid[i][j] != word.charAt(cur) || isUsed[i][j])return;
        isUsed[i][j] = true;
        if(cur == word.length()-1){
            flag = true;
            return;
        }
        for(int[] dir : dirs){
            int x = i + dir[0];
            int y = j + dir[1];
            dfs(grid,x,y,word,cur+1,isUsed);
        }
        isUsed[i][j] = false;
    }
}
