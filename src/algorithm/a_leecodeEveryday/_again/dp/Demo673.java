package algorithm.a_leecodeEveryday._again.dp;
import java.util.*;
public class Demo673 {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        String s = "abcdefg";

        System.out.println(s.substring(0,2).equals("ab"));
    }
    //673. 最长递增子序列的个数 reutrn max
    public static int findNumberOfLIS(int[] nums) {
        if(nums.length==1)return 1;
        //第i位有几种最大的子序列
        int[] len = new int[nums.length];
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        Arrays.fill(len, 1);
        int max = 0;
        for(int i = 1;i < dp.length;i++){
            for(int j = 0;j < i;j++){
                if(nums[i] > nums[j]){
                    if(dp[j] + 1 > dp[i]){
                        dp[i] = dp[j] + 1;
                        len[i] = len[j];
                    }else if(dp[j] + 1 == dp[i]){
                        len[i] += len[j];
                    }
                }

            }
            max = Math.max(max,dp[i]);
        }
        System.out.println(max);
        int sum = 0;
        for(int i = 0;i < dp.length;i++){
            if(dp[i] == max){
                sum += len[i];
            }
        }
        return sum;
    }
}
