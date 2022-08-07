package algorithm.a_leecodeEveryday._again.dp;

/**
 * 526. 优美的排列
 */
public class Demo817 {

    public static void main(String[] args) {
        System.out.println(countArrangement(5));
    }
    //dfs
//    private static int res;
//    public static int countArrangement(int n) {
//        List[] ints = new List[n + 1];
//        boolean[] used = new boolean[n+1];
//        for (int i = 1; i <= n; i++) {
//            ints[i] = new ArrayList<Integer>();
//            for (int j = 1; j <= n; j++) {
//                //ints[i] = new ArrayList<Integer>();
//                if(i % j == 0 || j % i == 0){
//                    ints[i].add(j);
//                }
//            }
//        }
//        dfs(1,n,ints,used);
//        return res;
//    }
//
//    private static void dfs(int cur, int n, List<Integer>[] ints, boolean[] used) {
//        if(cur > n) {
//            //??
//            res++;
//            return;
//        }
//        for(int a : ints[cur]) {
//            if(!used[a]){
//                used[a] = true;
//                dfs(cur+1,n,ints,used);
//                used[a] = false;
//            }
//        }
        //动态规划

    int a ;//动态规划
    //动态规划
//    public static int countArrangement(int n) {
//        //dp[i][j]表示第i个数，状态为j时候的个数
//        int[][] dp = new int[n + 1][1 << n];
//        dp[0][0] = 1;
//        for (int i = 1; i <= n; i++) {
//            for (int k = 0; k < 1 << n; k++) {
//                for (int j = 1; j <= n; j++) {
//                    if ((j % i == 0 || i % j == 0) &&  (1 << j-1 & k) != 0) {
//                        //dp[i][k] += dp[i-1][1<<i-1 ^ k];
//                        dp[i][k] += dp[i-1][(~(1<<j-1)) & k];
//                    }
//                }
//            }
//        }
//
//        return dp[n][(1<<n)-1];

    int b;//动态规划优化
    public static int countArrangement(int n) {
        //dp[j]表示第i个数，状态为j时候的个数
        int[] dp = new int[1 << n];
        dp[0] = 1;

        for (int i = 1; i <= 1 << n; i++) {
            int bitCount = Integer.bitCount(i);
            for (int j = 1; j <= n; j++) {
                if((j % bitCount == 0 || bitCount % j == 0) && (1 << (j-1) & i) != 0){
                    //dp[i] += dp[];怎么写?还是一样去掉j
                    dp[i] += dp[i &~(1<<(j-1))];

                }
            }
        }
        return dp[(1<<n)-1];
    }
}
