package algorithm.huawei.interview;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 111 组成最大数
 * 小组中每位都有一张卡片，卡片上是6位内的正整数，将卡片连起来可以组成多种数字，计算组成的最大数字。
 * 输入：
 * “,”号分割的多个正整数字符串，不需要考虑非数字异常情况，小组最多25个人
 * 输出
 * 最大的数字字符串
 22,221
 =》22221
 4589,101,41425,9999
 =》9999458941425101
 */
public class Interview111 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().trim().split(",");
        Arrays.sort(split,(a,b)->(b+a).compareTo(a+b));
        StringBuilder res = new StringBuilder();
        for(String temp:split)res.append(temp);
        System.out.println(res);
    }
}
