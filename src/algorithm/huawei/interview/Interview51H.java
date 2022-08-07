package algorithm.huawei.interview;

import java.util.Scanner;

/**
 * 【字符串比较】
 *给定字符串A、B和正整数V，A的⻓度与B的⻓度相等， 请计算A中满足如下条件的最大连续子串的⻓度:
 * 1、该连续子串在A和B中的位置和⻓度均相同。
 * 2、该连续子串|A[i] – B[i]|之和小于等于V。其中|A[i] – B[i]|表示两个字母ASCII码之差的绝对值。
 xxcdefg
 cdefghi
 5
 =》2
 */
public class Interview51H {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String A = scanner.nextLine().trim();
        String B = scanner.nextLine().trim();
        int V = Integer.parseInt(scanner.nextLine().trim());
        int[] diff = new int[A.length()];
        for (int i = 0; i < A.length(); i++) {
            diff[i] = Math.abs(A.charAt(i) - B.charAt(i));
        }
        int sum = 0,res = 0;
        //滑动窗口
        for(int l = 0,r = 0;r < A.length();r++){
            sum += diff[r];
            while(sum > V){
                sum -= diff[l++];
            }
            res = Math.max(res,r - l + 1);
        }
        System.out.println(res);
    }
}
