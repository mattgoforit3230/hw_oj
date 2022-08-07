package algorithm.huawei.interview;

import java.util.Scanner;

/**
 * 计算最大乘积
 *  给定一个元素类型为小写字符串的数组，请计算两个没有相同字符的元素⻓度乘积的最大值，
 *  如果没有符合条件的两个元素，返回0。
 *
 *  输入为一个半⻆逗号分隔的小写字符串的数组，2 <= 数组⻓度<=100，0 < 字符串⻓度<= 50
 *  两个没有相同字符的元素 ⻓度乘积的最大值。
暴力
 iwdvpbn,hk,iuop,iikd,kadgpf
 =》14 （iwdvpbn * hk）
 */
public class Interview101 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine().trim();
        String[] split = str.split(",");
        int res = 0;
        for (int i = 0; i < split.length; i++) {
            for (int j = i+1; j < split.length; j++) {
                if(check(split[i],split[j])){
                    res = Math.max(res,split[i].length() * split[j].length());
                }
            }
        }
        System.out.println(res);
    }

    private static boolean check(String a, String b) {
        int[] ints = new int[26];
        for (int i = 0; i < a.length(); i++) {
            ints[a.charAt(i)-'a']++;
        }
        for (int i = 0; i < b.length(); i++) {
            if(ints[b.charAt(i) - 'a']!=0)return false;
        }
        return true;
    }
}
