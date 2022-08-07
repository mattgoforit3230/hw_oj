package algorithm.a_leecodeEveryday.a_demo2021_8;

public class DDemo815 {
    final static int mod = 1000000007;
    public static void main(String[] args) {
        System.out.println(findPaths(2,2,2,0,0));
    }
    /**
     * 576. 出界的路径数
     * 给你一个大小为 m x n 的网格和一个球。球的起始坐标为 [startRow, startColumn] 。你可以将球移到在四个方向上相邻的单元格内（可以穿过网格边界到达网格之外）。你 最多 可以移动 maxMove 次球。
     *
     * 给你五个整数 m、n、maxMove、startRow 以及 startColumn ，找出并返回可以将球移出边界的路径数量。因为答案可能非常大，返回对 109 + 7 取余 后的结果。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/out-of-boundary-paths
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    //dfs+memo
//    public  static int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
//        //存储
//        int[][][] memo = new int[maxMove+1][m+1][n+1];
//        return dfs(m,n,maxMove,startRow,startColumn,memo);
//    }
//
//    private  static int dfs(int m, int n, int maxMove, int startRow, int startColumn,int[][][] memo) {
//        int res = 0;
//        //if(memo[maxMove][startRow][startColumn] != 0)return memo[maxMove][startRow][startColumn];
//        if(maxMove >= 0 && (startColumn < 0 || startRow < 0 || startRow >= m || startColumn >= n))return 1;
//        if(maxMove <= 0)return 0;
//        if(memo[maxMove][startRow][startColumn] != 0)return memo[maxMove][startRow][startColumn];
    //缺少这个剪枝
    //if(startRow-maxMove>=0 && startColumn-maxMove>=0 && startRow+maxMove < m && startColumn+maxMove < n)return 0;

//        res =  (res+dfs(m,n,maxMove-1,startRow+1,startColumn,memo))% mod;
//        res =  (res+dfs(m,n,maxMove-1,startRow,startColumn+1,memo))% mod;
//        res = (res+dfs(m,n,maxMove-1,startRow-1,startColumn,memo))% mod;
//        res = ( res+ dfs(m,n,maxMove-1,startRow,startColumn-1,memo))% mod;
//        memo[maxMove][startRow][startColumn] = res;
//        return res;
//    }
    //老老实实动态规划
    public  static int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        //dp[i][j][k]表示可以移动i，坐标为j,k时的路径数nn
        int[][][] dp = new int[maxMove+1][m][n];
        //dp[maxMove][j][k]
        for (int i = 1; i <= maxMove ; i++) {
            //向下移动
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    if(j == 0 )dp[i][j][k]++;
                    if(k == 0)dp[i][j][k]++;
                     if(j == m-1)dp[i][j][k]++;
                     if(k == n-1)dp[i][j][k]++;
                    if(j+1<m &&j+1>=0&& k<n && k>=0) {
                        dp[i][j][k] = (dp[i][j][k] + dp[i - 1][j + 1][k]) % mod;
                    }
                    if(j<m && j>=0 && k+1<n && k+1>=0) {
                        dp[i][j][k] = (dp[i][j][k] + dp[i - 1][j][k + 1]) % mod;
                    }
                    if(j-1<m && j-1>=0 && k<n && k>=0) {
                        dp[i][j][k] = (dp[i][j][k] + dp[i - 1][j - 1][k]) % mod;
                    }
                    if(j<m && j>=0 && k-1<n && k-1>=0) {
                        dp[i][j][k] = (dp[i][j][k] + dp[i - 1][j][k - 1]) % mod;
                    }
                }
            }
        }
        return dp[maxMove][startRow][startColumn];
    }
}
