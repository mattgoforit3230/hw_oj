package algorithm.huawei.newcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 */
public class HJ24 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        int[] ints = new int[N];
        for (int i = 0; i < N; i++) {
            ints[i] = scanner.nextInt();
        }
        int res = N;
        int[] dp1 = new int[N];
        Arrays.fill(dp1,1);
        for(int j = 1;j < N;j++){
            for(int k = 0;k < j;k++){
                if(ints[k] < ints[j])dp1[j] = Math.max(dp1[k] + 1,dp1[j]);
            }
        }
        int[] dp2 = new int[N];
        Arrays.fill(dp2,1);
        for(int j = N-1;j >= 0;j--){
            for(int k = N-1;k > j;k--){
                if(ints[k] < ints[j])dp1[j] = Math.max(dp2[k] + 1,dp2[j]);
            }
        }
        for(int i = 0;i < N;i++){
            res = Math.min(res,N - dp1[i]-dp2[i] + 1);
        }
        System.out.println(res);
    }
}
