package algorithm.huawei.interview;

import java.util.Scanner;

/**
 * 字符串变换最小字符串
 * 给定一个字符串s，最多只能进行一次变换，返回变换后能得到的最小字符串(按照字典序进行比 较)。
 * 变换规则:交换字符串中任意两个不同位置的字符。
 *
 * 一串小写字母组成的字符串s
 * 按照要求进行变换得到的最小字符串
 abcdef
 =>abcdef
 bcdefa
 =>acdefb
 */
public class Interview116 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine().trim();
        System.out.println(fun(s));
    }
    private static String fun(String s) {
        StringBuilder sb = new StringBuilder(s);
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i+1; j < n; j++) {
                if(s.charAt(min) > s.charAt(j))min = j;
            }
            if(min != i){
                char cm = s.charAt(min);
                char ci = s.charAt(i);
                sb.setCharAt(i,cm);
                sb.setCharAt(min,ci);
                return sb.toString();
            }
        }
        return s;
    }
}
