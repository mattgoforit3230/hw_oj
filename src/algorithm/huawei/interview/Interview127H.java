package algorithm.huawei.interview;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 叠书
 * 给定一组书的⻓宽，并且只有当一本书的⻓宽同时小于另一本书的⻓宽时，两书才能叠放在一起，
 * 求该组书中最多能有多少本书叠放在一起。
 */
public class Interview127H {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //String s = scanner.nextLine().trim();
        int[][] ints = new int[][]{{20,16},{15,11},{10,10},{9,10}};
        System.out.println(fun(ints));//3
    }
    public static int fun(int[][] ints){
        int n = ints.length;
        for (int i = 0; i < n; i++) {
            if(ints[i][0] < ints[i][1]){
                int temp = ints[i][0];
                ints[i][0] = ints[i][1];
                ints[i][1] = temp;
            }
        }
        Arrays.sort(ints,(a,b)->{
            if(a[0] == b[0])return b[1] - a[1];
            else return a[0] - b[0];
        });
        int[] dp = new int[n];
        int res = 1;
        Arrays.fill(dp,1);
        for (int i = 0; i < n; i++) {
            for(int j = i + 1;j < n;j++){
                if(ints[j][1] > ints[i][1])dp[j] = Math.max(dp[j],dp[i] + 1);
                res = Math.max(res,dp[j]);
            }
        }
        return res;
    }
}
