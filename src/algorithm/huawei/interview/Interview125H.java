package algorithm.huawei.interview;

import java.util.Scanner;

/**
 * 移除 K 位数字的最小值
 * 第一行输入一个非负整数字符串，第二行输入一个整数n
 * 输出从该字符串中取出n个字符后剩下的字符组成的最小的数(不改变字符顺序)

 2615371
 4
 =>131
 6525441
 4
 =>241
 */
public class Interview125H {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine().trim();
        int k = scanner.nextInt();
        while(k > 0 && fun(s).length() != s.length()){
            s = fun(s);
            k--;
        }
        if(k ==0) System.out.println(s);
        else System.out.println(s.substring(0,s.length()-k));
    }
    //删除1位可以得到的最小值
    private static String fun(String s) {
        StringBuilder res = new StringBuilder(s);
        for (int i = 0; i < s.length()-1; i++) {
            if(s.charAt(i) > s.charAt(i+1)){
                res.deleteCharAt(i);
                return res.toString();
            }
        }
        return s.substring(0,s.length()-1);
    }
}
