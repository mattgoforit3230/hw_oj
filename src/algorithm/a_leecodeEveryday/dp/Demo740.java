package algorithm.a_leecodeEveryday.dp;

public class Demo740 {
    public static void main(String[] args) {
        deleteAndEarn(new int[]{3,4,2});
    }
    public static int deleteAndEarn(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max,nums[i]);
        }
        int[] sums = new int[max+1];
        for(int i = 0;i < nums.length;i++){
            sums[nums[i]]+= nums[i];
        }
        int[] dp = new int[sums.length];
        dp[0] = sums[0];
        dp[1] = sums[0]>sums[1]?sums[0]:sums[1];
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i-1],dp[i-2]+sums[i]);
        }
        return dp[dp.length-1];
    }
}
