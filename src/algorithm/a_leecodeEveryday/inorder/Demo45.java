package algorithm.a_leecodeEveryday.inorder;

public class Demo45 {
    public static void main(String[] args) {
        System.out.println(jump(new int[]{2,3,1,1,4,23,4}));
    }
    //45. 跳跃游戏 II
    public static int jump(int[] nums) {
        //动态规划
//        int[] dp = new int[nums.length];
//        for (int i = 0; i < dp.length; i++) {
//            dp[i] = Integer.MAX_VALUE;
//        }
//        dp[0] = 0;
//        //dp代表该位置的最小跳跃数
//        for (int i = 0; i < nums.length; i++) {
//
//            //覆盖的
//            for (int add = 1; add <= nums[i] && add+i<nums.length; add++) {
//                dp[add+i] = Math.min(dp[i]+1,dp[add+i]);
//            }
//        }
//        return  dp[nums.length-1];

        //贪心算法
        int  pos = 0;
        int res = 0;
        while(pos < nums.length-1){
            if(pos+nums[pos]>=nums.length-1){
                //pos = nums.length-1;
                res++;
                break;
            }
            int border = pos+nums[pos];
            for (int i = pos+1; i <= Math.min(border,nums.length-1) ; i++) {
                if(i+nums[i] > pos+nums[pos]){
                    pos = i;
                }
            }
            res++;
        }
        return res;
    }
}
