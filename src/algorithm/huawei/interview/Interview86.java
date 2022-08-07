package algorithm.huawei.interview;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * 补种未成活胡杨
 * 近些年来，我国防沙治沙取得显著成果。某沙漠新种植N棵胡杨(编号1-N)，排成一排。
 * 一个月后，有M棵胡杨未能成活。 现可补种胡杨K棵，请问如何补种(只能补种，不能新种)，可以得到最多的连续胡杨树?
 *  N 总种植数量
 * M 未成活胡杨数量
 * M 个空格分隔的数，按编号从小到大排列 K 最多可以补种的数量
 *  1 <= N <= 100000 1 <= M <= N
 * 0 <= K <= M
 5
 2
 2 4
 1
 => 3
 10
 3
 2 4 7
 1
 => 6
 */
public class Interview86 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine().trim());
        int M = Integer.parseInt(scanner.nextLine().trim());
        String[] split = scanner.nextLine().trim().split("\\s+");
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < M; i++) {
            int a = Integer.parseInt(split[i]);
            set.add(a);
        }
        int res = 0;
        int K = Integer.parseInt(scanner.nextLine().trim());
        for (int l = 1,r = 1; r <= N; r++) {
            if(set.contains(r))K--;
            if(K < 0){
                while(!set.contains(l++));
                K++;
            }
            res = Math.max(r - l +1,res);
        }
        System.out.println(res);
    }
}
