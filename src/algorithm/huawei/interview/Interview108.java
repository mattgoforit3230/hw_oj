package algorithm.huawei.interview;

import java.util.Scanner;

/**
 * 玩牌高手
 *  给定一个⻓度为n的整型数组，表示一个选手在n轮内可选择的牌面分数。选手基于规则选牌，请计算所有轮结束后其可以获得的最高总分数。
 *  选择规则如下:
 * 1. 在每轮里选手可以选择获取该轮牌面，则其总分数加上该轮牌面分数，为其新的总分数。
 * 2. 选手也可不选择本轮牌面直接跳到下一轮，此时将当前总分数还原为3轮前的总分数，
 * 若当前轮次小于等于3(即在第1、2、3轮选择跳过轮次)，则总分数置为0。 3. 选手的初始总分数为0，且必须依次参加每一轮。
 1,-5,-6,4,3,6,-2
 =>11
 */
public class Interview108 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().trim().split(",");
        int n = split.length;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            if(split[i].charAt(0) == '-')
                nums[i] = -1 * Integer.parseInt(split[i].substring(1));
            else nums[i] = Integer.parseInt(split[i]);
        }
        int[] dp = new int[n];
        dp[0] = Math.max(0,nums[0]);
        for (int i = 1; i < n; i++) {
            if(i < 3)dp[i] = Math.max(dp[i-1]+nums[i],0);
            else dp[i] = Math.max(dp[i-1]+nums[i],dp[i-3]);
        }
        System.out.println(dp[n-1]);
    }
}
