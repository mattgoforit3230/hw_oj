package algorithm.huawei.interview;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 【编程题目 | 200分】叠积木 [ 2022 4月 考试题 ]
 * 积木宽高相等，长度不等，每层只能放一个或拼接多个积木，每层长度相等，求最大层数，最少2层。
 * 组成一面墙的最小层数。
 * 墙只能由高和宽相对堆叠。 输入:给定一组数据，用空格分开(应该是宽度，记不清了) 例如:
 * 输入
 * 3 6 3 3 3
 * 输出
 * 3
 * 解释:以 6 为底的墙，第一层为 6 ，第二层为 3 + 3 第三层 3 + 3 输入
 * 1 2 2 2 2 3 => 3
 * 9 9 9 5 3 2 2 2 2 2 => 5
 * 参考[698. 划分为k个相等的子集]
 */
public class Interview23H {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine().trim();
        String[] split = s.split(" ");
        int n = split.length;
        int[] nums = new int[n];
        int sum = 0;

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(split[i]);
            sum += nums[i];
        }
        Arrays.sort(nums);
        for (int i = sum; i >= 2; i--) {
            if(helper(nums,i)){
                System.out.println(i);
                return;
            }
        }
        System.out.println(-1);
    }
    public static boolean helper(int[] nums, int k) {
        int n = nums.length;
        int N = 1 << n;
        int sum = 0;
        for(int num:nums)sum += num;
        if(sum % k != 0)return false;
        int target = sum / k;
        //i表示选取了哪几个数，true为这几个数可组成target
        boolean[] dp = new boolean[N];
        int[] curSum = new int[N];
        dp[0] = true;
        for(int i = 0;i < N;i++){
            if(!dp[i])continue;
            //添加的数
            for(int j = 0;j < n;j++){
                if((i & 1 << j) != 0)continue;
                int next = i | 1 << j;
                if(dp[next])continue;
                if((curSum[i] % target) + nums[j] <= target){
                    dp[next] = true;
                    curSum[next] = curSum[i] + nums[j];
                }else{
                    break;
                }
            }
        }
        return dp[N-1];
    }
}
