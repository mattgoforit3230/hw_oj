package algorithm.huawei.interview;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 用户调度问题
 在通信系统中，一个常⻅的问题是对用户进行不同策略的调度，会得到不同的系统消耗和性能。
 假设当前有n个待串行调度用户，每个用户可以使用A/B/C三种不同的调度策略，不同的策略会消耗不
 同的系统资源。请你根据如下规则进行用户调度，并返回总的消耗资源数。
 规则:
 1. 相邻的用户不能使用相同的调度策略，例如，第1个用户使用了A策略，则第2个用户只能使用B或 者C策略。
 2. 对单个用户而言，不同的调度策略对系统资源的消耗可以归一化后抽象为数值。例如，某用户分 别使用A/B/C策略的系统消耗分别为15/8/17。
 3. 每个用户依次选择当前所能选择的对系统资源消耗最少的策略(局部最优)，如果有多个满足要 求的策略，选最后一个。
 3
 15 8 17
 12 20 9
 11 7 5
 */
public class Interview18 {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int N = Integer.parseInt(scanner.nextLine().trim());
//        int[][] nums = new int[N][3];
//        for (int i = 0; i < N; i++) {
//            for(int j = 0;j < 3;j++){
//                nums[i][j] = scanner.nextInt();
//            }
//        }
//        int res = 0;
//        int preIndex = -1;
//        for (int i = 0; i < N; i++) {
//            int temp = 0;
//            int curIndex = 0;
//            for(int j = 0;j < 3;j++){
//                if((temp == 0 && preIndex!=j) || nums[i][j] <= temp && preIndex!=j){
//                    temp = nums[i][j];
//                    curIndex = j;
//                }
//            }
//            preIndex = curIndex;
//            res += temp;
//        }
//        System.out.println(res);
//    }

    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            while (sc.hasNext()) {
                int userNum = sc.nextInt();
                int[][] res = new int[userNum][3];
                for(int i=0;i<userNum;i++) {
                    for(int j=0;j<3;j++) {
                        res[i][j] = sc.nextInt();
                    }
                }
                jobDispatch(res,userNum);
            }
            sc.close();
        }
        public static void jobDispatch(int[][] res,int userNum) {
            // 使用二维数组保存状态：每个维度的含义分别是：[当前用户ID][所选的任务策略：A为0、B为1,、C为2],
            // 默认从下标1开始,所以是4
            int[][] dp = new int[userNum+1][4];
            for(int[] temp : dp) {
                Arrays.fill(temp,Integer.MAX_VALUE);
            }
            // result用来存放不同用户数量时的最小结果:比如result[0]就是只有一个用户时的最小消耗
            int[] result = new int[userNum];
            Arrays.fill(result,Integer.MAX_VALUE);
            // 边界值,初始化第一个用户选择各种策略的总消耗
            for(int index=1;index <= 3;index++) {
                dp[1][index] = res[0][index-1];
                result[0] = Math.min(result[0],dp[1][index]);
            }
            dp[0][0] = 0;

            // 因为前面用户选了某个策略，后面的用户就只能选不同的；所以对应了后面用户其实有三种选择情况
            // 所有用户都可以在前面的用户选择后递推出自己的最优消耗
            for(int i=2;i<=userNum;i++) {
                dp[i][1] = Math.min(dp[i-1][2],dp[i-1][3]) + res[i-1][0];
                dp[i][2] = Math.min(dp[i-1][1],dp[i-1][3]) + res[i-1][1];
                dp[i][3] = Math.min(dp[i-1][1],dp[i-1][2]) + res[i-1][2];
                result[i-1] = Math.min(result[i-1],Math.min(Math.min(dp[i][1],dp[i][2]),dp[i][3]));
            }
            System.out.println(result[userNum-1]);
        }
}
