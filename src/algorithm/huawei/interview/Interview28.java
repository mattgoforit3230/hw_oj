package algorithm.huawei.interview;

import java.util.Scanner;

/**
 * 【28 最⻓连续子序列】
 *最⻓连续子序列】
 * 有N个正整数组成的一个序列。给定整数sum，求⻓度最⻓的连续子序列，使他们的和等于sum
 * ，返回 此子序列的⻓度，如果没有满足要求的序列，返回-1。
 */
public class Interview28 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine().trim();
        int target = Integer.parseInt(scanner.nextLine().trim());
        String[] split = s.split(",");
        int res = -1;
        for(int i = 0;i < split.length;i++){
            int temp = target;
            for(int j = i;j < split.length;j++){
                temp -= Integer.parseInt(split[j]);
                if(temp == 0){
                    res = Math.max(res,j - i + 1);
                }
            }
        }
        System.out.println(res);
    }
}
