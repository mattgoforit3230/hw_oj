package algorithm.a_leecodeEveryday.dp;
import java.util.*;
import java.util.HashSet;

public class Demo300 {
    //300. 最长递增子序列 return max

    public static void main(String[] args) {

        //[10,9,2,5,3,7,101,18]
        System.out.println(lengthOfLIS(new int[]{1,3,5,4,7}));
    }
    //300. 最长递增子序列
    public static int lengthOfLIS(int[] nums) {
        if(nums.length==1)return 1;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = 0;
        for(int i = 0;i < dp.length;i++){
            for(int j = i+1;j<dp.length;j++){
                if(nums[j]>nums[i]){
                    dp[j] = Math.max(dp[i]+1,dp[j]);
                }else{
                    dp[j] = Math.max(1,dp[j]);
                }
                max = Math.max(max,dp[j]);
            }

        }
        int res = 0;
        for(int i = 0;i < dp.length;i++){
            if(dp[i] == max)res++;
        }
        return res;
    }
}
