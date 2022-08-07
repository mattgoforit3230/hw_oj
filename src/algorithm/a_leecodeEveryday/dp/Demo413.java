package algorithm.a_leecodeEveryday.dp;

public class Demo413 {
    //413. 等差数列划分
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums.length < 3)return 0;
        //dp[i]是以i项结尾的，满足条件的个数
        int[] dp = new int[nums.length];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i < nums.length; i++) {
            //当dp[i-1]已经不为0时，dp[i] = dp[i-1]+1;
            //当为0，则需要判断
            if(nums[i]-nums[i-1] == nums[i-1]-nums[i-2]) {
                if (dp[i - 1] != 0) {
                    dp[i] = dp[i - 1] + 1;
                }else{
                    dp[i] = 1;
                }
            }else{
                dp[i] = 0;
            }
        }
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res+=dp[i];
        }
        return res;
    }
}
