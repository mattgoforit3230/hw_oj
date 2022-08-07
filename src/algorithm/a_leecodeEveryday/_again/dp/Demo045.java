package algorithm.a_leecodeEveryday._again.dp;

public class Demo045 {
    public static void main(String[] args) {
        jump(new int[]{2,3,1,1,4});
    }
    //跳跃游戏II,做了很久，
    //nums = [2,3,1,1,4]
    //输出: 2
    public static int jump(int[] nums) {
        if(nums.length==1)return 0;
        //需要几步可以调过来
        int[] dp = new int[nums.length];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE-10;
        }
        dp[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            int start = i+1;
            int end = nums[i]+i;
            for (int j = start; j <= end && j < nums.length; j++) {

                dp[j] = Math.min(dp[j-1]+1,dp[start]);
            }

        }
        return dp[nums.length-1];
    }

}
