package algorithm.a_leecodeEveryday.a_demo2022_1;

public class CglibProxy {
    public static void main(String[] args) {

//        int maxValue = getMaxValue(new int[]{1, 3, 5, 2, 4}, new int[]{1, 2, 3, 4, 5});
        //4 2 100 1 3 values = 4 3 100 2 1
        int maxValue = getMaxValue(new int[]{4,2 ,100, 1, 3}, new int[]{4, 3 ,100 ,2 ,1});
        System.out.println(maxValue);
    }
    public static int getMaxValue (int[] nums, int[] values) {
        // write code here[1,3,5,2,4],[1, 2 ,3,4,5]
//        int[][] dp = new int[nums.length][nums.length];
//        for (int time = 0; time < nums.length; time++) {
//            for (int i = 0; i < nums.length; i++) {
//                //time 0, i 0, j length-1
//                //time 1, i 1, j length-1
//                //time 1, i 0, j length-2
//                //j-i = length-time-1
//                int j = nums.length-1-time+i;
//                if(i>=j)break;
//                if(time == 0){
//                    dp[i][j] = nums[i]*values[values.length-1];
//                }else {
//                    dp[i][j] = Math.max(dp[i + 1][j] + nums[i] * values[time],
//                            dp[i][j - 1] + nums[j - 1] * values[time]);
//                }
//            }
//        }
//        return dp[0][nums.length-1];





        int[][] dp = new int[nums.length][nums.length];
        //dp[i][j] = Math.max(dp[i + 1][j]+nums[i]*values[k],dp[i][j-1]+nums[j]*values[k])
        for (int l = 0; l < nums.length; l++) {
            for (int m = 0; m < nums.length; m++) {
                int k = m + l;
                if(k >= nums.length)break;
                if(l == 0){
                    dp[m][k] = nums[m] * values[nums.length-1-l];
                }else{
                    //dp[m][k] = Math.max(dp[m + 1][k]+nums[m]*values[nums.length-1-l],dp[m][k-1]+nums[k]*values[nums.length-1-l]);
                    dp[m][k] = Math.max(dp[m + 1][k]+nums[m] * values[nums.length-1-l],
                            dp[m][k-1] + nums[k]*values[nums.length-1-l]);

                }
            }
        }
        return dp[0][nums.length-1];
    }

}
