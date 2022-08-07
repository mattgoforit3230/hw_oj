package algorithm.a_leecodeEveryday.a_demo2021_8;

public class Demo818 {
    public static void main(String[] args) {
        System.out.println(checkRecord(100));
    }
    /**552 学生出勤记录II
     * 按 总出勤 计，学生缺勤（'A'）严格 少于两天。
     * 学生 不会 存在 连续 3 天或 3 天以上的迟到（'L'）记录。
     * @return
     */
    public static int checkRecord(int n) {
        final int mod = 1000000007;
        //dp[i][j][k]代表第i天缺勤j次，连续迟到k次的方案总数
        int[][][] dp = new int[n][2][3];
        dp[0][0][0] = 1;
        dp[0][1][0] = 1;
        for (int i = 1; i < n; i++) {
            //最后加的是p
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 3; k++) {
                    dp[i][j][0] = (dp[i][j][0] + dp[i-1][j][k])%mod;
                }
            }
            //最后加的是a
            for (int k = 0; k < 3; k++) {
                dp[i][1][0] = (dp[i][1][0] + dp[i-1][0][k])%mod;
            }
            //最后加的是l
            for (int k = 0; k < 3; k++) {
                for (int j = 0; j < 2; j++) {
                    dp[i][j][k] = (dp[i][j][k] + dp[i-1][j][k-1])%mod;
                }
            }
        }
        int sum=0;
        for (int j = 0; j < 2; j++) {
            for (int k = 0; k < 3; k++) {
                sum += dp[n-1][j][k];
            }
        }
        return sum;

    }
}
