package algorithm.huawei.interview;

import java.util.Scanner;

/**
 * 猴子爬山
 *  一天一只顽猴想去从山脚爬到山顶，途中经过一个有个N个台阶的阶梯，但是这猴子有一个习惯:
 *  每一次只能跳1步或跳3步，试问猴子通过这个阶梯有多少种不同的跳跃方式?
 *
 *  输入只有一个整数N(0<N<=50)此阶梯有多少个台阶。
 *  输出有多少种跳跃方式(解决方案数)。
 50
 =》122106097
 3
 =》2
 */
public class Interview99 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine().trim());
        System.out.println(fun(n));
    }

    private static int fun(int n) {
        if(n == 1 || n == 2)return 1;
        if(n == 3)return 2;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;
        for (int i = 4; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-3];
        }
        return dp[n];
    }
}
