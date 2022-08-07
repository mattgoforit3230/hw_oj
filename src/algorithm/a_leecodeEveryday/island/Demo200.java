package algorithm.a_leecodeEveryday.island;

public class Demo200 {
    //200. 岛屿数量
    int[] dx = {1,0,0,-1};
    int[] dy = {0,1,-1,0};
    int res;
    public int numIslands(char[][] grid) {
        for(int i = 0;i < grid.length;i++){
            for(int j = 0;j < grid[0].length;j++){
                if('1' == grid[i][j]){
                    dfs(grid,i,j);
                    res++;
                }
            }
        }
        return res;
    }
    public void dfs(char[][] grid,int i,int j){
        if(i < 0 || i == grid.length || j < 0 || j == grid[0].length || grid[i][j]!='1'){
            return;
        }
        grid[i][j] = '2';
        for(int k = 0; k < 4;k++){
            dfs(grid,i+dx[k],j+dy[k]);
        }
    }
}
