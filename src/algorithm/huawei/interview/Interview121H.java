package algorithm.huawei.interview;

import java.util.Scanner;

/**
 * 比较两个版本号的大小
 * 输入两个版本号 version1 和 version2，每个版本号由多个子版本号组成。
 * 子版本号之间由 “.” 隔开，由大小写字母、数字组成，并且至少有一个字符。 按从左到右的顺序比较子版本号，
 * 比较规则如下:
 * 子版本号前面的0不参与比较，比如 001 和 1 是相等的。
 * 小写字母 > 大写字母 > 数字
 * 空字符和0相等，比如 1 和 1.0 相等
 *  如果 version1 > version2 ，返回 1
 *  如果 version1 < version2 ，返回-1 其他情况返回0
 5.2
 5.1a
 =>1
 5.6.1
 5.6.2a
 =>-1
 5.6.8.a
 5.6.8.0a
 =>0
 */
public class Interview121H {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split1 = scanner.nextLine().trim().split("\\.");
        String[] split2 = scanner.nextLine().trim().split("\\.");
        for (int i = 0; i < split1.length && i < split2.length; i++) {
            int res = check(split1[i],split2[i]);
            if(res != 0){
                System.out.println(res);
                return;
            }
        }
        if(split1.length < split2.length){
            for (int i = split1.length; i < split2.length; i++) {
                int res = check("0",split2[i]);
                if(res != 0){
                    System.out.println(res);
                    return;
                }
            }
        }else if(split1.length > split2.length){
            for (int i = split2.length; i < split1.length; i++) {
                int res = check(split1[i],"0");
                if(res != 0){
                    System.out.println(res);
                    return;
                }
            }
        }
        System.out.println(0);
    }
    private static int check(String a, String b) {
        a = rebuild(a);
        b = rebuild(b);
        if(a.length() == 0 && b.length() == 0)return 0;
        for (int i = 0; i < a.length() && i < b.length(); i++) {
            if(a.charAt(i) > b.charAt(i))return 1;
            else if(a.charAt(i) < b.charAt(i))return -1;
        }
        if(a.length() < b.length())return -1;
        if(a.length() > b.length())return 1;
        return 0;
    }

    private static String rebuild(String a) {
        if(a.length() == 0)return a;
        int start = 0;
        while(start <a.length() && a.charAt(start) == '0')start++;
        return a.substring(start);



//        Scanner in = new Scanner(System.in);
//        String v1 = in.next();
//        String v2 = in.next();
//        String[] arr1 = v1.split("\\.");
//        String[] arr2 = v2.split("\\.");
//        int len1 = arr1.length;
//        int len2 = arr2.length;
//        for (int i = 0; i < len1 && i < len2; i++) {
//            int res = helper(arr1[i], arr2[i]);
//            if (res != 0) {
//                System.out.println(res);
//                return; }
//        }
//        if (len1 > len2) {
//            int k = len2;
//            while (k < len1) {
//                int res = helper(arr1[k], "");
//                if (res != 0) {
//                    System.out.println(res);
//                    return; }
//                k++; }
//            System.out.println(0);
//            return; }
//        if (len2 > len1) {
//            int k = len1;
//            while (k < len2) {
//                int res = helper("", arr2[k]);
//                if (res != 0) {
//                    System.out.println(res);
//                    return; }
//                k++; }
//            System.out.println(0);
//            return; }
//        System.out.println(0);
//    }
//    public static int helper(String v1, String v2) {
//        StringBuilder sb1 = new StringBuilder(v1);
//        while (sb1.length() > 0 && sb1.charAt(0) == '0') {
//            sb1.deleteCharAt(0);
//        }
//        StringBuilder sb2 = new StringBuilder(v2);
//        while (sb2.length() > 0 && sb2.charAt(0) == '0') {
//            sb2.deleteCharAt(0);
//        }
//        for (int i = 0; i < sb1.length() && i < sb2.length(); i++) {
//            if (sb1.charAt(i) > sb2.charAt(i)) return 1;
//            else if (sb1.charAt(i) < sb2.charAt(i)) return -1;
//        }
//        int len1 = sb1.length();
//        int len2 = sb2.length();
//        if (len1 > len2) {
//            int k = len2;
//            while (k < len1) {
//                if (sb1.charAt(k) > '0') return 1;
//                k++; }
//            return 0; }
//        if (len2 > len1) {
//            int k = len1;
//            while (k < len2) {
//                if (sb2.charAt(k) > '0') return -1;
//                k++;
//            }
//            return 0; }
//        return 0;
    }

}
