package algorithm.huawei.interview;

import java.util.Scanner;

/**
 * 停⻋场⻋辆统计】
 * 特定大小的停⻋场，数组cars[]表示，其中1表示有⻋，0表示没⻋。
 * ⻋辆大小不一，小⻋占一个⻋位(⻓度1)，货⻋占两个⻋位(⻓度2)，卡⻋占三个⻋位(⻓度3)。
 * 统计停⻋场最少可以停多少辆⻋，返回具体的数目。
 * 输入描述:
 * 整型字符串数组cars[]，其中1表示有⻋，0表示没⻋，数组⻓度小于1000。
 * 输出描述:
 *  整型数字字符串，表示最少停⻋数目。
 */
public class Interview7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] splits = s.replace(",", "").split("0+");
        int res = 0;
        for (String split : splits) {
            int n = split.length();
            res += (n + 2) / 3;
        }
        System.out.println(res);
//        Scanner scan = new Scanner(System.in);
//        while (scan.hasNext()) {
//            String line = scan.next();
//            if (line.split(",").length >= 1000) {
//                System.out.println(0);
//                continue; }
//            int result = 0;
//            String[] split = line.replaceAll(",", "").split("0+");
//            if (split.length != 0) {
//                for (String temp : split) {
//                    result += calculate(temp.length());
//                } }
//            System.out.println(result);
//        }
//    }
//    private static int calculate(int length) {
//        //return (length + 2) / 3;
//        return (length >= 1 && length <= 3) ? 1 : (int) Math.ceil(length / 3.0);
    }
}
