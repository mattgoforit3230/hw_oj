package algorithm.a_leecodeEveryday.dp;
//记录简单的dp问题
public class EasyDp {
    public static void main(String[] args) {
//        int[] cost = new int[]{1,100,1,1,1,100,1,1,100,1};

        System.out.println(integerBreak(8));
    }
    /**
     * 746 最小花费上楼梯
     * @param cost
     * @return
     */
    public static int minCostClimbingStairs(int[] cost) {
        //dp[i]上到第i个阶梯时的最小花费
        int[] dp = new int[cost.length];
        if(cost.length == 1)return 0;
        //dp数组的初始化
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            //递推公式
            dp[i] = Math.min( dp[i-1]+cost[i],dp[i-2]+cost[i]);
        }
        return Math.min(dp[cost.length-1],dp[cost.length-2]);
    }

    /**
     * 62不同路经
     * @param m
     * @param n
     * @return
     */
    public static int uniquePaths(int m, int n) {
        //二叉树
//        return dfs(1,1,m,n);
//    }
//    private static int dfs(int i, int j, int m, int n) {
//        if(i > m || j > n)return 0;
//        if(i == m && j == n)return 1;
//
//        return dfs(i+1,j,m,n)+dfs(i,j+1,m,n);
        //
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {
                if(i == 0 || j == 0){
                    dp[i][j] = 1;
                }else{
                    dp[i][j] = dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];

    }

    /**
     * 63不同路径（障碍物）
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        //分别初始化
        for (int i = 0; i < obstacleGrid.length && obstacleGrid[i][0] != 1; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < obstacleGrid[0].length && obstacleGrid[0][i] != 1; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j < obstacleGrid[0].length; j++) {
                if(obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                }else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }

    /**
     * 343正数拆分
     * @param n
     * @return
     */
    public static int integerBreak(int n) {
        //dp[i]表示为i时的最大整数
        int[] dp = new int[n + 1];
        //初始化
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(Math.max(dp[j],j)*Math.max((i-j),dp[i-j]),dp[i]);
            }
        }
        return dp[n];
    }

    /**
     * 96.👻不同的二叉搜索树
     * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的
     * 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
     * @param n
     * @return
     */
    public int numTrees(int n) {
        //dp[i]表示，i作为根节点的值，有多少不同搜索树
        int[][] dp = new int[n + 1][n + 1];
        dp[0][0] = 0;
        dp[1][0] = 1;
        dp[2][0] = 1;
        for (int i = 0; i < n + 1; i++) {
            //递推公式
            //dp[i][n-i] = dp[][] + dp[][]
        }
        return 0;
    }
}
